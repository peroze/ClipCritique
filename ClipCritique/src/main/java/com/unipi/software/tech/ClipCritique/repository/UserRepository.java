package com.unipi.software.tech.ClipCritique.repository;

import com.unipi.software.tech.ClipCritique.model.User;
import com.unipi.software.tech.ClipCritique.model.Video;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user FROM User user WHERE user.email =:email")
    Optional<User> findUserByEmail(String email);

    @Query(value = "SELECT user FROM User user WHERE user.dateOfBirth < :younger AND user.dateOfBirth > :older")
    List<User> findUserByAge(LocalDate older, LocalDate younger);

    @Transactional
    @Modifying
    @Query("DELETE FROM User user WHERE user.id = :id")
    void deleteById(@Param("id") Long id);

    Optional<User> findUserById(Long id);

    List<User> findAllByDateOfBirthBetween(
            LocalDate dateOfBirthStart,
            LocalDate dateOfBirthEnd);

}
