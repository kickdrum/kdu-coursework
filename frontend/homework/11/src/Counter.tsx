import React, { useState } from "react";

export function Counter() {
  const [counter, setCounter] = useState<number>(0);

  const upCounter = () => {
    setTimeout(() => {
    //   setCounter(counter + 1);
      setCounter((prevState)=>{
        return prevState+1;
      })
    }, 1000);
  };

  const downCounter = () => {
    setTimeout(() => {
    //   setCounter(counter - 1);
    setCounter((prevState)=>{
        return prevState-1;
    })
    }, 1000);
  };
  return (
    <div>
      <button
        onClick={() => {
          downCounter();
        }}
      >
        -
      </button>
      <div>{counter}</div>
      <button
        onClick={() => {
          upCounter();
        }}
      >
        +
      </button>
    </div>
  );
}
