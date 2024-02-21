import React from 'react';
import { ApiQuote } from './quotes_types';

interface QuoteProps {
  quote: ApiQuote;
  onTagClick: (tag: string) => void; // callback function
}

function Quote({ quote, onTagClick }: QuoteProps) {
  return (
    <div className='container'>
      <div id="content">
      <h1>{quote.content}</h1>
      </div>
      <div id ="info-Auth">
      <p>~{quote.author}</p>
      </div>
      <div id ="info-date">
      <p>{quote.dateAdded}</p>
      </div>
      <div id="allbtn">
      {quote.tags.map((q) => (
          <button key={q} type="button" onClick={() => onTagClick(q)}>
            {q}
          </button>
        ))}
      </div>
        
      
    </div>
  );
}

export default Quote;

