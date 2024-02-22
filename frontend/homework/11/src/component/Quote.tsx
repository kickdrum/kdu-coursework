import React from "react";
import "./Quote.scss";
import { APIQuote } from "../types/quotesUtil";

interface QuoteProps {
  quote: APIQuote;
  filterTag: (tag: string) => void;
}

export function Quote({ quote, filterTag }: QuoteProps) {
  return (
    <div className="main-div">
      <div className="quote-div">
        <p className="quote">{quote.content}</p>
      </div>
      <div className="author-div">
        <p className="author">~{quote.author}</p>
        <p className="date">{quote.dateAdded}</p>
      </div>

      <div className="span-div">
        {quote.tags.map((tag) => (
          <div className="tag-div">
            <button className="tag" id="tag" onClick={() => filterTag(tag)}>
              {tag}
            </button>
          </div>
        ))}
      </div>
    </div>
  );
}
