package ru.rsc.tovalhallaserver.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rsc.tovalhallaserver.domain.model.Admin;
import ru.rsc.tovalhallaserver.domain.repository.AdminRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository repository;

    public String getTokenForAdmin(String username, String password){
        Optional<Admin> admin = repository.findByUsername(username);
        if(admin.isPresent() && admin.get().getPassword().equals(password)){
            return admin.get().getToken();
        }
        return null;
    }

    public String getUsername(String token){
        Optional<Admin> admin = repository.findAdminByToken(token);
        return admin.map(Admin::getUsername).orElse(null);
    }
}
