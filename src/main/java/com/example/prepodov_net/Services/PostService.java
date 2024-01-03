package com.example.prepodov_net.Services;

import com.example.prepodov_net.Entity.PostEntity;

import java.util.List;
import java.util.Optional;

public interface PostService {

    void savePost(PostEntity post);
    void deletePost(PostEntity post);
    PostEntity getPostById(long id) throws Exception;
    List<PostEntity> getAllPosts();

}
