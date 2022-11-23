package rs.ftn.uns.btb.core.report.interfaces;

/*
    ATTENDED - User attended the blood donation appointment and was accepted
    SKIPPED - User didn't show up to the appointment
    REJECTED - Staff/Admin rejected users from donating due to survey issues
               User showed up.
 */ 

public enum Attendance {
    ATTENDED, SKIPPED, REJECTED
}
