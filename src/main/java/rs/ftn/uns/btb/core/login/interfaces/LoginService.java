package rs.ftn.uns.btb.core.login.interfaces;

import rs.ftn.uns.btb.core.login.dtos.LoginDTO;

public interface LoginService {
    LoginDTO checkLogin(String email, String password);
}
