import '../../assets/styles/searchBar.scss'
import {useInputState} from '@mantine/hooks';

export let searchValue;
let setSearchValue;

const Search = (props) => {
    [searchValue, setSearchValue] = useInputState('');

    return (
        <form className={props.classes} onSubmit={console.log("submitted!")}>
            <div className="containerSearch">
                <input
                    value={searchValue}
                    onChange={setSearchValue}
                    className="AutoFocus"
                    type="text"
                />
                <div className="search"></div>
            </div>
        </form>
    );
}

export default Search;