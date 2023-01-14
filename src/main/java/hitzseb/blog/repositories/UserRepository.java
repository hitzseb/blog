package hitzseb.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hitzseb.blog.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

}
