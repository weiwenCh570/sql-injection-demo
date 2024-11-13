// const modal = document.getElementById("myModal");
// let currentAction = 'add';
// let currentItemIndex = -1;
//
// document.getElementById('inventoryForm').addEventListener('submit', function(e) {
//     e.preventDefault();
//     if (currentAction === 'add') {
//         addItem();
//     } else {
//         updateItem();
//     }
// });
//
// function openModal(action, button) {
//     currentAction = action;
//     const modalTitle = document.getElementById('modalTitle');
//     const submitButton = document.getElementById('submitButton');
//     if (action === 'add') {
//         modalTitle.textContent = 'Add Inventory Item';
//         submitButton.textContent = 'Add Item';
//         document.getElementById('inventoryForm').reset();
//     } else {
//         modalTitle.textContent = 'Update Inventory Item';
//         submitButton.textContent = 'Update Item';
//         const row = button.parentNode.parentNode;
//         currentItemIndex = row.rowIndex - 1;
//         document.getElementById('itemName').value = row.cells[0].textContent;
//         document.getElementById('quantity').value = row.cells[1].textContent;
//         document.getElementById('price').value = row.cells[2].textContent;
//         document.getElementById('discountPrice').value = row.cells[3].textContent;
//         document.getElementById('expiryDate').value = row.cells[4].textContent;
//         // document.getElementById('status').value = row.cells[5].textContent;
//     }
//     modal.style.display = "block";
// }
//
// function closeModal() {
//     modal.style.display = "none";
// }
//
// function addItem() {
//     const itemName = document.getElementById('itemName').value;
//     const quantity = document.getElementById('quantity').value;
//     const price = document.getElementById('price').value;
//     const discountPrice = document.getElementById('discountPrice').value;
//     const expiryDate = document.getElementById('expiryDate').value;
//     // const status = document.getElementById('status').value;
//     const table = document.getElementById('inventoryTable').getElementsByTagName('tbody')[0];
//     const newRow = table.insertRow();
//
//     const cell1 = newRow.insertCell(0);
//     const cell2 = newRow.insertCell(1);
//     const cell3 = newRow.insertCell(2);
//     const cell4 = newRow.insertCell(3);
//     const cell5 = newRow.insertCell(4);
//     const cell6 = newRow.insertCell(5);
//     // const cell7 = newRow.insertCell(6);
//
//     cell1.innerHTML = itemName;
//     cell2.innerHTML = quantity;
//     cell3.innerHTML = price;
//     cell4.innerHTML = discountPrice;
//     cell5.innerHTML = expiryDate;
//     // cell6.innerHTML = status;
//     cell7.innerHTML = `
//             <button class="btn btn-update" onclick="openModal('update', this)">Update</button>
//             <button class="btn btn-warning" onclick="markAsSurplus(this)">Surplus</button>
//             <button class="btn btn-danger" onclick="deleteItem(this)">Delete</button>
//         `;
//
//     closeModal();
// }
//
// function updateItem() {
//     const itemId = document.getElementById("")
//     const itemName = document.getElementById('itemName').value;
//     const quantity = document.getElementById('quantity').value;
//     const price = document.getElementById('price').value;
//     const discountPrice = document.getElementById('discountPrice').value;
//     const expiryDate = document.getElementById('expiryDate').value;
//     // const status = document.getElementById('status').value;
//     const table = document.getElementById('inventoryTable').getElementsByTagName('tbody')[0];
//     const row = table.rows[currentItemIndex];
//
//     row.cells[1].innerHTML = itemName;
//     row.cells[2].innerHTML = quantity;
//     row.cells[3].innerHTML = price;
//     row.cells[4].innerHTML = discountPrice;
//     row.cells[5].innerHTML = expiryDate;
//     // row.cells[5].innerHTML = status;
//
//     closeModal();
// }
//
// function deleteItem(button) {
//     if (confirm("Are you sure you want to delete this item?")) {
//         const row = button.parentNode.parentNode;
//         row.parentNode.removeChild(row);
//     }
// }
//
// function markAsSurplus(button) {
//     const row = button.parentNode.parentNode;
//     row.style.backgroundColor = '#ff9800';
//     row.style.color = 'white';
//     button.disabled = true;
// }
//
//
// window.onclick = function(event) {
//     if (event.target == modal) {
//         closeModal();
//     }
// }