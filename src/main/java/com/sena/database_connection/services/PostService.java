package com.sena.database_connection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sena.database_connection.entities.Post;
import com.sena.database_connection.repositories.PostRepository;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> obetenerTodos() {
        return this.repository.findAll();
    }

    public Optional<Post> porId(Long id) {
        return this.repository.findById(id);
    }

    public Post crear(Post post) {
        return this.repository.save(post);
    }

    public Post actualizar(Post post) {
        if (post.getId() == null || !this.repository.existsById(post.getId())) {
            return null;
        }
        return this.repository.save(post);
    }

    public Post eliminar(Long id) {
        Optional<Post> postOptional = this.repository.findById(id);

        if (postOptional.isEmpty()) {
            return null;
        }

        Post postDeleted = postOptional.get();
        this.repository.deleteById(id);
        
        return postDeleted;
    }
}