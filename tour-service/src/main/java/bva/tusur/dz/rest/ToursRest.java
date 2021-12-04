package bva.tusur.dz.rest;

import bva.tusur.dz.dto.rs.GetAllToursResponse;
import bva.tusur.dz.dto.TourDto;
import bva.tusur.dz.service.TourService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tours")
@Api(tags = "Актуальные туры")
@Slf4j
public class ToursRest {

    private final TourService tourService;

    @Autowired
    public ToursRest(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping()
    @ApiOperation("Получение всех актуальных туров")
    public GetAllToursResponse getTourList() {
        log.debug("getTourList started");
        List<TourDto> currentTours = tourService.getCurrentTours();
        GetAllToursResponse rs = new GetAllToursResponse(currentTours);
        log.debug("getTourList finished");
        return rs;
    }
}
