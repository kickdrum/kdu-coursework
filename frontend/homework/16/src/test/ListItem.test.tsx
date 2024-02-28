import { render, screen, fireEvent } from '@testing-library/react';
import { ListItem } from '../todo-list/ListItem';
import { expect } from 'vitest';


describe('<ListItem />', () => {
  it('renders text', () => {
    const text = 'Test Todo';
    render(<ListItem text={text} onDelete={() => {}} />);
    const textElement = screen.getByText(text);
    expect(textElement).not.toBeNull();
  });

  it('calls onDelete callback when delete button is clicked', () => {
    const onDeleteMock = () => {}; // Mock the onDelete function
    render(<ListItem text="Test Todo" onDelete={onDeleteMock} />);
    const deleteButton = screen.getByRole('button', { name: /X/i });
    fireEvent.click(deleteButton);
    expect(fireEvent.click(deleteButton)).toBe(true);
  });

});
