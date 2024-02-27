import React, { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [count, setCount] = useState(0);
  const countRef = useRef(count);

  const increment = () => {
    countRef.current++;
    setCount(countRef.current);
  };


  const scrollRef = useRef<HTMLDivElement | null>(null);

  const handleScrollToTop = () => {
    if (scrollRef.current) {
      const element = scrollRef.current;
      if (element.scrollTo) {
        element.scrollTo({ top: 0, behavior: "smooth" });
      } else {
        element.scrollTop = 0; 
      }
    }
  };

  // Focus on first input on form page
  const inputRef = useRef<HTMLInputElement>(null);

  useEffect(() => {
    if (inputRef.current) {
      inputRef.current.focus();
    }
  }, []);

  // Timer application
  const [seconds, setSeconds] = useState(0);
  const intervalRef = useRef<NodeJS.Timeout | null>(null);

  const startTimer = () => {
    if (!intervalRef.current) {
      intervalRef.current = setInterval(() => setSeconds(seconds => seconds + 1), 1000);
    }
  };

  const stopTimer = () => {
    if (intervalRef.current) {
      clearInterval(intervalRef.current);
      intervalRef.current = null;
    }
  };

  const resetTimer = () => {
    stopTimer();
    setSeconds(0);
  };

  return (
    <div className="App">
       <div ref={scrollRef}>
        <p>Scroll down and then click "Scroll to Top"</p>

 
      <h1>Multi-Feature App</h1>

      <h2>Counter</h2>
      <p>Count: {count}</p>
      <button onClick={increment} >Increment</button>


      <h2>Form with Focused Input</h2>
      <form>
        <input ref={inputRef} type="text" placeholder="Focus on me" />
        <button type="submit">Submit</button>
      </form>
<div className="timer">
      <h2>Timer</h2>
      <p>Seconds: {seconds}</p>
      <button onClick={startTimer}>Start</button>
      <button onClick={stopTimer}>Stop</button>
        <button onClick={resetTimer} >Reset</button>
        </div>
      <h2>Scroll to Top</h2>
     
      <button onClick={handleScrollToTop}>Scroll to Top</button>
    </div>
    </div>
  );
}

export default App;
