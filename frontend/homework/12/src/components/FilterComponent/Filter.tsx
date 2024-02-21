import "../../styles/common.scss";
import { ITag } from "../../types/Tags.types";
import "./Filter.scss";

interface IFilter {
  filterKeys: ITag[] | undefined;
  removeFilter: (tag: string) => void;
}

export const Filter = ({ filterKeys, removeFilter }: IFilter) => {

  return (
    <div className="filterBox">
      <p>Filters</p>
      <ul>
        <li>
          {filterKeys?.map((curr) => {
            return (
              <button
                key={curr.tag}
                className="button_pink tagButton"
                onClick={()=>{removeFilter(curr.tag)}}
              >
                <span className="tagSpan">{curr.tag}</span>
                <span className="deleteIcon"> X</span>
              </button>
            );
          })}
        </li>
      </ul>
    </div>
  );
};
