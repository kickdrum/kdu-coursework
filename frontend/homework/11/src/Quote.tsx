import React from 'react'
import { ApiQuote } from './types/quotes.types'
import './Quote.scss'

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

    <div className="quote">
        <div className='quote-content'>
            <h1>
                {quote.content}
            </h1>
        </div>
        <div className='quote-author'>
            <p className='p1'>{quote.author}</p>
        </div>
        <div className='quote-date'>
            <p className='p1'>
                {quote.dateAdded}
            </p>
        </div>
        <div className='quote-tags'>
            {quote.tags.map((q)=>{
                return <span className="quote-tag" key={q} onClick={onClickHandle}>{q}</span>;
            })}
        </div>
    </div>
  )
}
