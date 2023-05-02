package bva.tusur.dz.rest;

import bva.tusur.dz.model.dto.ReportType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
@Api(tags = "Отчеты")
@Slf4j
public class ReportRest {

    @GetMapping("/sales")
    @ApiOperation("Отчет о продажах")
    public ResponseEntity<?> getSalesReport(
            @RequestParam("type") ReportType reportType
    ) {
        return ResponseEntity.noContent().build();
    }
}
