package com.item.beststorezz.repository;

import com.item.beststorezz.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<Users,Long> {
    List<Users> findByFirstNameContainingIgnoreCase(String firstName);
    List<Users> findByLastNameContainingIgnoreCase(String lastName);

   Users findByEmail(String email);

}
