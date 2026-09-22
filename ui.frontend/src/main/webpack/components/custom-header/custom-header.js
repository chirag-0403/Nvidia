(function () {
    "use strict";

    document.addEventListener("DOMContentLoaded", function () {

        const menuButton = document.querySelector(
            "[data-menu-button]"
        );

        const mobileMenu = document.querySelector(
            "[data-mobile-menu]"
        );

        // Mobile menu
        if (menuButton && mobileMenu) {

            menuButton.addEventListener("click", function () {

                const isOpen = !mobileMenu.hidden;

                mobileMenu.hidden = isOpen;

                menuButton.setAttribute(
                    "aria-expanded",
                    String(!isOpen)
                );

            });

        }

    });

})();
