import { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import ProductItem from './ProductItem';
import { AppDispatch, RootState } from '../store/store';
import { setData } from '../redux/ProductsSlice';
import { CircularProgress } from '@mui/material';

const ProductList = () => {
  const products = useSelector((state: RootState)=>state.products.products);
  console.log("The Products",products);
  const loadingState=useSelector((state:RootState)=>state.products.state);

  const productsError= useSelector((state:RootState)=> state.products.error);
    

  const reduxDispatch: AppDispatch = useDispatch()

  useEffect(() => {
    reduxDispatch(setData(products))
  }, []);
  if(loadingState==="pending"){return <div ><CircularProgress/></div>}
  if(loadingState==="error"){
      return <div>Error {productsError}</div>
  }
  return (
    <>
      <div>
        {products.map(product => (
          <ProductItem key={product.id} product={product} />
        ))}
      </div>
    </>
  );
};

export default ProductList;
