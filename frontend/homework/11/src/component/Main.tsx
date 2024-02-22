import React, { useState, useEffect } from "react";
import { Quote } from "./Quote";
import { GridLoader } from "react-spinners";
import { response } from "express";
import { APIQuote } from "../types/quotesUtil";

import "./Main.scss";

function Main() {
  const [allQuotes, setAllQuotes] = useState<APIQuote[]>([]); // global
  const [quotes, setQuotes] = useState<APIQuote[]>([]); //  to set quotes to display on render
  const [search, setSearch] = useState<string>("");
  const [filter, setFilter] = useState<string>("");
  const [load, setLoad] = useState<boolean>(false);

  const onSearchHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
    setSearch(e.target.value);
  };

  useEffect(() => {
    setQuotes(allQuotes);
  }, [allQuotes]);

  const filterTag = (tag: string): void => {
    setFilter(tag);
  };

  useEffect(() => {
    let filterQuote = allQuotes;

    if (filter) {
      filterQuote = filterQuote.filter((quote) => quote.tags.includes(filter));
    }
    setQuotes(
      filterQuote.filter((quote) =>
        quote.content.toLowerCase().includes(search.toLowerCase())
      )
    );
  }, [search, allQuotes, filter]);

  useEffect(() => {
    setLoad(true);
    fetch("https://api.quotable.io/quotes/random?limit=3")
      .then((response) => response.json())
      .then((data: APIQuote[]) => {
        console.log(data);
        setAllQuotes(data);
        setLoad(false);
      })
      .catch((error) => {
        console.log("erorr fetching the data", error);
      });
  }, []);

  const removeHandler = (): void => {
    setFilter("");
  };

  const onClickHandler = () => {
    fetch("https://api.quotable.io/quotes/random?limit=1")
      .then((response) => response.json())
      .then((data: APIQuote[]) => {
        setAllQuotes([data[0], ...allQuotes]);
      })
      .catch((error) => {
        console.log("Error fetching data", error);
      });
  };

  return (
    <div className="main-page">
      <div className="left"></div>
      <div className="center">
        <button className="new" onClick={onClickHandler} disabled={load}>
          {load ? <GridLoader color="black" /> : "NEW QUOTE"}
        </button>

        <input
          type="text"
          value={search}
          onChange={onSearchHandler}
          className="filter-input"
          placeholder="Filters"
        />
        <div id="remove-handler">
          {filter ? (
            <button className="tag" id="filter-tag" onClick={removeHandler}>
              {filter}
            </button>
          ) : (
            ""
          )}
        </div>
        {quotes.map((quote) => {
          return <Quote key={quote._id} quote={quote} filterTag={filterTag} />;
        })}
      </div>

      <div className="right"></div>
    </div>
  );
}

export default Main;
