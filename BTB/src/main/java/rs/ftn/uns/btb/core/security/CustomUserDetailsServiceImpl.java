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
    private StaffRepository _staffRepostiroy;

    @Autowired
    private AdminRepository _adminRepository;

    // loadByUserName ali ustvari ByEmail
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = _userRepository.findOneByEmail(email);
        if (user != null) {
            System.out.println("Dosao do ovog dela");
            // List<Object> userRoles = _userRepository.findByRoles();
            // for (Object object : userRoles) {
            //     System.out.println("Role: " + object.toString());
            // }
            System.out.println("=============================================================");
            return new CustomUserDetails(user.getEmail(), user.getPassword(), "ROLE_USER"); 
        }

        Staff staff = _staffRepostiroy.findOneByEmail(email);
        if (staff != null) {
            // List<Role> staffRoles = _staffRepostiroy.getAllRoles(staff.getId());
            return new CustomUserDetails(staff.getEmail(), staff.getPassword(), "ROLE_STAFF");
        }

        Admin admin = _adminRepository.findOneByEmail(email);
        if (admin != null) {
            // List<Role> adminRoles = _staffRepostiroy.getAllRoles(admin.getId());
            return new CustomUserDetails(admin.getEmail(), admin.getPassword(), null);
        }

        throw new UsernameNotFoundException(String.format("No user was found with email '%s'.", email));

    }
    
    
}
