package rs.ftn.uns.btb.core.complaint.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ComplaintDTO {

    private String answer;

    public ComplaintDTO(ComplaintDTO cDTO) {
        this.answer = cDTO.answer;
    }

   
}