import React from 'react';
import { Link } from 'react-router-dom';

interface Product {
    id: number;
    title: string;
    price: number;
    description: string;
    category: string;
    image: string;
    rating: {
      rate: number;
      count: number;
    };
  }
interface Props {
  product: Product;
}

const ProductItem = ({ product }: Props) => {
  return (
    <Link to={`/detail/${product.id}`}>
      <div>
        <img src={product.image} alt={product.title} />
        <h2>{product.title}</h2>
        <h2>{product.category}</h2>
        <div>
          <span>{product.rating.rate}</span>
          <span>$ {product.price}</span>
        </div>
      </div>
    </Link>
  );
};

export default ProductItem;
