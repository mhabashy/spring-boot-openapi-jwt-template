package org.stminaclinic.api.stminaclinicjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stminaclinic.api.stminaclinicjava.models.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
}
