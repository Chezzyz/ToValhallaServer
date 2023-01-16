package ru.rsc.tovalhallaserver.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rsc.tovalhallaserver.dto.AdminTokenDto;
import ru.rsc.tovalhallaserver.dto.UsernameDto;
import ru.rsc.tovalhallaserver.services.AdminService;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "api/admin")
public class AdminsController {
    private final AdminService adminService;

    @GetMapping(path = "getToken")
    @ResponseBody
    @CrossOrigin
    public AdminTokenDto getTokenForAdmin(@RequestParam String username, @RequestParam String password){
        return new AdminTokenDto(adminService.getTokenForAdmin(username, password));
    }

    @GetMapping(path = "getUsername")
    @ResponseBody
    @CrossOrigin
    public UsernameDto getUsername(@RequestParam String token){
        return new UsernameDto(adminService.getUsername(token));
    }
}
