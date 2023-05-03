package bva.tusur.dz.service.impl;

import bva.tusur.dz.model.dto.ReportType;
import bva.tusur.dz.model.dto.SalesReport;
import bva.tusur.dz.service.ReportService;
import org.springframework.stereotype.Service;

/**
 * Report service.
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Override
    public SalesReport getSalesReport(ReportType reportType) {
        return new SalesReport();
    }
}
