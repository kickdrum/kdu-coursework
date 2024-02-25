import React from 'react'
import { ApiQuote } from './types/quotes.types'

interface QuoteProps{
    quote: ApiQuote
    setFilter?: React.Dispatch<React.SetStateAction<string[]>>,
    filter?: string[]
}

export function Quote({quote,filter, setFilter}:QuoteProps) {

    const onClickHandle = (e:React.MouseEvent<HTMLInputElement,MouseEvent>)=>{
        if (setFilter) {
            const tag = e.currentTarget.innerText;
            if(!filter?.includes(tag)){
                const updatedTags = filter? [...filter, tag] : [tag];
                setFilter(updatedTags);  
            }
         
        }
    }
  return (
    <div>
        <h1>
            {quote.content}
        </h1>
        <p>{quote.author}</p>
        <p>
            {quote.dateAdded}
        </p>
        <div>
            {quote.tags.map((q)=>{
                return <span key={q} onClick={onClickHandle}>{q}</span>;
            })}
        </div>
    </div>
  )
}
