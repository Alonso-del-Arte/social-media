package com.speakr.service;

import com.speakr.entity.Post;

import java.time.Duration;
import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    Post getPostById(int id);

    Post updatePost(Post post);

    Post deletePostById(int id);

    List<Post> getAllRecentPosts(Duration interval);

    // TODO: Rest of RESTful API commands

}
