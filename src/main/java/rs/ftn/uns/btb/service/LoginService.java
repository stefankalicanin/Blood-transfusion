package rs.ftn.uns.btb.service;

import rs.ftn.uns.btb.model.User;
import rs.ftn.uns.btb.model.dto.LoginDTO;

public interface LoginService {
    LoginDTO checkLogin(String email, String password);
}
