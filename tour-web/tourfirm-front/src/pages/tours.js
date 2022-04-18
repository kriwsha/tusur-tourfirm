import React, {Component} from "react";
import TourInfo from "./components/TourInfo"
import './tours.css';

class Tours extends Component {
    render() {
        // const allTours = this.fetchAllTours();
        // return (
        //     <div>
        //         <TourInfo tours={this.state.tours} />
        //     </div>
        // );
    }

    state = {
        tours: []
    }

    componentDidMount() {

    }
}

export default Tours;
