package com.StudioPilates.StudioPilates.repository;

import com.StudioPilates.StudioPilates.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
