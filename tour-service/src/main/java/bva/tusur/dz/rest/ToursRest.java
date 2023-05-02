package bva.tusur.dz.rest;

import bva.tusur.dz.model.rq.AddNewTourRequest;
import bva.tusur.dz.model.rs.GetAllToursResponse;
import bva.tusur.dz.model.dto.TourDto;
import bva.tusur.dz.service.TourService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<GetAllToursResponse> getTourList() {
        log.debug("getTourList started");
        List<TourDto> currentTours = tourService.getCurrentTours();
        GetAllToursResponse rs = new GetAllToursResponse(currentTours);
        log.debug("getTourList finished");
        return ResponseEntity.ok(rs);
    }

    @PostMapping()
    @ApiOperation("Добавление нового тура")
    public ResponseEntity<?> addTour(@RequestBody AddNewTourRequest request) {
        // TODO: 04.12.2021 for test
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping()
    @ApiOperation("Получение туров по фильтру")
    public ResponseEntity<GetAllToursResponse> getToursByFilter(
            @RequestParam("country") String country,
            @RequestParam("city") String city,
            @RequestParam("cost") String cost,
            @RequestParam("dateFrom") String dateFrom,
            @RequestParam("dateTo") String dateTo
    ) {
        // TODO: 04.12.2021 for test
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Получение туров по фильтру")
    public ResponseEntity<?> removeTourById(
            @PathVariable("id") Integer id
    ) {
        // TODO: 04.12.2021 for test
        return ResponseEntity.noContent().build();
    }
}
