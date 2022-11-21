package rs.ftn.uns.btb.core.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.core.report.interfaces.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

    public final ReportRepository _reportRepository;

    @Autowired
    public ReportServiceImpl (ReportRepository _repReportRepository) { this._reportRepository = _repReportRepository; }

    @Override
    public Report create(Report report) throws Exception {
        Report newReport = this._reportRepository.save(report);
        return newReport;
    }
}
