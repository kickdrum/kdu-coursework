var ShoppingCart = /** @class */ (function () {
    function ShoppingCart() {
        this.items = [];
    }
    ShoppingCart.prototype.addItem = function (item) {
        this.items.push(item);
    };
    ShoppingCart.prototype.removeItem = function (itemName) {
        for (var i = 0; i < this.items.length; i++) {
            if (this.items[i].name === itemName) {
                this.items.slice(i, 1);
                break;
            }
        }
    };
    ShoppingCart.prototype.calculateTotal = function () {
        var price = 0;
        for (var i = 0; i < this.items.length; i++) {
            price = price + this.items[i].price;
        }
        return price;
    };
    return ShoppingCart;
}());
var cart = new ShoppingCart();
cart.addItem({ name: "Shirt", price: 20.2 });
cart.addItem({ name: "Pants", price: 30.6 });
cart.addItem({ name: "Shoes", price: 50.1 });
cart.removeItem("Pants");
console.log("Total price:", cart.calculateTotal());
