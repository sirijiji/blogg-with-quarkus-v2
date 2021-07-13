package org.acme.resteasy;

import io.quarkus.test.junit.QuarkusTest;
import org.bloggsiri.repository.BlogPostRepository;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ExampleResourceTest {

    @Inject
    private BlogPostRepository blogPostRepository;

    @Test
    public void testHelloEndpoint() throws IOException, URISyntaxException {

//        List<String> strings = blogPostRepository.fetchPosts();

//        System.out.println(strings);
//        given()
//          .when().get("/resteasy/hello")
//          .then()
//             .statusCode(200)
//             .body(is("hello"));
    }

}