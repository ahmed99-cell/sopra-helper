package com.sopra.help.soprahelp.Repository;

import com.sopra.help.soprahelp.Model.ERole;
import com.sopra.help.soprahelp.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);

}
