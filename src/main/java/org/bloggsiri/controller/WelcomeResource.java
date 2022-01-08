package org.bloggsiri.controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("welcome")
public class WelcomeResource {

    @CheckedTemplate(requireTypeSafeExpressions = false)
    public static class Templates {
        public static native TemplateInstance welcome();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("name") String name) {



        List<String> blogsposts = List.of("post1", "post2");

        return Templates.welcome().data("name", "Welcome page")
                .data("title","my personal blog")
                .data("blogposts",blogsposts);
    }
}
