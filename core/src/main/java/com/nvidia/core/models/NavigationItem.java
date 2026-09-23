package com.nvidia.core.models;

import java.util.Collections;
import java.util.List;

public class NavigationItem {

    private final String label;
    private final String link;
    private final boolean hasDropdown;
    private final List<MegaMenuItem> children;

    public NavigationItem(
            String label,
            String link,
            boolean hasDropdown,
            List<MegaMenuItem> children) {

        this.label = label;
        this.link = link;
        this.hasDropdown = hasDropdown;
        this.children = children != null
                ? children
                : Collections.emptyList();
    }

    public String getLabel() {
        return label;
    }

    public String getLink() {
        return link;
    }

    public boolean isHasDropdown() {
        return hasDropdown;
    }

    public List<MegaMenuItem> getChildren() {
        return children;
    }
}
