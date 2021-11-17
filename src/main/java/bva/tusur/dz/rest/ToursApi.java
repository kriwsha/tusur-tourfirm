package bva.tusur.dz.rest;

import bva.tusur.dz.dto.GetAllToursResponse;
import bva.tusur.dz.dto.TourDto;
import bva.tusur.dz.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/tours")
public class ToursApi {

    private final TourService tourService;

    @Autowired
    public ToursApi(TourService tourService) {
        this.tourService = tourService;
    }

    @PostMapping
    public GetAllToursResponse getTourList() {
        List<TourDto> currentTours = tourService.getCurrentTours();
        return new GetAllToursResponse(currentTours);
    }
}
