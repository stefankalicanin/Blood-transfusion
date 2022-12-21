package rs.ftn.uns.btb.core.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.core.admin.Admin;
import rs.ftn.uns.btb.core.admin.AdminRepository;
import rs.ftn.uns.btb.core.role.Role;
import rs.ftn.uns.btb.core.staff.Staff;
import rs.ftn.uns.btb.core.staff.StaffRepository;
import rs.ftn.uns.btb.core.user.User;
import rs.ftn.uns.btb.core.user.UserRepository;
import rs.ftn.uns.btb.core.user.interfaces.UserService;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository _userRepository;

    @Autowired
    private UserService _userService;

    @Autowired
    private StaffRepository _staffRepository;

    @Autowired
    private AdminRepository _adminRepository;

    // loadByUserName ali ustvari ByEmail
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = _userRepository.findOneByEmail(email);
        if (user != null) {
            List<Role> userRoles = this._userRepository.findAllRolesByUserId(user.getId());
            printRoles(userRoles);
            return new CustomUserDetails(user.getEmail(), user.getPassword(), userRoles); 
        }

        Staff staff = _staffRepository.findOneByEmail(email);
        if (staff != null) {
            List<Role> staffRoles = this._staffRepository.findAllRolesByStaffId(staff.getId());
            printRoles(staffRoles);
            return new CustomUserDetails(staff.getEmail(), staff.getPassword(), staffRoles);
        }

        Admin admin = _adminRepository.findOneByEmail(email);
        if (admin != null) {
            List<Role> adminRoles = this._adminRepository.findAllRolesByAdminId(admin.getId());
            printRoles(adminRoles);
            return new CustomUserDetails(admin.getEmail(), admin.getPassword(), adminRoles);
        }

        throw new UsernameNotFoundException(String.format("No user was found with email '%s'.", email));
    }

    public void printRoles(List<Role> roles) {
        for (Role r : roles) {
            System.out.print(r.getName() + " | ");
        }
    }
    
    
}
