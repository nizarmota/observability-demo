package dev.nizar.observabilitydemo.post;

import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface JsonPlaceholderService {

    @GetExchange("/posts")
    List<Post> findAll();


    @GetExchange("/posts/{id}")
    Post findById(Integer id);
}
