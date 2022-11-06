package rs.ftn.uns.btb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ftn.uns.btb.service.AdminService;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    public final AdminService _adminService;

    @Autowired
    public AdminController(AdminService _adminService) { this._adminService = _adminService; }
}
