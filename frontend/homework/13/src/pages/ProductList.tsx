import { useContext } from "react";
import NavbarListPage from "../components/NavbarListPage";
import "../styles/ProductList.css"
import { ProductContext } from "../context/ProductContext";
import { ProductProps } from "../types/ProductProps";
import { Link } from "react-router-dom";
import ProductCard from "../components/ProductCard";

function ProductListPage() {
  const { displayProducts } = useContext(ProductContext);
  return (
    <div className="product-list-page">
    <NavbarListPage/>
      <div className="heading">KDU <span>MARKETPLACE</span></div>
      <div className="products-container">
        <ul className="products-list">
          {
            displayProducts.map((product:ProductProps) => (
              <li key={product.id}>
                <Link to={`/product/${product.id}`}><ProductCard product={product} /></Link>
              </li>
            ))
}
        </ul>
      </div>
    </div>

  );
}

export default ProductListPage;
