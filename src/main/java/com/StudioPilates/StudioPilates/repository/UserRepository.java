package com.StudioPilates.StudioPilates.repository;

import com.StudioPilates.StudioPilates.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
