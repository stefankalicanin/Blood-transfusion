package rs.ftn.uns.btb.core.admin.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ChangeAdminPasswordDTO {

    private Long id;
    private String password;

    public void ChangeAdminPasswordDTO(ChangeAdminPasswordDTO dto)
    {
        this.id= dto.id;
        this.password=dto.password;
    }

}
