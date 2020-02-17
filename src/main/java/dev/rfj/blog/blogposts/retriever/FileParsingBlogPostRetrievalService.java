package dev.rfj.blog.blogposts.retriever;

import dev.rfj.blog.model.BlogPost;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * The directory of the files to be parsed as blog posts shall be defined as
 * - the directory 'blog-posts' in the directory 'pages' in the execution dir
 *
 * The <code>System</code> property called "user.dir" presents the path of the execution directory, thus the application
 * shall pick up all files from the path:
 * 'System.getProperty("user.dir")/pages/blog-posts/'
 */
@ApplicationScoped
public class FileParsingBlogPostRetrievalService implements BlogPostRetrievalService {

    private static final String PATH_TO_BLOG_POST_DIR = System.getProperty("user.dir") + "/pages/blog-posts/";

    private FileBlogPostParser fileBlogPostParser;

    FileParsingBlogPostRetrievalService() {}

    @Inject
    public FileParsingBlogPostRetrievalService(
            final FileBlogPostParser fileBlogPostParser) {
        this.fileBlogPostParser = fileBlogPostParser;
    }

    @Override
    public List<BlogPost> getAvailableBlogPosts() {
        try (Stream<Path> paths = Files.walk(Paths.get(PATH_TO_BLOG_POST_DIR))) {

            return paths
                    .filter(Files::isReadable)
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .map(fileBlogPostParser::parseFile)
                    .collect(toList());

        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
