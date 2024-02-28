import { render, screen } from '@testing-library/react';
import { Header } from '../todo-list/Header';
import { Provider } from 'react-redux';
import { store } from '../redux/store';
import { expect } from 'vitest';

describe('<Header />', () => {
  it('renders', () => {
    render(
    <Provider store={store}>
        <Header />
    </Provider>);
    const headerElement = screen.getByText(/Item Lister/i);
    expect(headerElement).not.toBeNull();
  });
});
