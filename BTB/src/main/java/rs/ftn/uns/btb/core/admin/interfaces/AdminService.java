package rs.ftn.uns.btb.core.admin.interfaces;
import rs.ftn.uns.btb.core.admin.Admin;
import rs.ftn.uns.btb.core.admin.dtos.ChangeAdminPasswordDTO;

public interface AdminService {
    Admin create(Admin admin) throws Exception;
    Admin updateByPassword(ChangeAdminPasswordDTO dto) throws  Exception;

    Admin findByEmail(String email);
}
