import React, {Component} from 'react';
import {NameContext} from "../App";
import ChildOfChild from "./ChildOfChild";

class Child extends Component {

    render() {
        return (
            <NameContext.Consumer>{(context) => (
                <React.Fragment>
                    <p>{context.name}</p>
                    {context.that.setName("Kek") }
                    <ChildOfChild/>
                </React.Fragment>
            )}
            </NameContext.Consumer>
        )
    }
}

export default Child;