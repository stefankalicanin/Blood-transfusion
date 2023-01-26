package rs.ftn.uns.btb.core.appointment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookAppointmentDTO {
    public Long appointmentId;
    public Long customerId;

}
