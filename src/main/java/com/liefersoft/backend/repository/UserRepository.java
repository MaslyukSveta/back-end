package com.liefersoft.backend.repository;

import com.liefersoft.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for User entity.
 * This interface extends JpaRepository, providing a set of standard methods for data access.
 * It is annotated with @Repository, indicating that it's a Spring repository.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByFirstNameAndLastNameAndPhoneNumber(String firstName, String lastName, String phoneNumber);
}
