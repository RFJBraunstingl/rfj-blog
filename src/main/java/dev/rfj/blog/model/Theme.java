package dev.rfj.blog.model;

import io.quarkus.qute.Template;

public interface Theme {

    Template getBlogOverviewTemplate();
}