package com.example.diplom_spring.repo;

import com.example.diplom_spring.models.Link;
import org.springframework.data.repository.CrudRepository;

public interface LinkRepository extends CrudRepository<Link, Long> {
    boolean existsByShortLink(String shortLink);
}
