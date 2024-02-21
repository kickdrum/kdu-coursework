import '../../styles/common.scss';
import { IQuotesApi } from '../../types/Quotes.types';
import { QuoteItem } from '../QuoteItemComponent/QuoteItem';
import './DisplayQuotes.scss';

interface IDisplayQuotesProps{
  filteredData: IQuotesApi[] | undefined;
  addFilter: (tag: string) => void;
}

export const DisplayQuotes = ({filteredData, addFilter}: IDisplayQuotesProps) => {

  console.log(filteredData);

  return (
    <div className='displayQuotesBox'>
        {filteredData?.map((currQuote)=>{
          return(
            <QuoteItem key={currQuote._id} quoteData={currQuote} addFilter={addFilter} />
          )
        })}
    </div>
  )
}
