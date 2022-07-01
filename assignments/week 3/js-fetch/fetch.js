// document.getElementById('getData').onclick = getData;
document.getElementById('getData').addEventListener("click", getData);

/*
    - When button is clicked, send http request to API for a specific id

    - get the id value from input box
    - send request to PokeAPI
        - Method: GET
        - Headers: None
        - Body: None
        - url: https://pokeapi.co/api/v2/pokemon/ + id from input box
    - might have to convert JSON to JS object

    - populate the data in Section
*/
let baseApiURL = 'https://pokeapi.co/api/v2/pokemon';

async function getData() {
    console.log('Button was clicked!');
    let id = document.getElementById('dataInput').value;
    console.log(`id = ${id}`);

    let httpResponse = await fetch(`${baseApiURL}/${id}`);

    if(httpResponse.status >= 200 && httpResponse.status < 300){
    let data = await httpResponse.json();

    populateData(data);
    
    } else {
        console.log('Invalid request.');
    }
}

function populateData(response) {
    
    console.log(response);
let table = document.createElement('table');
let rows = 2;
let columns = 3;
for (var i = 0; i < rows; i++) {
    let tr;
    tr = document.createElement('tr');
    for (var j = 0; j < columns; j++) {
        var td;
        if (i === 0){ 
        td = document.createElement('th');
        if(j == 0){ td.innerHTML = 'Name'
        }else if (j == 1)
        { 
            td.innerHTML = 'Height'

        }else{
            td.innerHTML = 'Weight'
    }
        }else{ td = document.createElement('td');
        if(j == 0) td.innerHTML = response.name;
        else if(j == 1) td.innerHTML = response.height;
        else td.innerHTML = response.weight;
        
    }
        tr.appendChild(td);
    }
    
    table.appendChild(tr);
}
data.appendChild(table);

}

// let table = document.createElement('table');
// let thead = document.createElement('thead');
// let tbody = document.createElement('tbody');

// table.appendChild(thead);
// table.appendChild(tbody);

// document.getElementById('data').appendChild(table);

// let row1 = document.createElement('tr');
// let heading1 = document.createElement('th');
// heading1.innerHTML = "Name"
// let heading2 = document.createElement('th');
// heading2.innerHTML = "Height";
// let heading3 = document.createElement('th');
// heading3.innerHTML = "Weight";

// row1.appendChild(heading1);
// row1.appendChild(heading2);
// row1.appendChild(heading3);
// thead.appendChild(row1);

// let row2 = document.createElement('tr');
// let row2data1 = document.createElement('td');
// heading1.innerHTML = "N"
// let row2data2 = document.createElement('td');
// heading2.innerHTML = "Height";
// let row2data3 = document.createElement('th');
// heading3.innerHTML = "Weight";





var createTableBtn = document.getElementById('createTableButton');
var tableDiv = document.getElementById('tableDiv');

createTableBtn.onclick = createTable;

function createTable() {
    createTableBtn.removeEventListener('click', createTable);

    var table = document.createElement('table');
    var rows = 3;
    var cols = 3;
    for (var i = 0; i < rows; i++) {
        var tr;
        tr = document.createElement('tr');
        for (var j = 0; j < cols; j++) {
            var td;
            if (i === 0) td = document.createElement('th');
            else td = document.createElement('td');
            td.innerHTML = j;
            tr.appendChild(td);
        }
        
        table.appendChild(tr);
    }
    tableDiv.appendChild(table);

    createTableBtn.innerHTML = 'Remove Table';
    createTableBtn.onclick = removeTable;
}

function removeTable() {
    createTableBtn.removeEventListener('click', removeTable);
    tableDiv.innerHTML = '';
    createTableBtn.innerHTML = 'Create Table';
    createTableBtn.onclick = createTable;
}