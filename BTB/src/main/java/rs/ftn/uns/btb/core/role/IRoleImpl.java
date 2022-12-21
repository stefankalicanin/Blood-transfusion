package rs.ftn.uns.btb.core.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.core.role.interfaces.IRole;

@Service
public class IRoleImpl implements IRole {
    
    @Autowired
    private RoleRepository _roleRepository;

    @Override
    public Role findById(Long id) {
        Role auth = this._roleRepository.getOne(id);
        return auth;
    }

    @Override
    public List<Role> findByName(String name) {
        List<Role> roles = this._roleRepository.findByName(name);
        return roles;
    }
    
}
