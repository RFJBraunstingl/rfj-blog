package dev.rfj.renderer.impl;

import dev.rfj.renderer.AvailableBlogPostsRenderer;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DefaultAvailableBlogPostsRenderer implements AvailableBlogPostsRenderer {

    @Override
    public String renderAvailableBlogPosts() {
        return "";
    }
}
