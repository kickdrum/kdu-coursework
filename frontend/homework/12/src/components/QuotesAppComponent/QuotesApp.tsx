import '../../styles/common.scss';
import './QuotesApp.scss';
import { AddQuote } from '../AddQuoteComponent/AddQuote';
import { DisplayQuotes } from '../DisplayQuotesComponent/DisplayQuotes';
import { Filter } from '../FilterComponent/Filter';
import { useEffect, useState } from 'react';
import { IQuotesApi } from '../../types/Quotes.types';
import { ITag } from '../../types/Tags.types';

export const QuotesApp = () => {

  const [apiData, setApiData] = useState<IQuotesApi[]>();
  const [filterKeys, setFilterKeys] = useState<ITag[]>();
  const [filteredData, setFilteredData] = useState<IQuotesApi[]>();
  const [loading, setLoading] = useState(false);
  const apiUrl = "https://api.quotable.io/quotes/random?limit=3";

  
  useEffect(() => {

    fetch(apiUrl)
      .then((res) => {
        return res.json();
      })
      .then((res) => {
        console.log(res);
        setApiData(res);
        setFilteredData(res);
      })

  }, []);


  useEffect(() => {

    if(!filterKeys || filterKeys.length === 0){
      setFilteredData(apiData);
      return
    }

    setFilteredData(apiData?.filter((quote)=>{
      return quote.tags.find((quoteTag)=>{
        return filterKeys?.find((filteredTags)=>{
          return filteredTags.tag === quoteTag;
        });
      })
    }))

    
  }, [apiData, filterKeys]);


  
  const addFilter = (tag: string) => {

    console.log(filterKeys);

    if (!filterKeys) {
      setFilterKeys([{
        tag: tag
      }]);

      return;
    }

    if (filterKeys?.find((curr) => { return curr.tag === tag })) {
      return;
    }

    setFilterKeys([...filterKeys, {
      tag: tag
    }]);

  }

  const removeFilter = (chosenTag: string) => {

    if (!filterKeys) {
      return;
    }

    setFilterKeys(filterKeys.filter((curr)=>{
      return curr.tag !== chosenTag;
    }));
  }



  return (
    <div className='quotesApp'>
      <AddQuote apiData={apiData} setApiData={setApiData} loading={loading} setLoading={setLoading} />
      <Filter filterKeys={filterKeys} removeFilter={removeFilter} />
      <DisplayQuotes filteredData={filteredData} addFilter={addFilter} />
    </div>
  )
}
