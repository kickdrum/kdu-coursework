import React, { useState } from "react";
import "./App.scss";
import { useEffect } from "react";
import { ApiQuote } from "./types/quotes.types";
import { Quote } from "./Quote";
import { Counter } from "./Counter";

function App() {
  const [allQuotes, setAllQuotes] = useState<ApiQuote[]>([]);
  const [quotes, setQuotes] = useState<ApiQuote[]>([]);
  const [filter,setFilter]= useState<string[]>([]);
  const [search, setSearch] = useState<string>("");

  const newQuote = () => {
    fetch("https://api.quotable.io/quotes/random?limit=1")
      .then((res) => res.json())
      .then((data) => {
        setAllQuotes([data[0], ...allQuotes]);
      })
  }

  const removeTag = (tag:string)=>
  {
    setFilter(filter.filter((element) => element !== tag))
  }

  useEffect(() => {
    setQuotes(allQuotes.filter((quote) => quote.content.includes(search)));
  }, [search]);

  useEffect(() => {
    setQuotes(allQuotes);
  }, [allQuotes]);

  const onSearchChangeHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
    setSearch(e.target.value);
  };

  //on mount fetch
  useEffect(() => {
    fetch("https://api.quotable.io/quotes/random?limit=3")
      .then((response) => response.json())
      .then((data: ApiQuote[]) => {
        setAllQuotes(data);
      });
  }, []);

  useEffect(() => {
    if(filter.length>0)
   {console.log("here") ;
    const find = allQuotes.filter((data) => {
        return filter.every((tag) => data.tags.includes(tag));
    });
    setQuotes(find);
  }
  else 
  {
    setQuotes(allQuotes)
  }
}, [filter, allQuotes]);
  return (
    <>
    <div className="header">
      <button className="quote-btn" onClick={()=> newQuote()}>NEW QUOTE</button>
      <div className="filter">
        Filters
      </div>

      <div className="tags">
        {filter.map((tag, index) => (
          <div className="tag">
          <div >{tag}</div>
          <div className="cross" onClick={() => removeTag(tag)}>x</div>
          </div>
        ))}
      </div>

      {/* <input type="text" value={search} onChange={onSearchChangeHandler}/> */}
    </div>

    <div><hr className="line"/> </div>

    {quotes.map((quote)=>{
      return <Quote key={quote._id} quote={quote} filter={filter} setFilter = {setFilter}/>
    })}
    </>
  );
}

export default App;
