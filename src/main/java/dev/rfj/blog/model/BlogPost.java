package dev.rfj.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static dev.rfj.blog.util.StringUtils.isBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogPost implements Comparable<BlogPost> {

    private String name;
    private String description;
    private String text;
    private Date creationDate;

    // TODO this is good for now, but should be written properly
    @Override
    public int compareTo(BlogPost o) {
        if (o == null || isBlank(name))
            return -1;

        return name.compareTo(o.getName());
    }
}
