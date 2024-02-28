import {
    FETCH_PRODUCTS_REQUEST,
    FETCH_PRODUCTS_SUCCESS,
    FETCH_PRODUCTS_FAILURE,
    ProductsActionTypes
  } from './actions';
  
  export interface Product {
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
  
  interface InitialState {
    productsList: Product[];
    loading: boolean;
    error: string | null;
  }
  
  const initialState: InitialState = {
    productsList: [],
    loading: false,
    error: null
  };
  
  const productsReducer = (state = initialState, action: ProductsActionTypes): InitialState => {
    switch (action.type) {
      case FETCH_PRODUCTS_REQUEST:
        return {
          ...state,
          loading: true
        };
      case FETCH_PRODUCTS_SUCCESS:
        return {
          ...state,
          loading: false,
          productsList: action.payload,
          error: null
        };
      case FETCH_PRODUCTS_FAILURE:
        return {
          ...state,
          loading: false,
          productsList: [],
          error: action.payload
        };
      default:
        return state;
    }
  };
  
  export default productsReducer;
  