package org.bloggsiri.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.bloggsiri.model.Post;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PostRepository implements PanacheRepository<Post> {
}
