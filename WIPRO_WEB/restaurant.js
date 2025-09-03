let menuItems = JSON.parse(localStorage.getItem('menuItems')) || [];


function apiCreateItem(item) {
    return new Promise((resolve) => {
        setTimeout(() => {
            menuItems.push(item);
            localStorage.setItem('menuItems', JSON.stringify(menuItems));
            resolve(item);
        }, 300);
    });
}

function apiGetAllItems() {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve(menuItems);
        }, 300);
    });
}

function apiUpdateItem(index, updatedItem) {
    return new Promise((resolve) => {
        setTimeout(() => {
            menuItems[index] = updatedItem;
            localStorage.setItem('menuItems', JSON.stringify(menuItems));
            resolve(updatedItem);
        }, 300);
    });
}

function apiDeleteItem(index) {
    return new Promise((resolve) => {
        setTimeout(() => {
            menuItems.splice(index, 1);
            localStorage.setItem('menuItems', JSON.stringify(menuItems));
            resolve();
        }, 300);
    });
}

// Render Menu
function renderMenu() {
    apiGetAllItems().then(items => {
        const tbody = document.getElementById('menuTableBody');
        tbody.innerHTML = '';
        items.forEach((item, index) => {
            tbody.innerHTML += `
                <tr>
                    <td>${item.name}</td>
                    <td>${item.description}</td>
                    <td>${item.category}</td>
                    <td>₹${item.price}</td>
                    <td>${item.availability}</td>
                    <td class="actions">
                        <button class="edit" onclick="editItem(${index})">Edit</button>
                        <button class="delete" onclick="deleteItem(${index})">Delete</button>
                    </td>
                </tr>
            `;
        });
    });
}

// Add,Update Item
document.getElementById('menuForm').addEventListener('submit', function(e) {
    e.preventDefault();
    const name = document.getElementById('itemName').value;
    const description = document.getElementById('itemDescription').value;
    const category = document.getElementById('itemCategory').value;
    const price = document.getElementById('itemPrice').value;
    const availability = document.getElementById('itemAvailability').value;
    const editIndex = document.getElementById('editIndex').value;

    const newItem = { name, description, category, price, availability };

    if (editIndex === '') {
        apiCreateItem(newItem).then(() => renderMenu());
    } else {
        apiUpdateItem(editIndex, newItem).then(() => renderMenu());
        document.getElementById('editIndex').value = '';
    }

    this.reset();
});

// Edit Item
function editItem(index) {
    const item = menuItems[index];
    document.getElementById('itemName').value = item.name;
    document.getElementById('itemDescription').value = item.description;
    document.getElementById('itemCategory').value = item.category;
    document.getElementById('itemPrice').value = item.price;
    document.getElementById('itemAvailability').value = item.availability;
    document.getElementById('editIndex').value = index;
}

// Delete Item
function deleteItem(index) {
    if (confirm("Are you sure you want to delete this item?")) {
        apiDeleteItem(index).then(() => renderMenu());
    }
}

// Initial Render
renderMenu();
