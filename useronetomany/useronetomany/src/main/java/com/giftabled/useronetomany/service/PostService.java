package com.giftabled.useronetomany.service;

import com.giftabled.useronetomany.model.Post;

import java.util.List;

public interface PostService {
    Post addPost(int userId, Post post);

    List<Post> getAllPosts();

    Post getPost(int postId);

    Post updatePost(int postId, Post post);

    String deletePost(int postId);
}
