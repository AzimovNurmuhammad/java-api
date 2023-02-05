package com.NextSpring.NextSpring.Repository;

import com.NextSpring.NextSpring.entity.enummration.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByLogin(String login);

    User findByLogin(String login);
}
