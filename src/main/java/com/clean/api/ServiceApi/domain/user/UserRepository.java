package com.clean.api.ServiceApi.domain.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByUsername(String username);

    Page<User> findAllByActiveTrue(Pageable pageable);

    Page<User> findAll(Pageable pageable);

    Boolean findActiveById(Long id);
}
