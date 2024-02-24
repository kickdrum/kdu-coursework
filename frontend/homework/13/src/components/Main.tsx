import { createContext, useContext, useEffect, useState } from "react";
import { Navigation } from "./Navigation";
import { FilterAndSortContextProviderProp, IItem, SearchItemContextProp, SearchItemContextProviderProp } from "./interfaces/APIInterfaces";
import { ProductListContext } from "../App";
import { Section } from "./Section";

export const SearchItemContext  = createContext<SearchItemContextProp>({
    searchTerm:"",
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    updateSearchTerm: (data:string)=>{}
});

const SearchItemContextProvider = ({children} : SearchItemContextProviderProp)=>{
    const [searchTerm,setSearchTerm] = useState("");

    const updateSearchTerm = (data:string)=>{
        setSearchTerm(data);
    }

    return(
        <SearchItemContext.Provider value={{searchTerm,updateSearchTerm}}>
            {children}
        </SearchItemContext.Provider>
    )
}
interface FilterAndSortContextProp{
    filterTerm:string,
    sortTerm:string,
    updateFilter : (data:string)=> void,
    updateSort : (given:string) => void,
    actualResult: IItem[]
}
export const FilterAndSortContext = createContext<FilterAndSortContextProp>({
    filterTerm:"",
    sortTerm:"",
    updateFilter:(data:string)=>{
        console.log(data);
    },
    updateSort:(given:string)=>{
        console.log(given);
    },
    actualResult:[]
});

const FilterAndSortContextProvider = ({children} : FilterAndSortContextProviderProp)=>{
    const [filterTerm,setFilterTerm] = useState<string>("");
    const [sortTerm,setSortTerm] = useState<string>("");

    const updateFilter = (data : string)=>{
        setFilterTerm(data);
        console.log(data);
    }

    const updateSort = (given:string)=>{
        setSortTerm(given);
        console.log(given);
    }

    const {products} = useContext(ProductListContext);

    let actualResult :IItem[] = [...products];
    if(filterTerm != ""){
        actualResult = products.filter((item)=>{
            return item.category == filterTerm;
        });
    }

    if (sortTerm === "price") {
        actualResult.sort((item1, item2) => item1.price - item2.price); 
    } else if (sortTerm === "rating") {
        actualResult.sort((item1, item2) => item2.rating.rate - item1.rating.rate); 
    }
    
    const {searchTerm} = useContext(SearchItemContext);

    if (searchTerm !== "") {
        actualResult = actualResult.filter((data) => {
          return data.title.toLowerCase().includes(searchTerm.toLowerCase()); 
        });
    }
    return(
        <FilterAndSortContext.Provider value={{filterTerm,sortTerm,updateFilter,updateSort,actualResult}}>
            {children}
        </FilterAndSortContext.Provider>
    )
}
export function Main() {
    const {setList} = useContext(ProductListContext);
    useEffect(()=>{
        fetch("https://fakestoreapi.com/products")
        .then((response) => response.json())
        .then((data: IItem[]) => {
          setList(data);
        });
    })
  return (
    <div>
      <SearchItemContextProvider>
        <FilterAndSortContextProvider>
          <Navigation />
          <Section />
        </FilterAndSortContextProvider>
      </SearchItemContextProvider>
    </div>
  );
}
