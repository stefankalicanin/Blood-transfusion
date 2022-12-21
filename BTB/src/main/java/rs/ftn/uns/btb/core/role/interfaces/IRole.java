package rs.ftn.uns.btb.core.role.interfaces;

import java.util.List;

import rs.ftn.uns.btb.core.role.Role;

public interface IRole {
    Role findById(Long id);

    List<Role> findByName(String name);
}
