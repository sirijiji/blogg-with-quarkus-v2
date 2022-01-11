package org.bloggsiri.controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.RawString;
import io.quarkus.qute.TemplateInstance;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Path("welcome")
public class WelcomeResource {

    @CheckedTemplate(requireTypeSafeExpressions = false)
    public static class Templates {
        public static native TemplateInstance welcome();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("name") String name) throws IOException {

        String welcometext = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/markdown/welcome.md"), StandardCharsets.UTF_8))
                .lines()
                .collect(joining("\n"));

        Parser parser = Parser.builder().build();
        Node document = parser.parse(welcometext);
        HtmlRenderer renderer = HtmlRenderer.builder().escapeHtml(false).build();

        List<RawString> blogsposts = List.of(new RawString("post1"),  new RawString(renderer.render(document)));

        return Templates.welcome().data("name", "Welcome page")
                .data("title","my personal blog")
                .data("blogposts",blogsposts);
    }
}
