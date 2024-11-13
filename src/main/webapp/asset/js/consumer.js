/**
 * Name: Krish chaudhary
 * Course Name: OOPs with design Pattern
 * Project: Food Reduction Platform
 */
document.addEventListener('DOMContentLoaded', (event) => {
    var modal = document.getElementById("buyModal");
    var span = document.getElementsByClassName("close")[0];

    function updateTotalPrice() {
        var quantity = document.getElementById('quantity').value;
        var discountPrice = document.getElementById('discountPrice').value;
        var totalPrice = quantity * discountPrice;
        document.getElementById('totalPrice').value = totalPrice.toFixed(2);
    }

    document.querySelectorAll('.btn-buy').forEach(button => {
        button.addEventListener('click', function() {
            var row = this.closest('tr');
            var itemId = row.querySelector('td[data-label="Id"]').textContent.trim();
            var itemName = row.querySelector('td[data-label="Item Name"]').textContent;
            var quantity = row.querySelector('td[data-label="Quantity"]').textContent.trim();
            var discountPrice = row.querySelector('td[data-label="Discount Price"]').textContent;

            document.getElementById('itemName').value = itemName;
            document.getElementById('quantity').value = quantity;
            document.getElementById('discountPrice').value = discountPrice;
            document.getElementById("itemId").value = itemId;
            updateTotalPrice();
            modal.style.display = "block";
        });
    });

    span.onclick = function() {
        modal.style.display = "none";
    }

    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

    document.getElementById('quantity').addEventListener('input', updateTotalPrice);

    document.getElementById('confirmButton').addEventListener('click', function() {
        var itemName = document.getElementById('itemName').value;
        var quantity = document.getElementById('quantity').value;
        var discountPrice = document.getElementById('discountPrice').value;
        var totalPrice = document.getElementById('totalPrice').value;

        // Perform the necessary actions with the form data
        console.log(`Item Name: ${itemName}, Quantity: ${quantity}, Discount Price: ${discountPrice}, Total Price: ${totalPrice}`);

        modal.style.display = "none";
    });
});

