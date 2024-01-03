package com.example.prepodov_net.Services.Implementation;

import com.example.prepodov_net.Entity.PostEntity;
import com.example.prepodov_net.Repository.PostRepository;
import com.example.prepodov_net.Services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostServiceImplementation implements PostService {

    private PostRepository postRepository;

    @Override
    public void savePost(PostEntity post) {
        postRepository.save(post);
    }

    @Override
    public void deletePost(PostEntity post) {
        postRepository.delete(post);
    }

    @Override
    public PostEntity getPostById(long id) throws Exception {
        return postRepository.findById(id).orElseThrow(() -> new Exception("Нет такого поста!"));
    }

    @Override
    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }
}
