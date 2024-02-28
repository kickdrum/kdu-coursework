import { Link } from 'react-router-dom';
import {Product} from '../ProductsContext';
import './ProductItem.scss'

export function ProductItem({product}:Readonly<{product:Product}>) {
    return (
        <Link  to={`/detail/${product.id}`}>
        <div>
        <img src={product.image} alt={product.title} />
        <h2>{product.title}</h2>
        <h2>{product.category}</h2>7
        <div>
          <span>{product.rating.rate}</span>  
          <span>$ {product.price}</span>
        </div>
      </div>
      </Link>
    )
}