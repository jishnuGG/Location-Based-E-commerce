let cart = [];
let totalPrice = 0;

function addToCart(productName, productPrice) {
    cart.push({ name: productName, price: productPrice });
    totalPrice += productPrice;
    updateCartCount();
    console.log(`Added ${productName} to cart. Total price: $${totalPrice.toFixed(2)}`);
}

function updateCartCount() {
    const cartCountElement = document.getElementById('cart-count');
    cartCountElement.innerText = `(${cart.length})`;
}