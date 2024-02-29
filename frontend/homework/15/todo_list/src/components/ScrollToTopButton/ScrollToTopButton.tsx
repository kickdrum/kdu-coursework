import { useRef, useEffect } from 'react';
import './ScrollToTopButton.scss';

const ScrollToTopButton = () => {
  const buttonRef = useRef<HTMLButtonElement>(null);

  const scrollToTop = () => {
    window.scrollTo({
      top: 0,
      behavior: 'smooth'
    });
  };

  useEffect(() => {
    const handleScroll = () => {
      if (window.scrollY > 100) {
        buttonRef.current!.classList.add('show');
      } else {
        buttonRef.current!.classList.remove('show');
      }
    };

    window.addEventListener('scroll', handleScroll);

    return () => {
      window.removeEventListener('scroll', handleScroll);
    };
  }, []);

  return (
    <button ref={buttonRef} className="scroll-to-top-button" onClick={scrollToTop}>
      Scroll to Top
    </button>
  );
};

export default ScrollToTopButton;
