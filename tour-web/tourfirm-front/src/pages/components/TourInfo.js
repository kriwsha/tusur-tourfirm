import React from "react";

const TourInfo = ({tours}) => {
    return (
        <div>
            <center><h2>Туристические туры</h2></center>
            {tours.map((tour, i) => (
                <div className="card" key={i}>
                    <div className="card-body">
                        <h5 className="card-title">tour.name</h5>
                        <h6 className="card-sub-title">tour.dates</h6>
                        <p className="card-description">tour.description</p>
                    </div>
                </div>
            ))}
        </div>
    )
}

export default TourInfo;