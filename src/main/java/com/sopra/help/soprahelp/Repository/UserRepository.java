package com.sopra.help.soprahelp.Repository;

import com.sopra.help.soprahelp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByNom(String nom);

    Boolean existsByNom(String nom);

    Boolean existsByEmail(String email);
}
