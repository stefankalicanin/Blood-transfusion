package rs.ftn.uns.btb.core.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.core.appointment.Appointment;
import rs.ftn.uns.btb.core.appointment.AppointmentRepository;
import rs.ftn.uns.btb.core.appointment.interfaces.AppointmentState;
import rs.ftn.uns.btb.core.blood.Blood;
import rs.ftn.uns.btb.core.blood.BloodRepository;
import rs.ftn.uns.btb.core.report.interfaces.Attendance;
import rs.ftn.uns.btb.core.report.interfaces.ReportService;
import rs.ftn.uns.btb.core.scheduled_appointment.ScheduledAppointment;
import rs.ftn.uns.btb.core.scheduled_appointment.ScheduledAppointmentRepository;
import rs.ftn.uns.btb.core.user.User;
import rs.ftn.uns.btb.core.user.UserRepository;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    public ReportRepository _reportRepository;
    
    @Autowired
    public AppointmentRepository _appointmentRepository;

    @Autowired
    public UserRepository _userRepository;
    
    @Autowired
    public ScheduledAppointmentRepository _scheduledRepository;

    @Autowired
    public BloodRepository _bloodRepository;

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

        ScheduledAppointment sap = this._scheduledRepository.findByAppointmentId(updatedAppointment.getId());

        if (sap == null) {
            throw new Exception("Couldn't find the scheduled appointment.");
        }

        try {
            _scheduledRepository.deleteById(sap.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (newReport.getAttendanceStatus() == Attendance.ATTENDED) {
            Blood bloodToUpdate = this._bloodRepository.findOneByCenterIdAndType(updatedAppointment.getCenter().getId(), newReport.getBloodType());
            if (bloodToUpdate == null) {
                throw new Exception("Couldn't find the data for required blood type in given center");
            }
            bloodToUpdate.setQuantity((bloodToUpdate.getQuantity()*1000 + newReport.getBloodQuantity())/1000);
            Blood updatedBlood = this._bloodRepository.save(bloodToUpdate);
            if (updatedBlood == null) {
                throw new Exception("Couldn't update blood quantity");
            }
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
