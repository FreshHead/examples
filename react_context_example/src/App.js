import React, {Component} from 'react';

import './App.css';
import Parent from "./components/Parent";
``
export const NameContext = React.createContext();

class App extends Component {
    constructor(props) {
        super(props);
        this.someName = "lul"
        this.setName = this.setName.bind(this);
    }

    setName(name){
        this.someName = name;
    }

    render() {
        return (
            <NameContext.Provider value={{
                that: this,
                setName: this.setName,
            }
            }>
                <Parent/>
            </NameContext.Provider>
        );
    }
}

export default App;
