package servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import exceptions.ReimbursementNotCreatedException;
import exceptions.UserNotCreatedException;
import models.Reimbursement;
import models.User;
import services.ReimbursementService;
import services.UserService;
import util.CorsFix;

public class ReimbursementServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ReimbursementService rs = new ReimbursementService();
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		

		InputStream reqBody = req.getInputStream();

	}

		/*
		 * try { rs.createReimbursement(newReimbursement);
		 * 
		 * res.setStatus(201); // Status: Created } catch
		 * (ReimbursementNotCreatedException e) {
		 * 
		 * res.sendError(400, "Unable to submit Reimbursement."); e.printStackTrace(); }
		 */
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(),res);
		super.doOptions(req, res);
	}

}
