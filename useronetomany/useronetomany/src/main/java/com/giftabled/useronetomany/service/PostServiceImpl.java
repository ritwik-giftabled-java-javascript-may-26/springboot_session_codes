package com.giftabled.useronetomany.service;

import com.giftabled.useronetomany.model.Post;
import com.giftabled.useronetomany.model.User;
import com.giftabled.useronetomany.repository.PostRepository;
import com.giftabled.useronetomany.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post addPost(int userId, Post post) {
        User user= userRepository.findById(userId).get();
        post.setUser(user);
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPost(int postId) {
        return postRepository.findById(postId).get();
    }

    @Override
    public Post updatePost(int postId, Post post) {
        post.setPostId(postId);
        postRepository.save(post);
        return null;
    }

    @Override
    public String deletePost(int postId) {
        if(postRepository.existsById(postId)){
            postRepository.deleteById(postId);
            return "post deleted successfully";
        }
        return "post not found with given id";
    }
}
