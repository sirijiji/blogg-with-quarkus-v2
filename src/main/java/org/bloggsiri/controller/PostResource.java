package org.bloggsiri.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/post")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {

//    @Inject
//    private PostRepository postRepository;
//
//    @GET
//    public List<Post> list() {
//        return postRepository.listAll();
//    }
//
//
//    @POST
//    @Transactional
//    public void savePost(Post post) {
//        postRepository.persist(post);
//    }
}
