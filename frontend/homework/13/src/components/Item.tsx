import { useContext } from "react";
import { Link, useParams } from "react-router-dom";
import { ProductListContext } from "../App";
import { Navigation } from "./Navigation";
import { IItem } from "./interfaces/APIInterfaces";

import "./styles/Item.scss"

export function Item() {
  const { id } = useParams();
  const { products } = useContext(ProductListContext);

  // Find the current product based on the id
  const current : IItem = products.find((data) => {
    return data.id === parseInt(id);
  });

  if (!current) {
    return <div>Product not found</div>;
  }

  return (
    <div >
        <Navigation></Navigation>
        <div className="content-container">
        <span className="title-up">{current.title}</span>
      {/* Render details of the current product */}
      <div className="item-display-container">
        <div className="left-container">
            <img src={current.image}></img>
        </div>
        <div className="right-container">
            <span className="category">Category : {current.category}</span>
            <div className="price_div">
                Price : {current.price}
            </div>
            <p>
                <p>    
                Product Description:
                </p>
                {current.description}
                <br></br>
                <br/>
                Rating : {current.rating.rate}
            </p>
            <Link to="/">
                <button>
                    Back to Products
                </button>
            </Link> 
        </div>
      </div>
        </div>
    </div>
  );
}
