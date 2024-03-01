import { useEffect } from 'react';
import { RootState } from '../store/store';
import { useSelector, useDispatch } from 'react-redux';
import { getProducts } from '../thunks/getProducts';
import { AppDispatch } from '../store/store';
import Snackbar from '@mui/material/Snackbar';
import { SnackbarContent } from "@mui/material";
import { setClose } from '../redux/SnackbarSlice';
import ProductList from '../components/ProductList';
import { setData } from '../redux/ProductsSlice';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Nav } from './Nav';

const Marketplace = () => {
  const reduxDispatch: AppDispatch = useDispatch()
  const snackBar = useSelector((state: RootState)=> state.snackbar)
  const products = useSelector((state: RootState)=>state.products.products);

  useEffect(()=>{
    reduxDispatch(setData(products))
    reduxDispatch(getProducts())
  }, [])

  return (<>

        <BrowserRouter>
          <Routes>
            <Route path="/" element={<ProductList />} />
          </Routes>
          <Nav/>
           <ProductList/> 
        </BrowserRouter>
      <div>
        <Snackbar
          open={snackBar.show}
          autoHideDuration={5000}
          onClose={()=>reduxDispatch(setClose())}
          anchorOrigin={{ vertical: 'bottom', horizontal: 'center' }}>
          <SnackbarContent  message={snackBar.message} />
      </Snackbar>
      </div>
    </>);
}

export default Marketplace;
