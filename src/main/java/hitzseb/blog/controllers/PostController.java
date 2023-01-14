package hitzseb.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hitzseb.blog.models.Post;
import hitzseb.blog.services.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/posts")
	public String showAllPosts(Model model) {
		model.addAttribute("posts", postService.getAllPosts());
		return "posts";
	}
	
	@GetMapping("/new-post")
	public String showNewPost(Model model) {
		Post post = new Post();
		model.addAttribute("post", post);
		return "new_post";
	}
	
	@PostMapping("/new-post")
    public String newPost(@ModelAttribute Post post) {
		postService.savePost(post);
		return "redirect:/posts";
    }
	
	@GetMapping("/edit-post/{id}")
	public String showEditPost(@PathVariable Long id, Model model) {
		Post post = postService.getPostById(id);
		model.addAttribute("post", post);
		return "edit_post";
	}
	
	@PostMapping("/edit-post/{id}")
	public String udpadtePost(@PathVariable Long id, Post post) {
		Post existingPost = postService.getPostById(id);
		existingPost.setTitle(post.getTitle());
		existingPost.setBody(post.getBody());
		postService.savePost(existingPost);
		return "redirect:/posts";
	}
	
	@GetMapping("/delete-post/{id}")
    public String deletePost(@PathVariable Long id) {
		postService.deletePostById(id);
		return "redirect:/posts";
    }
	
}
