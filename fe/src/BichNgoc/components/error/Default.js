import React, { Component } from 'react'
/**
 * Author : Bich Ngoc
 */
export default class Default extends Component {
    render() {
        console.log(this.props);
        return (
            <div className="container">
                <div className="row">
                    <div className="col-10 mx-auto text-center text-title text-uppercase pt-5">
                        <h1>ERROR</h1>
                        <h2>Page Not Found</h2>
        <h3>the requested URL <span className="text-danger">{this.props.location.pathname}</span>{" "} was not found</h3>
                    </div>
                </div>
            </div>
        )
    }
}
