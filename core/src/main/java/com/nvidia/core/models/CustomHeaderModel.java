package com.nvidia.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CustomHeaderModel {

    // =========================================================
    // Logo
    // =========================================================

    @ValueMapValue
    private String logo;

    @ValueMapValue
    private String logoLink;


    // =========================================================
    // Navigation
    // =========================================================

    @ValueMapValue
    private String productsLabel;

    @ValueMapValue
    private String productsLink;

    @ValueMapValue
    private String solutionsLabel;

    @ValueMapValue
    private String solutionsLink;

    @ValueMapValue
    private String industriesLabel;

    @ValueMapValue
    private String industriesLink;

    @ValueMapValue
    private String resourcesLabel;

    @ValueMapValue
    private String resourcesLink;

    @ValueMapValue
    private String companyLabel;

    @ValueMapValue
    private String companyLink;


    // =========================================================
    // Header Actions - Show / Hide
    // =========================================================

    @ValueMapValue
    private boolean showSearch;

    @ValueMapValue
    private boolean showLanguage;

    @ValueMapValue
    private boolean showSignIn;

    @ValueMapValue
    private boolean showMarketplace;


    // =========================================================
    // Header Actions - Links
    // =========================================================

    @ValueMapValue
    private String searchLink;

    @ValueMapValue
    private String languageLink;

    @ValueMapValue
    private String signInLink;

    @ValueMapValue
    private String marketplaceLink;


    // =========================================================
    // URL Helper
    // =========================================================

    /**
     * Converts an AEM content path into a page URL.
     *
     * Example:
     *
     * /content/nvidia/us/en/company
     *
     * becomes:
     *
     * /content/nvidia/us/en/company.html
     */
    private String pageUrl(String path) {

        if (path == null || path.isEmpty()) {
            return "#";
        }

        // External URL
        if (path.startsWith("http://")
                || path.startsWith("https://")
                || path.startsWith("//")) {

            return path;
        }

        // Already has an extension
        if (path.endsWith(".html")
                || path.contains(".")) {

            return path;
        }

        // AEM page path
        if (path.startsWith("/content/")) {
            return path + ".html";
        }

        return path;
    }


    // =========================================================
    // Logo
    // =========================================================

    public String getLogo() {
        return logo;
    }

    public String getLogoLink() {
        return pageUrl(logoLink);
    }


    // =========================================================
    // Products
    // =========================================================

    public String getProductsLabel() {

        if (productsLabel != null && !productsLabel.isEmpty()) {
            return productsLabel;
        }

        return "Products";
    }

    public String getProductsLink() {
        return pageUrl(productsLink);
    }


    // =========================================================
    // Solutions
    // =========================================================

    public String getSolutionsLabel() {

        if (solutionsLabel != null && !solutionsLabel.isEmpty()) {
            return solutionsLabel;
        }

        return "Solutions";
    }

    public String getSolutionsLink() {
        return pageUrl(solutionsLink);
    }


    // =========================================================
    // Industries
    // =========================================================

    public String getIndustriesLabel() {

        if (industriesLabel != null && !industriesLabel.isEmpty()) {
            return industriesLabel;
        }

        return "Industries";
    }

    public String getIndustriesLink() {
        return pageUrl(industriesLink);
    }


    // =========================================================
    // Resources
    // =========================================================

    public String getResourcesLabel() {

        if (resourcesLabel != null && !resourcesLabel.isEmpty()) {
            return resourcesLabel;
        }

        return "Resources";
    }

    public String getResourcesLink() {
        return pageUrl(resourcesLink);
    }


    // =========================================================
    // Company
    // =========================================================

    public String getCompanyLabel() {

        if (companyLabel != null && !companyLabel.isEmpty()) {
            return companyLabel;
        }

        return "Company";
    }

    public String getCompanyLink() {
        return pageUrl(companyLink);
    }


    // =========================================================
    // Header Actions - Show / Hide
    // =========================================================

    public boolean isShowSearch() {
        return showSearch;
    }

    public boolean isShowLanguage() {
        return showLanguage;
    }

    public boolean isShowSignIn() {
        return showSignIn;
    }

    public boolean isShowMarketplace() {
        return showMarketplace;
    }


    // =========================================================
    // Header Actions - Links
    // =========================================================

    public String getSearchLink() {
        return pageUrl(searchLink);
    }

    public String getLanguageLink() {
        return pageUrl(languageLink);
    }

    public String getSignInLink() {
        return pageUrl(signInLink);
    }

    public String getMarketplaceLink() {
        return pageUrl(marketplaceLink);
    }
}
