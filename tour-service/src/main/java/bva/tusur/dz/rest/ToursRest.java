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
        List<TourDto> currentTours = tourService.getCurrentTours();
        GetAllToursResponse rs = new GetAllToursResponse(currentTours);
        return ResponseEntity.ok(rs);
    }

    @PostMapping()
    @ApiOperation("Добавление нового тура")
    public ResponseEntity<?> addTour(@RequestBody AddNewTourRequest request) {
        tourService.addNewTour(
                request.getHotelId(),
                request.getTransportId(),
                request.getDateFrom(),
                request.getDateTo(),
                request.getPrice()
        );
        return ResponseEntity.ok().build();
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
        List<TourDto> currentTours = tourService.getToursByFilter(
                country, city, cost, dateFrom, dateTo);
        GetAllToursResponse rs = new GetAllToursResponse(currentTours);
        return ResponseEntity.ok(rs);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Получение конкретного тура")
    public ResponseEntity<?> removeTourById(
            @PathVariable("id") Integer id
    ) {
        tourService.removeTour(id);
        return ResponseEntity.ok().build();
    }
}
