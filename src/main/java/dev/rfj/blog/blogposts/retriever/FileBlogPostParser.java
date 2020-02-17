package dev.rfj.blog.blogposts.retriever;

import dev.rfj.blog.adapter.markdown.MarkdownHtmlConversionAdapter;
import dev.rfj.blog.model.BlogPost;
import dev.rfj.blog.util.StreamUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.*;

@ApplicationScoped
class FileBlogPostParser {

    private MarkdownHtmlConversionAdapter markdownHtmlConverter;

    FileBlogPostParser() {}

    @Inject
    FileBlogPostParser(MarkdownHtmlConversionAdapter markdownHtmlConverter) {
        this.markdownHtmlConverter = markdownHtmlConverter;
    }

    public BlogPost parseFile(File file) {
        try (InputStream fileInputStream = new FileInputStream(file)) {
            String fileName = file.getName();
            String fileContent = StreamUtils.readStream(fileInputStream);
            String fileContentAsHtml = markdownHtmlConverter.convertMarkdownToHtml(fileContent);

            return BlogPost.builder()
                    .name(fileName)
                    // TODO change the description as soon as adding meta data support!
                    .description(fileContentAsHtml)
                    .text(fileContentAsHtml)
                    .build();
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("Could not read the file to be parsed, this should not happen!");
        } catch (IOException e) {
            throw new IllegalStateException("Error reading the given blog post file!");
        }
    }
}
