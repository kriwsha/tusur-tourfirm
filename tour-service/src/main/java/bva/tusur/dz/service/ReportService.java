package bva.tusur.dz.service;

import bva.tusur.dz.model.dto.ReportType;
import bva.tusur.dz.model.dto.SalesReport;

public interface ReportService {
    SalesReport getSalesReport(ReportType reportType);
}
