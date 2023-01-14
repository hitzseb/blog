package hitzseb.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hitzseb.blog.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
