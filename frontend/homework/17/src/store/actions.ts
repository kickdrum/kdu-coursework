// import { Dispatch } from 'redux';

// export interface Product {
//   id: number;
//   title: string;
//   price: number;
//   description: string;
//   category: string;
//   image: string;
//   rating: {
//     rate: number;
//     count: number;
//   };
// }

// export const FETCH_PRODUCTS_REQUEST = 'FETCH_PRODUCTS_REQUEST';
// export const FETCH_PRODUCTS_SUCCESS = 'FETCH_PRODUCTS_SUCCESS';
// export const FETCH_PRODUCTS_FAILURE = 'FETCH_PRODUCTS_FAILURE';

// interface FetchProductsRequestAction {
//   type: typeof FETCH_PRODUCTS_REQUEST;
// }

// interface FetchProductsSuccessAction {
//   type: typeof FETCH_PRODUCTS_SUCCESS;
//   payload: Product[];
// }

// interface FetchProductsFailureAction {
//   type: typeof FETCH_PRODUCTS_FAILURE;
//   payload: string; // Change the payload type to string
// }

// export type ProductsActionTypes =
//   | FetchProductsRequestAction
//   | FetchProductsSuccessAction
//   | FetchProductsFailureAction;

// export const fetchProductsRequest = (): FetchProductsRequestAction => ({
//   type: FETCH_PRODUCTS_REQUEST
// });

// export const fetchProductsSuccess = (data: Product[]): FetchProductsSuccessAction => ({
//   type: FETCH_PRODUCTS_SUCCESS,
//   payload: data
// });

// // Specify the payload type as string instead of unknown
// export const fetchProductsFailure = (error: string): FetchProductsFailureAction => ({
//   type: FETCH_PRODUCTS_FAILURE,
//   payload: error
// });

// export const fetchProducts = () => {
//   return async (dispatch: Dispatch<ProductsActionTypes>) => {
//     dispatch(fetchProductsRequest());
//     try {
//       const response = await fetch('https://fakestoreapi.com/products');
//       if (!response.ok) {
//         throw new Error('Failed to fetch products');
//       }
//       const data: Product[] = await response.json();
//       dispatch(fetchProductsSuccess(data));
//     } catch (error) {
//       // Pass the error message to fetchProductsFailure
//       dispatch(fetchProductsFailure(error.message));
//     }
//   };
// };
