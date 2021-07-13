package org.bloggsiri.repository;

import org.apache.commons.io.FileUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class BlogPostRepository {

    private static String POST_RESOURCES = "md/blogpost/";

    private List<String> posts;

    @PostConstruct
    public void init() throws IOException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(POST_RESOURCES);
        System.out.println(resource.toURI().toString());
        File file = Paths.get(resource.toURI()).toFile();

        Collection<File> files = FileUtils.listFiles(file, null, false);

        posts = new ArrayList<>();
        for (File postFile : files) {
            posts.add(Files.readString(postFile.toPath()));
        }
    }

    public List<String> getPosts() {
        return posts;
    }
}
