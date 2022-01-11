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
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

@Path("/")
public class IndexResource {

    @CheckedTemplate(requireTypeSafeExpressions = false)
    public static class Templates {
        public static native TemplateInstance index();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("name") String name) throws IOException {


        List<RawString> blogsposts = Files.list(new File("target/classes/markdown/posts").toPath())
                .map(path -> {

                    System.out.println(path.toAbsolutePath());
                    System.out.println(path.getFileName());
                    System.out.println(path.toFile().getName());
                    BasicFileAttributes attr = null;
                    try {
                        attr = Files.readAttributes(path.toFile().toPath(), BasicFileAttributes.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println("creationTime: " + attr.creationTime());
                    System.out.println("lastAccessTime: " + attr.lastAccessTime());
                    System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

                    InputStreamReader inputStreamReader = new InputStreamReader(getClass().getResourceAsStream("/markdown/posts/" + path.toFile().getName()), StandardCharsets.UTF_8);
                    String post = new BufferedReader(inputStreamReader)
                            .lines()
                            .collect(joining("\n"));

                    Parser parser = Parser.builder().build();
                    Node document = parser.parse(post);
                    HtmlRenderer renderer = HtmlRenderer.builder().escapeHtml(false).build();

                    return new RawString(renderer.render(document));

                }).collect(Collectors.toList());


        return Templates.index()
                .data("title","Sirisak blog")
                .data("blogposts",blogsposts);
    }
}
