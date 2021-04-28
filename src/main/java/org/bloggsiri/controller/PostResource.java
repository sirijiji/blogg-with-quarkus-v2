package org.bloggsiri.controller;

import org.bloggsiri.repository.PostRepository;
import org.bloggsiri.model.Post;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/post")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {

    @Inject
    private PostRepository postRepository;

    @GET
    public List<Post> list() {
        return postRepository.listAll();
    }


    @POST
    @Transactional
    public void savePost(Post post) {
        postRepository.persist(post);
    }
}
