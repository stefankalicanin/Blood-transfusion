package rs.ftn.uns.btb.core.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.core.appointment.Appointment;
import rs.ftn.uns.btb.core.appointment.AppointmentRepository;
import rs.ftn.uns.btb.core.appointment.interfaces.AppointmentState;
import rs.ftn.uns.btb.core.report.interfaces.Attendance;
import rs.ftn.uns.btb.core.report.interfaces.ReportService;
import rs.ftn.uns.btb.core.user.User;
import rs.ftn.uns.btb.core.user.UserRepository;

@Service
public class ReportServiceImpl implements ReportService {

    public final ReportRepository _reportRepository;
    public final AppointmentRepository _appointmentRepository;
    public final UserRepository _userRepository;

    @Autowired
    public ReportServiceImpl (ReportRepository _repReportRepository, AppointmentRepository _appointmentRepository, UserRepository _userRepository) { 
        this._reportRepository = _repReportRepository; 
        this._appointmentRepository = _appointmentRepository;
        this._userRepository = _userRepository;
    }

    @Override
    public Report create(Report report) throws Exception {
        Report newReport = this._reportRepository.save(report);
        
        if (newReport == null) {
            throw new Exception("Couldn't create report for given user and appointment.");
        }

        Appointment appointmentToUpdate = this._appointmentRepository.findOneById(report.getAppointment().getId());
        
        if (appointmentToUpdate == null) {
            throw new Exception("Couldn't find appointment with given ID");
        }

        appointmentToUpdate.setState(AppointmentState.FINISHED);
        Appointment updatedAppointment = this._appointmentRepository.save(appointmentToUpdate);

        if (updatedAppointment == null) {
            throw new Exception("Couldn't update state for existing appointment");
        }

        if (newReport.getAttendanceStatus() == Attendance.MISSED) {

            User userToUpdate = this._userRepository.findOneById(report.getUser().getId());
            
            if (userToUpdate == null) {
                throw new Exception("Couldn't find user with given ID");
            }
            
            if (userToUpdate.getPenalty() < 3) {
                userToUpdate.setPenalty(userToUpdate.getPenalty() + 1);
                User updatedUser = this._userRepository.save(userToUpdate);

                if (updatedUser == null) {
                    throw new Exception("User's penalty couldn't be updated");
                }
            }
        }

        return newReport;
    }
}
