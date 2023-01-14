package hitzseb.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitzseb.blog.models.Post;
import hitzseb.blog.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	public Post getPostById(Long id) {
		return postRepository.findById(id).orElse(null);
	}

	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	public void savePost(Post post) {
		postRepository.save(post);
	}

	public void deletePostById(Long id) {
		postRepository.deleteById(id);
	}
	
}
