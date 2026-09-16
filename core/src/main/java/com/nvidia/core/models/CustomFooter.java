package com.nvidia.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CustomFooter {

    @SlingObject
    private Resource resource;

    private List<FooterLink> companyLinks;
    private List<FooterLink> newsLinks;
    private List<FooterLink> popularLinks;

    @PostConstruct
    protected void init() {
        companyLinks = getLinks("companyLinks");
        newsLinks = getLinks("newsLinks");
        popularLinks = getLinks("popularLinks");
    }

    private List<FooterLink> getLinks(String childName) {

        Resource linksResource = resource.getChild(childName);

        if (linksResource == null) {
            return Collections.emptyList();
        }

        List<FooterLink> links = new ArrayList<>();

        for (Resource linkResource : linksResource.getChildren()) {

            String label = linkResource.getValueMap().get(
                    "label",
                    String.class);

            String url = linkResource.getValueMap().get(
                    "url",
                    String.class);

            if (label != null && !label.isEmpty()) {
                links.add(new FooterLink(label, url));
            }
        }

        return links;
    }

    public List<FooterLink> getCompanyLinks() {
        return companyLinks;
    }

    public List<FooterLink> getNewsLinks() {
        return newsLinks;
    }

    public List<FooterLink> getPopularLinks() {
        return popularLinks;
    }

    public static class FooterLink {

        private final String label;
        private final String url;

        public FooterLink(String label, String url) {
            this.label = label;
            this.url = url;
        }

        public String getLabel() {
            return label;
        }

        public String getUrl() {
            return url;
        }
    }
}