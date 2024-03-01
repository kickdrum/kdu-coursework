import { RootState } from "./store/store";
import { useSelector } from "react-redux";
import { CircularProgress } from "@mui/material";
import ProductItem from "./components/ProductItem";

  
export function Products(){
    const products = useSelector((state: RootState)=>state.products.products);
    const loadingState=useSelector((state:RootState)=>state.products.state);

    const productsError= useSelector((state:RootState)=> state.products.error);
    
    if(loadingState==="pending"){return <div ><CircularProgress/></div>}
    if(loadingState==="error"){
        return <div>Error {productsError}</div>
    }
    return <div>
    {products.map(product => (
      <ProductItem key={product.id} product={product} />
    ))}
    </div>

}