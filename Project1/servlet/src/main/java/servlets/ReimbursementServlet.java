package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dtos.CreateReimbursementDto;
import dtos.ReimbursementDto;
import dtos.UserDto;
import exceptions.ReimbursementNotCreatedException;
import exceptions.UserNotCreatedException;
import exceptions.UserNotFoundException;
import models.Reimbursement;
import models.User;
import services.ReimbursementService;
import services.ReimbursementStatusService;
import services.ReimbursementTypeService;
import services.UserService;
import util.CorsFix;

public class ReimbursementServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();
	private ReimbursementService rs = new ReimbursementService();
	private ReimbursementTypeService rts = new ReimbursementTypeService();
	private ReimbursementStatusService rss = new ReimbursementStatusService();
	
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");

		String pathInfo = req.getPathInfo();

	
		if (pathInfo == null) {

			List<Reimbursement> reimbursement = rs.getReimbursements();
			List<ReimbursementDto> reimbursementDto = new ArrayList<>();

			// converting Users to UserDTOs for data transfer
			reimbursement.forEach(r -> reimbursementDto.add(new ReimbursementDto(r)));

			// retrieving print writer to write to the Response body
			PrintWriter pw = res.getWriter();
			// writing toString representation of Users to body
			pw.write(om.writeValueAsString(reimbursementDto));

			pw.close();
			
		} else {
			// /1, /11, /{some-value}
			// Have to remove "/" to get the id to be retrieved
			int id = Integer.parseInt(pathInfo.substring(1));

			try (PrintWriter pw = res.getWriter()) {
				// retrieve user by id
				Reimbursement r = rs.getReimbursementById(id);
				ReimbursementDto rDto = new ReimbursementDto(r);

				// convert user to JSON and write to response body
				pw.write(om.writeValueAsString(rDto));

				res.setStatus(200);
			} catch (UserNotFoundException e) {
				// return 404, user not found
				res.setStatus(404);
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		

		InputStream reqBody = req.getInputStream();
		CreateReimbursementDto crd = om.readValue(reqBody, CreateReimbursementDto.class );
		Reimbursement createReimbursement = new Reimbursement();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		try {
			createReimbursement.setAmount(crd.getAmount());
			createReimbursement.setDescription(crd.getDescription());
			createReimbursement.setAuthor(us.getUserById(crd.getAuthorId()));
			createReimbursement.setReimbursementStatus(rss.getReimbursementStatusById(1));
			createReimbursement.setReimbursementType(rts.getReimbursementTypeById(crd.getReimbursementTypeId()));
			createReimbursement.setSubmitted(timestamp);
			Reimbursement newReimbursement = rs.createReimbursement(createReimbursement);
			try(PrintWriter pw = res.getWriter()){
				pw.write(1);
				res.setStatus(200);
			}
			
		} catch (Exception e) {
			res.setStatus(404);
		}

	}

		
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(),res);
		super.doOptions(req, res);
	}
	
	

}
