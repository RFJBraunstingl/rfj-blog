package dev.rfj.blog

import dev.rfj.blog.blogposts.retriever.BlogPostRetrievalService
import dev.rfj.blog.renderer.AvailableBlogPostsRenderer
import dev.rfj.blog.rest.BlogResource
import spock.lang.Specification

import static dev.rfj.blog.testdata.TestBlogPosts.SIMPLE_REDUCED_BLOG_POSTS

/**
 * As a user,
 * when calling the blog overview resource
 * I want to be presented with a list of available blog posts
 * rendered as html
 */
class US01_BlogOverviewResourceSpec extends Specification {

    BlogPostRetrievalService blogPostRetrievalService
    AvailableBlogPostsRenderer renderer
    BlogResource blogResource

    setup() {
        blogPostRetrievalService = Mock()
        blogPostRetrievalService.availableBlogPosts >> SIMPLE_REDUCED_BLOG_POSTS
        renderer = Mock()
        blogResource = new BlogResource(renderer)
    }

    def "the REST resource for the blog overview retrieves the available blog posts and renders them as HTML"() {
        when: "calling the REST resource for retrieving the blog overview"
        def response = blogResource.availableBlogPosts

        expect: "the data of the available blog posts is present in the response"
        SIMPLE_REDUCED_BLOG_POSTS.each { blogPost ->
            response.contains(blogPost.name)
            response.contains(blogPost.description)
        }

        and: "the available blog posts are transformed by the renderer"
    }
}
