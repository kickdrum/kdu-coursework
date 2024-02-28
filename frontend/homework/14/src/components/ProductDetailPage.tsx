import { ProductsContext } from "../ProductsContext";
import { useContext } from "react";
import { useNavigate, useParams } from "react-router-dom";
import './ProductDetailPage.scss'

export function ProductDetailPage() {

    const navigate= useNavigate();
    const { list }= useContext(ProductsContext);
    const { id } = useParams();

    const back=()=>{
        navigate(-1);
    }

    const product = list.filter((product) => (product.id + "") === id)[0];
    console.log("This is product:", id);


  return (
    <div>
        <p>{product?.title}</p>
        <div>
            <img src={product?.image} alt="product image"/>
            <div>
                <p>Price : $ {product?.price}</p>
                <p>Rating : {product?.rating.rate}</p>
                <p>Product Description: </p>
                <p>{product?.description}</p>
                <button onClick={back}>Back To Products</button>
            </div>
        </div>
    </div>
  )
}
