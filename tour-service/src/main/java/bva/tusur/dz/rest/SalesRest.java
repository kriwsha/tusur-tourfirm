package bva.tusur.dz.rest;

import bva.tusur.dz.model.rq.NewSaleRequest;
import bva.tusur.dz.service.SaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final SaleService saleService;

    @Autowired
    public SalesRest(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping()
    @ApiOperation("Новая продажа")
    public ResponseEntity<?> addNewSale(@RequestBody NewSaleRequest request) {
        saleService.newSale(request.getTourId(), request.getClientId(), request.getEmployeeId());
        return ResponseEntity.ok().build();
    }

}
