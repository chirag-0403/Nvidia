package com.nvidia.core.models;

import java.util.Collections;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CustomHeaderModel {

    // =========================================================
    // LOGO
    // =========================================================

    @ValueMapValue
    private String logo;

    @ValueMapValue
    private String logoLink;


    // =========================================================
    // PRIMARY NAVIGATION
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


    // =========================================================
    // MEGA MENU
    // =========================================================

    @ChildResource(name = "productsMegaMenu")
    private List<MegaMenuItem> productsItems;

    @ChildResource(name = "solutionsMegaMenu")
    private List<MegaMenuItem> solutionsItems;

    @ChildResource(name = "industriesMegaMenu")
    private List<MegaMenuItem> industriesItems;


    // =========================================================
    // RIGHT-SIDE NAVIGATION
    // =========================================================

    @ValueMapValue
    private String shopLabel;

    @ValueMapValue
    private String shopLink;

    @ValueMapValue
    private String driversLabel;

    @ValueMapValue
    private String driversLink;

    @ValueMapValue
    private String supportLabel;

    @ValueMapValue
    private String supportLink;


    // =========================================================
    // HEADER ACTIONS
    // =========================================================

    @ValueMapValue
    private boolean showSearch;

    @ValueMapValue
    private boolean showLanguage;

    @ValueMapValue
    private boolean showSignIn;


    // =========================================================
    // HEADER ACTION LINKS
    // =========================================================

    @ValueMapValue
    private String searchLink;

    @ValueMapValue
    private String languageLink;

    @ValueMapValue
    private String signInLink;


    // =========================================================
    // URL HELPER
    // =========================================================

    private String pageUrl(String path) {

        if (path == null || path.trim().isEmpty()) {
            return "#";
        }

        path = path.trim();

        // External URL
        if (path.startsWith("http://")
                || path.startsWith("https://")
                || path.startsWith("//")) {

            return path;
        }

        // Already has .html
        if (path.endsWith(".html")) {
            return path;
        }

        // Other URLs containing an extension
        if (path.contains(".")) {
            return path;
        }

        // AEM page path
        if (path.startsWith("/content/")) {
            return path + ".html";
        }

        return path;
    }


    // =========================================================
    // LOGO
    // =========================================================

    public String getLogo() {
        return logo;
    }

    public String getLogoLink() {
        return pageUrl(logoLink);
    }


    // =========================================================
    // PRODUCTS
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

    public List<MegaMenuItem> getProductsItems() {

        if (productsItems != null) {
            return productsItems;
        }

        return Collections.emptyList();
    }


    // =========================================================
    // SOLUTIONS
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

    public List<MegaMenuItem> getSolutionsItems() {

        if (solutionsItems != null) {
            return solutionsItems;
        }

        return Collections.emptyList();
    }


    // =========================================================
    // INDUSTRIES
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

    public List<MegaMenuItem> getIndustriesItems() {

        if (industriesItems != null) {
            return industriesItems;
        }

        return Collections.emptyList();
    }


    // =========================================================
    // SHOP
    // =========================================================

    public String getShopLabel() {

        if (shopLabel != null && !shopLabel.isEmpty()) {
            return shopLabel;
        }

        return "Shop";
    }

    public String getShopLink() {
        return pageUrl(shopLink);
    }


    // =========================================================
    // DRIVERS
    // =========================================================

    public String getDriversLabel() {

        if (driversLabel != null && !driversLabel.isEmpty()) {
            return driversLabel;
        }

        return "Drivers";
    }

    public String getDriversLink() {
        return pageUrl(driversLink);
    }


    // =========================================================
    // SUPPORT
    // =========================================================

    public String getSupportLabel() {

        if (supportLabel != null && !supportLabel.isEmpty()) {
            return supportLabel;
        }

        return "Support";
    }

    public String getSupportLink() {
        return pageUrl(supportLink);
    }


    // =========================================================
    // HEADER ACTIONS
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


    // =========================================================
    // SEARCH
    // =========================================================

    public String getSearchLink() {
        return pageUrl(searchLink);
    }


    // =========================================================
    // LANGUAGE
    // =========================================================

    public String getLanguageLink() {
        return pageUrl(languageLink);
    }


    // =========================================================
    // SIGN IN
    // =========================================================

    public String getSignInLink() {
        return pageUrl(signInLink);
    }
}