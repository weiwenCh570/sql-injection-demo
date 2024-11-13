document.addEventListener('DOMContentLoaded', () => {
    const burger = document.querySelector('.burger');
    const navLinks = document.querySelector('.nav-links');

    burger.addEventListener('click', () => {
        navLinks.classList.toggle('active');
    });


    //iamges
    const carouselSlide = document.querySelector('.carousel-slide');
    const carouselImages = document.querySelectorAll('.carousel-slide img');
    const prevBtn = document.querySelector('.prev-btn');
    const nextBtn = document.querySelector('.next-btn');
    let counter = 0;
    const size = carouselImages[0].clientWidth;

    nextBtn.addEventListener('click', () => {
        if (counter >= carouselImages.length - 1) return;
        carouselSlide.style.transition = 'transform 0.5s ease-in-out';
        counter++;
        carouselSlide.style.transform = 'translateX(' + (-size * counter) + 'px)';
        updateReferences();
    });

    prevBtn.addEventListener('click', () => {
        if (counter <= 0) return;
        carouselSlide.style.transition = 'transform 0.5s ease-in-out';
        counter--;
        carouselSlide.style.transform = 'translateX(' + (-size * counter) + 'px)';
        updateReferences();
    });

    function updateReferences() {
        document.querySelectorAll('.carousel-references p').forEach((caption, index) => {
            caption.style.display = index === counter ? 'block' : 'none';
        });
    }

    updateReferences();



    //click to logout
    // const loginName = document.getElementById('login-name');
    // loginName.addEventListener('click', function(event) {
    //     event.preventDefault();
    //     const dropdownContent = this.nextElementSibling;
    //     dropdownContent.style.display = dropdownContent.style.display === 'block' ? 'none' : 'block';
    // });
    //
    // // Close the dropdown if the user clicks outside of it
    // window.onclick = function(event) {
    //     if (!event.target.matches('#login-name')) {
    //         const dropdowns = document.getElementsByClassName("dropdown-content");
    //         for (let i = 0; i < dropdowns.length; i++) {
    //             const openDropdown = dropdowns[i];
    //             if (openDropdown.style.display === 'block') {
    //                 openDropdown.style.display = 'none';
    //             }
    //         }
    //     }
    // }


    // // Click to logout
    // const loginName = document.getElementById('login-name');
    // if (loginName) {
    //     loginName.addEventListener('click', function(event) {
    //         event.preventDefault();
    //         const dropdownContent = this.nextElementSibling;
    //         if (dropdownContent) {
    //             dropdownContent.style.display = dropdownContent.style.display === 'block' ? 'none' : 'block';
    //         }
    //     });
    // }
    //
    // // Close the dropdown if the user clicks outside of it
    // window.onclick = function(event) {
    //     if (!event.target.matches('#login-name')) {
    //         const dropdowns = document.getElementsByClassName("dropdown-content");
    //         for (let i = 0; i < dropdowns.length; i++) {
    //             const openDropdown = dropdowns[i];
    //             if (openDropdown.style.display === 'block') {
    //                 openDropdown.style.display = 'none';
    //             }
    //         }
    //     }
    // }



});
