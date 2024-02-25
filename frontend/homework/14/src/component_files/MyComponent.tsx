import React, { useRef, useState } from "react";
import "./MyComponent.scss";

const MyComponent: React.FC = () => {
  const myRef = useRef<HTMLDivElement>(null);
  const [isRed, setIsRed] = useState<boolean>(false);

  const handleClick = () => {
    if (myRef.current) {
      setIsRed(!isRed);
    }
  };

  return (
    <div ref={myRef} className={`my-component ${isRed ? 'red-color' : ''}`}>
      <button onClick={handleClick}>Click me</button>
    </div>
  );
};

export default MyComponent;
