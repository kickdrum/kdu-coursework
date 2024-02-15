interface IItem{
    name: string,
    price:number
}

class ShoppingCart{
    items: IItem[];

    constructor(){
        this.items=[];
    }

    addItem(item: IItem){
        this.items.push(item);
    }

    removeItem(itemName: string){
        for(let i=0;i<this.items.length;i++){
            if(this.items[i].name===itemName){
                this.items.slice(i,1);
                break;
            }
        }
    }

    calculateTotal(){
        let price=0;
        for(let i=0;i<this.items.length;i++){
            price=price+this.items[i].price;
        }
        return price;
    }
}

const cart = new ShoppingCart();

cart.addItem({ name: "Shirt", price: 20.2 });
cart.addItem({ name: "Pants", price: 30.6 });
cart.addItem({ name: "Shoes", price: 50.1 });

cart.removeItem("Pants");

console.log("Total price:", cart.calculateTotal());