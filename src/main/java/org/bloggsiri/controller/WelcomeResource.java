package org.bloggsiri.controller;

import io.quarkus.qute.RawString;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.CheckedTemplate;
import org.bloggsiri.model.WelcomeModel;
import org.bloggsiri.repository.BlogPostRepository;
import org.common.MarkdownParserHandler;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Path("welcome")
public class WelcomeResource {

    @Inject
    private BlogPostRepository blogPostRepository;

    @Inject
    private MarkdownParserHandler markdownParserHandler;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance welcome(WelcomeModel welcomeModel);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("name") String name){

        List<RawString> blogsposts = blogPostRepository.getPosts().stream()
                .map(markdownParserHandler::parserMarkdown)
                .map(RawString::new)
                .collect(toList());

        WelcomeModel welcomeModel = new WelcomeModel();
        welcomeModel.setName("Welcome page");
        welcomeModel.setTitle("my personal blog");
        welcomeModel.setBlogposts(blogsposts);

        return Templates.welcome(welcomeModel);
    }
}
