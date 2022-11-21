package rs.ftn.uns.btb.core.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.uns.btb.core.report.interfaces.ReportService;

@RestController
@RequestMapping(value = "/api/report")
public class ReportController {

    public final ReportService _reportService;

    @Autowired
    public ReportController(ReportService _reportService) { this._reportService = _reportService; }
    
}
