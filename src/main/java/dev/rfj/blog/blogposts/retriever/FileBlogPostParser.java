package dev.rfj.blog.blogposts.retriever;

import dev.rfj.blog.model.BlogPost;
import dev.rfj.blog.util.StreamUtils;

import java.io.*;

class FileBlogPostParser {

    private final File file;

    static BlogPost parseFile(File file) {
        return new FileBlogPostParser(file).parse();
    }

    private FileBlogPostParser(File file) {
        this.file = file;
    }

    private BlogPost parse() {
        try (InputStream fileInputStream = new FileInputStream(file)) {
            String fileName = file.getName();
            String fileContent = StreamUtils.readStream(fileInputStream);

            return BlogPost.builder()
                    .name(fileName)
                    // TODO change the description as soon as adding meta data support!
                    .description(fileContent)
                    .text(fileContent)
                    .build();
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("Could not read the file to be parsed, this should not happen!");
        } catch (IOException e) {
            throw new IllegalStateException("Error reading the given blog post file!");
        }
    }
}
