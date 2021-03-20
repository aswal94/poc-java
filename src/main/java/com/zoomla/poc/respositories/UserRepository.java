package com.zoomla.poc.respositories;

import com.zoomla.poc.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFullName(String fullName);

    User findById(long id);
}
