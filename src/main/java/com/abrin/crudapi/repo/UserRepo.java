package com.abrin.crudapi.repo;

import com.abrin.crudapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
