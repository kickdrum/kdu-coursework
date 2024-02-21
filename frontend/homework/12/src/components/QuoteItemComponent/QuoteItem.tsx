import "../../styles/common.scss";
import { IQuotesApi } from "../../types/Quotes.types";
import "./QuoteItem.scss";

interface IQuoteItemProp {
  quoteData: IQuotesApi;
  addFilter: (tag: string) => void;
}

export const QuoteItem = ({ quoteData, addFilter }: IQuoteItemProp) => {        

  return (
    <div className="quoteItem">
      <div className="content_box">
        <p className="content_para text_white">{quoteData.content}</p>
      </div>

      <div className="details_box">
        <p className="details_para text_light">~{quoteData.author}</p>
        <p className="date_para details_para text_light">
          {quoteData.dateAdded}
        </p>
      </div>

      <div className="tags_box">
        {quoteData.tags.map((tag) => {
          return (
            <button
              key={tag}
              className="button_pink tagButton"
              onClick={()=>addFilter(tag)}
            >
              {tag}
            </button>
          );
        })}
      </div>
    </div>
  );
};
