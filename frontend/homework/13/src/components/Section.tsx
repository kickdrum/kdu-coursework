import { useContext } from "react"
import { FilterAndSortContext } from "./Main"
import { IndividualItem } from "./IndividualItem";
import "./styles/Section.scss"


export function Section() {
    const {actualResult} = useContext(FilterAndSortContext);
  return (
    <div className="section-container">
        <div className="title-container">KDU MARKETPLACE</div>
        <ul>
            {actualResult.map((item)=>{
                return <li key={item.id}><IndividualItem item={item}/></li>
            })}
        </ul>
    </div>
  )
}
