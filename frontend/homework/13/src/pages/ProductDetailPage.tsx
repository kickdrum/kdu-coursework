
import { useContext } from "react";
import Navbar from "../components/NavbarDetails";
import { ProductContext } from "../context/ProductContext";
import {  useNavigate, useParams } from "react-router-dom";
import "../styles/ProductDetailPage.css"



function ProductDetailPage() {
  const { products, selectedProduct, setSelectedProduct } = useContext(ProductContext);
  const { id } = useParams();
  const product = products.find(
    (productItem) => productItem.id === Number(id)
  );
  if (product) {
    setSelectedProduct(product);
  }

  if (!selectedProduct || selectedProduct.id !== Number(id)) {
    return <p>Product not found</p>;
  }
  const { title, price, description, category, image, rating } = selectedProduct;


  const navigator = useNavigate();
  const BackNavigation = () => {  navigator(-1)
  }
  return (
    <div className="product-detail-page">
      <Navbar />
      <div className="product-heading">{ title}</div>
      <div className="product-detail-container">
        <div className="product-image"><img src={image} alt="product-image" /></div>
        <div className="product-description-container">
        <div className="product-description-heading">Product Description</div>
          <div className="product-description-sub">Price : $<span>{price}</span></div>
          <div className="product-description">{description}</div>
          <div className="product-description-sub">Category : <span>{category}</span></div>
          <div className="product-description-sub">Ratings : <span>{rating.rate}</span>(<span>{rating.count}</span>)</div>
          <button className="back-to-home-button" onClick={BackNavigation}>Back To Products</button>
        </div>

      </div>
  
    </div>
  );
}

export default ProductDetailPage;
