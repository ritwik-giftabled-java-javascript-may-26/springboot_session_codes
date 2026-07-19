package com.giftabled.useronetomany.controller;

import com.giftabled.useronetomany.model.Post;
import com.giftabled.useronetomany.service.PostService;
import com.giftabled.useronetomany.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/post")
    public ResponseEntity<List<Post>> getAllPosts() {

        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<?> getPost(@PathVariable int postId) {

        Post post = postService.getPost(postId);

        if(post != null)
            return new ResponseEntity<>(post, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable int postId) {

        String result = postService.deletePost(postId);

        if(result.equals("Post deleted successfully"))
            return new ResponseEntity<>(result, HttpStatus.OK);

        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/post/user/{userId}")
    public ResponseEntity<?> addPost(@PathVariable int userId, @RequestBody Post post){
        Post saved=postService.addPost(userId,post);
        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }

    @PutMapping("/post/{postId}")
    public ResponseEntity<?> updatePost(@PathVariable int postId, @RequestBody Post post){
        Post updated=postService.updatePost(postId,post);
        return new ResponseEntity<> (updated,HttpStatus.OK);
    }

}
