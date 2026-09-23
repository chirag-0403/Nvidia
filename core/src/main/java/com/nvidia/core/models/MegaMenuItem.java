package com.nvidia.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class MegaMenuItem {

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private String link;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return pageUrl(link);
    }

    private static String pageUrl(String path) {

        if (path == null || path.trim().isEmpty()) {
            return "#";
        }

        path = path.trim();

        if (path.startsWith("http://")
                || path.startsWith("https://")
                || path.startsWith("//")) {
            return path;
        }

        if (path.endsWith(".html")) {
            return path;
        }

        if (path.contains(".")) {
            return path;
        }

        if (path.startsWith("/content/")) {
            return path + ".html";
        }

        return path;
    }
}