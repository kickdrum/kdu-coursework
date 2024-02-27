import { render, screen } from '@testing-library/react';
import { Provider } from 'react-redux';
import { store } from '../redux/store';
import { SearchList } from '../todo-list/SearchList';

describe('<SearchList />', () => {
  it('renders search input', () => {
    render(
      <Provider store={store}>
        <SearchList />
      </Provider>
    );
    const searchInput = screen.getByPlaceholderText('Search Items...');
    expect(searchInput).to.exist;
  });
});
