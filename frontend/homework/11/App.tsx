import React, { useEffect, useState } from 'react';
import './App.scss';
import { ApiQuote } from './quotes_types';
import Quote from './Quote';

function App() {
  const [allQuotes, setAllQuotes] = useState<ApiQuote[]>([]);
  const [quotes, setQuotes] = useState<ApiQuote[]>([]);
  const [selectedTags, setSelectedTags] = useState<string[]>([]);

  useEffect(() => {
    setQuotes(
      allQuotes.filter((quote) =>
        selectedTags.length === 0
          ? true // Display all quotes when no tags are selected
          : quote.tags.some((tag) => selectedTags.includes(tag))
      )
    );
  }, [selectedTags, allQuotes]);

  

  const fetchData = () => {
    fetch('https://api.quotable.io/quotes/random?limit=3')
      .then((response) => response.json())
      .then((data: ApiQuote[]) => {
        
        setAllQuotes((prevQuotes) => [...prevQuotes, ...data]);
      });
  };

  const fetchDataRefresh = () => {
    fetch('https://api.quotable.io/quotes/random?limit=1')
      .then((response) => response.json())
      .then((data: ApiQuote[]) => {
        
        setAllQuotes((prevQuotes) => [...prevQuotes, ...data]);
      });
  };

  useEffect(() => {
    // Runs on mount
    // Make API call
    fetchData();
  }, []);

  const handleTagClick = (tag: string) => {
    setSelectedTags((prevTags) => [...prevTags, tag]);
  };

  const handleRemoveTag = (tag: string) => {
    setSelectedTags((prevTags) => prevTags.filter((t) => t !== tag));
  };

  return (
    <div id="main-container">
      <button id ="New-Quote-btn" onClick={() => fetchDataRefresh()}><span>NEW QUOTE</span></button>
      
      <div id="tags">
        Filters
        {selectedTags.map((tag) => (
          <button key={tag} type="button" onClick={() => handleRemoveTag(tag)}>
            {tag} <span>X</span>
          </button>
        ))}
      </div>
      <div id="separtor"></div>
      {quotes.map((quote) => (
        <Quote key={quote._id} quote={quote} onTagClick={handleTagClick} />
      ))}
    </div>
  );
}

export default App;

