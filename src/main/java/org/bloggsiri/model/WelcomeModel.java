package org.bloggsiri.model;

import io.quarkus.qute.RawString;
import lombok.Data;

import java.util.List;

@Data
public class WelcomeModel {

    private String name;

    private String title;

    private List<RawString> blogposts;
}
