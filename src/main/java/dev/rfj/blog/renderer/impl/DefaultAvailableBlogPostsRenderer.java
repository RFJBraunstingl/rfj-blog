package dev.rfj.blog.renderer.impl;

import dev.rfj.blog.renderer.AvailableBlogPostsRenderer;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DefaultAvailableBlogPostsRenderer implements AvailableBlogPostsRenderer {

    @Override
    public String renderAvailableBlogPosts() {
        return "";
    }
}
