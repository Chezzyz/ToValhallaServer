package ru.rsc.tovalhallaserver.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rsc.tovalhallaserver.domain.model.Admin;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByUsername(String username);

    Optional<Admin> findAdminByToken(String token);
}
