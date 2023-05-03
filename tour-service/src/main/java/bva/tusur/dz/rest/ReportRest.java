package bva.tusur.dz.rest;

import bva.tusur.dz.model.dto.ReportType;
import bva.tusur.dz.model.dto.SalesReport;
import bva.tusur.dz.service.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final ReportService reportService;

    @Autowired
    public ReportRest(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/sales")
    @ApiOperation("Отчет о продажах")
    public ResponseEntity<SalesReport> getSalesReport(
            @RequestParam("type") ReportType reportType) {
        SalesReport report = reportService.getSalesReport(reportType);
        return ResponseEntity.ok(report);
    }
}
