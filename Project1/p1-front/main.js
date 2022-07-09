// Because main.js is the first script added to each HTML page, the logic declared here is shared/reused by all pages
let apiUrl = 'http://localhost:8080/employee-reimbursement';

// When logged in, retrieves the JSON string representing the logged in user from Session Storage
let principalString = sessionStorage.getItem('principal');
let principal = null;

let nav_right = document.getElementById("nav-right");
let nav_left = document.getElementById("nav-left");

// If principalString is a truthy value(non null), therefore exists
if (principalString) {
    // converts the JSON string back to a JS object and assigns it to principal
    principal = JSON.parse(principalString);

    if (principal.role === 'manager') {
        createNavElement('All Employees', nav_left, 'allEmployees.html', null);
        createNavElement('Reimbursements', nav_left, 'reimbursements.html', null);
        createNavElement('Resolved Requests', nav_left, './tasks.html', null);
        createNavElement('Logout', nav_right, null, logout);
    }else{
    createNavElement('Submit Request', nav_left, 'submitRequest.html', null);
    createNavElement('View Requests', nav_left, './tasks.html', null);
    createNavElement('Your Info', nav_left, './tasks.html', null);
    createNavElement('Logout', nav_right, null, logout);
}
} else {
    createNavElement('Login', nav_right, 'loginPage.html', null);
}

async function logout() {

    // Sends a DELETE request to API to invalidate session
    let response = await fetch(`${apiUrl}/auth`, {
        method: 'DELETE',
        credentials: 'include'
    });

    if (response.status == 200) {
        // clears user object JSON string in session storage
        sessionStorage.clear();
        // clears principal variable representing logged in user
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