import { useContext } from "react"
import { ProductsContext } from "../ProductsContext";
import { ProductItem } from './ProductItem';
import './ProductList.scss'

export function ProductList() {
  const { productsList }= useContext(ProductsContext);

  return (
    <>
    <div>MarketPlace</div>
    <div>
      {
        productsList.map((product) => {
          return (
            <ProductItem key={product.id} product={product}/>
          )
        })
      }
    </div>
    </>
  )
}
