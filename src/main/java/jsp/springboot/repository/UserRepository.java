package jsp.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}