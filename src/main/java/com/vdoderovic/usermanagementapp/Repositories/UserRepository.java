package com.vdoderovic.usermanagementapp.Repositories;

import com.vdoderovic.usermanagementapp.Entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select user from User user " +
            "join fetch user.company company " +
            "where company.id = ?1")
    List<User> getAllByCompIdEager(Integer id);

    @Query(value = "select user from User user where user.isActive=false")
    List<User> getAllDeactivated();

    List<User> findAllByCreatedAt(LocalDate date);

    @Modifying
    @Query(value = "update User user set user.isActive = false where user.id = ?1")
    void softDeleteById(Integer id);
}
