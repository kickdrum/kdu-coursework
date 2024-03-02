import { Search } from "./search/Search";

import './Header.scss';

export function Header() {
    return (
        <div className="header">
            <h1>Item Lister</h1>
            <Search />
        </div>
    );
}
