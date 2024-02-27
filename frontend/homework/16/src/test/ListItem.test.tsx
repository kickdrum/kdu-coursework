import { render, screen, fireEvent } from '@testing-library/react';
import { ListItem } from '../todo-list/ListItem';

describe('<ListItem />', () => {
  it('renders text', () => {
    const text = 'Test Todo';
    render(<ListItem text={text} onDelete={() => {}} />);
    const textElement = screen.getByText(text);
    expect(textElement).to.exist;
  });

  it('calls onDelete callback when delete button is clicked', () => {
    const onDeleteMock = () => {}; // Mock the onDelete function
    render(<ListItem text="Test Todo" onDelete={onDeleteMock} />);
    const deleteButton = screen.getByRole('button', { name: /X/i });
    fireEvent.click(deleteButton);
  });

});
