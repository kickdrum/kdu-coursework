import React, { useRef, useEffect } from "react";
import "./MyForm.scss";

const MyForm: React.FC = () => {
  const firstInputRef = useRef<HTMLInputElement>(null);

  useEffect(() => {
    if (firstInputRef.current) {
      firstInputRef.current.focus();
    }
  }, []);

  return (
    <form className="my-form">
      <label htmlFor="input1" className="form-label">Input 1</label>
      <input id="input1" ref={firstInputRef} className="form-input" />
      <label htmlFor="input2" className="form-label">Input 2</label>
      <input id="input2" className="form-input" />
    </form>
  );
};

export default MyForm;
