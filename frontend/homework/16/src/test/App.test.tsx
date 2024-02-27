import { render, screen } from '@testing-library/react';
import App from "../App";
import { Provider } from 'react-redux';
import { store } from '../redux/store';
import { expect } from 'chai';

describe('<App />', () => {
  it('renders without crashing', () => {
    render(
      <Provider store={store}>
        <App />
      </Provider>
    );
    expect(screen.getByText(/Add Items/i)).to.exist;
  });

  it('renders the TodoList component', () => {
    render(
      <Provider store={store}>
        <App />
      </Provider>
    );
    expect(screen.getByRole('list')).to.exist;
  });

  it('renders the Header component', () => {
    render(
      <Provider store={store}>
        <App />
      </Provider>
    );
    expect(screen.getByText(/Item Lister/i)).to.exist;
  });

  it('renders the AddItem component', () => {
    render(
      <Provider store={store}>
        <App />
      </Provider>
    );
    expect(screen.getByText(/Submit/i)).to.exist;
  });

  it('renders the SearchList component', () => {
    render(
      <Provider store={store}>
        <App />
      </Provider>
    );
    expect(screen.getByPlaceholderText(/Search Items.../i)).to.exist;
    
  });
});
