package org.bloggsiri.repository;

import org.apache.commons.io.FileUtils;

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

    public List<String> fetchPosts() throws IOException, URISyntaxException {

        URL resource = getClass().getClassLoader().getResource(POST_RESOURCES);
        File file = Paths.get(resource.toURI()).toFile();

        Collection<File> files = FileUtils.listFiles(file, null, false);

        List<String> posts = new ArrayList<>();
        for (File postFile : files) {
            posts.add(Files.readString(postFile.toPath()));
        }

       return posts;

    }

}
