(function () {
    "use strict";

    function initHeader() {

        const headers = document.querySelectorAll(".nv-header");

        if (!headers.length) {
            return;
        }

        headers.forEach(function (header) {

            // =========================================================
            // ELEMENTS
            // =========================================================

            const menuButton = header.querySelector(
                "[data-menu-button]"
            );

            const mobileMenu = header.querySelector(
                "[data-mobile-menu]"
            );

            const megaMenuItems = header.querySelectorAll(
                "[data-mega-menu]"
            );


            // =========================================================
            // MOBILE MENU
            // =========================================================

            if (menuButton && mobileMenu) {

                menuButton.addEventListener("click", function () {

                    const isOpen = !mobileMenu.hidden;

                    if (isOpen) {
                        closeMobileMenu(header);
                    } else {
                        openMobileMenu(header);
                    }

                });


                // Close mobile menu after clicking a link

                const mobileLinks = mobileMenu.querySelectorAll("a");

                mobileLinks.forEach(function (link) {

                    link.addEventListener("click", function () {
                        closeMobileMenu(header);
                    });

                });

            }


            // =========================================================
            // DESKTOP MEGA MENUS
            // =========================================================

            megaMenuItems.forEach(function (item) {

                const trigger = item.querySelector(
                    "[data-mega-trigger]"
                );

                const megaMenu = item.querySelector(
                    "[data-mega-panel]"
                );

                if (!trigger || !megaMenu) {
                    return;
                }


                // -----------------------------------------------------
                // Accessibility state
                // -----------------------------------------------------

                trigger.setAttribute(
                    "aria-expanded",
                    "false"
                );


                // -----------------------------------------------------
                // Mouse enter
                // -----------------------------------------------------

                item.addEventListener(
                    "mouseenter",
                    function () {

                        if (window.innerWidth <= 850) {
                            return;
                        }

                        closeAllMegaMenus(header, item);

                        item.classList.add("is-open");

                        trigger.setAttribute(
                            "aria-expanded",
                            "true"
                        );

                    }
                );


                // -----------------------------------------------------
                // Mouse leave
                // -----------------------------------------------------

                item.addEventListener(
                    "mouseleave",
                    function () {

                        if (window.innerWidth <= 850) {
                            return;
                        }

                        item.classList.remove("is-open");

                        trigger.setAttribute(
                            "aria-expanded",
                            "false"
                        );

                    }
                );


                // -----------------------------------------------------
                // Keyboard support
                // -----------------------------------------------------

                trigger.addEventListener(
                    "keydown",
                    function (event) {

                        if (event.key === "Escape") {

                            closeAllMegaMenus(header);

                            trigger.focus();

                            return;
                        }

                        if (
                            event.key === "ArrowDown" &&
                            window.innerWidth > 850
                        ) {

                            event.preventDefault();

                            closeAllMegaMenus(header, item);

                            item.classList.add("is-open");

                            trigger.setAttribute(
                                "aria-expanded",
                                "true"
                            );

                            const firstLink =
                                megaMenu.querySelector("a");

                            if (firstLink) {
                                firstLink.focus();
                            }

                        }

                    }
                );

            });


            // =========================================================
            // CLICK OUTSIDE HEADER
            // =========================================================

            document.addEventListener(
                "click",
                function (event) {

                    if (!header.contains(event.target)) {

                        closeAllMegaMenus(header);

                    }

                }
            );


            // =========================================================
            // ESCAPE KEY
            // =========================================================

            document.addEventListener(
                "keydown",
                function (event) {

                    if (event.key !== "Escape") {
                        return;
                    }

                    closeAllMegaMenus(header);

                    if (
                        mobileMenu &&
                        !mobileMenu.hidden
                    ) {

                        closeMobileMenu(header);

                    }

                }
            );


            // =========================================================
            // WINDOW RESIZE
            // =========================================================

            window.addEventListener(
                "resize",
                function () {

                    if (window.innerWidth <= 850) {

                        closeAllMegaMenus(header);

                    }

                }
            );

        });
    }


    // =============================================================
    // OPEN MOBILE MENU
    // =============================================================

    function openMobileMenu(header) {

        const menuButton = header.querySelector(
            "[data-menu-button]"
        );

        const mobileMenu = header.querySelector(
            "[data-mobile-menu]"
        );

        if (!menuButton || !mobileMenu) {
            return;
        }

        mobileMenu.hidden = false;

        menuButton.setAttribute(
            "aria-expanded",
            "true"
        );

        menuButton.classList.add(
            "is-open"
        );

        header.classList.add(
            "nv-header--menu-open"
        );

    }


    // =============================================================
    // CLOSE MOBILE MENU
    // =============================================================

    function closeMobileMenu(header) {

        const menuButton = header.querySelector(
            "[data-menu-button]"
        );

        const mobileMenu = header.querySelector(
            "[data-mobile-menu]"
        );

        if (!menuButton || !mobileMenu) {
            return;
        }

        mobileMenu.hidden = true;

        menuButton.setAttribute(
            "aria-expanded",
            "false"
        );

        menuButton.classList.remove(
            "is-open"
        );

        header.classList.remove(
            "nv-header--menu-open"
        );

    }


    // =============================================================
    // CLOSE ALL MEGA MENUS
    // =============================================================

    function closeAllMegaMenus(
        header,
        exceptItem
    ) {

        const items = header.querySelectorAll(
            "[data-mega-menu]"
        );

        items.forEach(function (item) {

            if (item === exceptItem) {
                return;
            }

            item.classList.remove(
                "is-open"
            );

            const trigger = item.querySelector(
                "[data-mega-trigger]"
            );

            if (trigger) {

                trigger.setAttribute(
                    "aria-expanded",
                    "false"
                );

            }

        });

    }


    // =============================================================
    // INITIALIZE
    // =============================================================

    if (document.readyState === "loading") {

        document.addEventListener(
            "DOMContentLoaded",
            initHeader
        );

    } else {

        initHeader();

    }

})();
