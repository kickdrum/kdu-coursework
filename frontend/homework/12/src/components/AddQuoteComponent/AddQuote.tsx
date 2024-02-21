import "../../styles/common.scss";
import { IQuotesApi } from "../../types/Quotes.types";
import "./AddQuote.scss";
import React, { Dispatch, SetStateAction } from "react";
import LoaderComp from "./Loader";


interface IAddQuotesProps {
  apiData: IQuotesApi[] | undefined;
  setApiData: Dispatch<SetStateAction<IQuotesApi[] | undefined>>;
  loading: boolean;
  setLoading: Dispatch<SetStateAction<boolean>>;
}

const apiUrl = "https://api.quotable.io/quotes/random";


export const AddQuote = ({ apiData, setApiData, loading, setLoading }: IAddQuotesProps) => {

  const addQuoteButtonHandler = () => {

    setLoading(true);

    fetch(apiUrl)
      .then((res) => {
        return res.json();
      })
      .then((res) => {
        console.log(res);
        setApiData([res[0], ...apiData!]);
        setLoading(false);
      })
  }


  return (
    <div className="addQuoteBox">

      <button
        className="button_skin addQUoteButton"
        onClick={addQuoteButtonHandler}
        disabled={loading}
      >
        <span>NEW QUOTE</span>
        {loading && (<LoaderComp />)}
      </button>


    </div>
  );
};
