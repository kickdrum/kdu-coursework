import React, { useRef, useEffect, useState } from "react";
import "./Timer.scss";

const Timer: React.FC = () => {
  const [seconds, setSeconds] = useState<number>(0);
  const intervalRef = useRef<number | null>(null);

  useEffect(() => {
    intervalRef.current = window.setInterval(() => {
      setSeconds((prevSeconds) => prevSeconds + 1);
    }, 1000);

    return () => {
      if (intervalRef.current) {
        clearInterval(intervalRef.current);
      }
    };
  }, []);

  const resetTimer = () => {
    setSeconds(0);
  };

  return (
    <div className="timer-container">
      <h1 className="timer-heading">Timer: {seconds}s</h1>
      <button onClick={resetTimer} className="timer-button">Reset</button>
    </div>
  );
};

export default Timer;
