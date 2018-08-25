import React, {Component} from 'react';
import {NameContext} from "../App";

class ChildOfChild extends Component {

    render() {
        return (
            <div>
                <NameContext.Consumer>{(context) => (
                    <p>{context.that.someName}</p>
                )}
                </NameContext.Consumer>
            </div>
        );

    }
}

export default ChildOfChild;