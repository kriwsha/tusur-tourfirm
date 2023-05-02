package bva.tusur.dz.rest;

import bva.tusur.dz.model.rq.NewSaleRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
@Api(tags = "Продажи")
@Slf4j
public class SalesRest {

    @PostMapping()
    @ApiOperation("Новая продажа")
    public ResponseEntity<?> addNewSale(@RequestBody NewSaleRequest request) {
        return ResponseEntity.noContent().build();
    }

}
