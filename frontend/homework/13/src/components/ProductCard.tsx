import React from 'react';
import { ProductProps } from '../types/ProductProps';

function ProductCard({product}:ProductProps) {
    return ( 
        <div className='product-card'>
            <div className="product-image-div"><img src={product.image} alt="product" /></div>
            <div className="product-info">
                <div className="product-name">{product.title}</div>
                <div className="product-price">${product.price}</div>
            </div>
        </div>
     );
}

export default ProductCard;