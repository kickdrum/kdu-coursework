import React, { useRef } from 'react';
import './ScrollToTop.scss';

const ScrollToTop: React.FC = () => {
  const scrollRef = useRef<HTMLButtonElement>(null);

  const scrollToTop = () => {
    window.scrollTo({
      top: 0,
      behavior: 'smooth'
    });
  };

  return (
    <button id="scroll-to-top" ref={scrollRef} onClick={scrollToTop}>
      ↑
    </button>
  );
};

export default ScrollToTop;
