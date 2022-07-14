
let apiUrl = 'http://localhost:8080/employee-reimbursement';


let principalString = sessionStorage.getItem('principal');
let principal = null;

let nav_right = document.getElementById("nav-right");
let nav_left = document.getElementById("nav-left");


if (principalString) {

    principal = JSON.parse(principalString);

    if (principal.role.user_role === 'manager') {
        createNavElement('All Employees', nav_left, 'allEmployees.html', null);
        createNavElement('Approve/Deny Request', nav_left, 'appDenRequest.html', null);
        createNavElement('Pending Reimbursements', nav_left, 'penReimbursements.html', null);
        createNavElement('Resolved Requests', nav_left, 'resReimbursements.html', null);
        createNavElement('Single Employee', nav_left, 'singleEmployee.html', null);
        createNavElement('Logout', nav_right, null, logout);
    }else{
    createNavElement('Submit Request', nav_left, 'submitRequest.html', null);
    createNavElement('Your Pending Requests', nav_left, 'employeePending.html', null);
    createNavElement('Your Resolved Requests', nav_left, 'employeeResolved.html', null);
    createNavElement('Your Info', nav_left, 'employeeInfo.html', null);
    createNavElement('Logout', nav_right, null, logout);
}
} else {
    createNavElement('Login', nav_right, 'loginPage.html', null);
}

async function logout() {

    
    let response = await fetch(`${apiUrl}/auth`, {
        method: 'DELETE',
        credentials: 'include'
    });

    if (response.status == 200) {
     
        sessionStorage.clear();
    
        principal = null;
        window.location.href="loginPage.html";
    } else {
        console.log('Unable to logout.')
    }
}

// Reusable function to create nav element in navbar
function createNavElement(innerHTML, parentElement, link, callback) {
    let li = document.createElement('li');
    // bootstrap class for styling
    li.setAttribute('class', 'nav-item');

    let a = document.createElement('a');
    // bootstrap class for styling
    a.setAttribute('class', 'nav-link');

    // if a link to a different page has been assigned, assign that link
    if (link) {
        a.setAttribute('href', link);
    } else {
        a.setAttribute('href', '#');
    }

    // if a callback function was passed in, assigns that function to the new element
    if (callback) {
        a.addEventListener('click', callback);
    }

    // Assigns nav-bar item name
    a.innerHTML = innerHTML;

    li.appendChild(a);

    parentElement.appendChild(li);
}