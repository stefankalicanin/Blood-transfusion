package rs.ftn.uns.btb.core.report.interfaces;

import rs.ftn.uns.btb.core.report.Report;

public interface ReportService {

    Report create(Report newReport) throws Exception;
    
}
