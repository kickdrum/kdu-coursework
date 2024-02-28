import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from '../store/reducers';
import { fetchProducts } from '../store/actions';
import ProductItem from './ProductItem';

const ProductList = () => {
  const dispatch = useDispatch();
  const productsList = useSelector((state: RootState) => state.products.productsList);

  useEffect(() => {
    dispatch(fetchProducts());
  }, [dispatch]);

  return (
    <>
      <div>MarketPlace</div>
      <div>
        {productsList.map(product => (
          <ProductItem key={product.id} product={product} />
        ))}
      </div>
    </>
  );
};

export default ProductList;
