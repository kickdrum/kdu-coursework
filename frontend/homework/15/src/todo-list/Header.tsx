import './Header.scss';
import { SearchList } from './SearchList';

export function Header() {
  return (
    <div className="header">
      <h1 id="header">Item Lister</h1>
      <SearchList />
    </div>
  );
}
