let slideIndex = 0;
showSlides(slideIndex);

function plusSlides(n) {
    slideIndex += n;
    const slides = document.getElementsByClassName("public-info__slides");
    if (slideIndex === -1) {
        slideIndex = slides.length - 1;
    }
    if (slideIndex < -1) {
        slideIndex = slides.length + slideIndex;
    }
    showSlides(slideIndex);
}

function showSlides(n) {
    const slides = document.getElementsByClassName("public-info__slides");

    if (n > slides.length - 1) {
        slideIndex = 0;
    }
    if (n < 0) {
        slideIndex = slides.length - 1;
    }
    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
        slides[i].style.position = "relative";
        slides[i].style.marginLeft = "0px";
        slides[i].style.clip = "rect(auto)";
    }
    slides[Math.abs(slideIndex)].style.display = "block";
    // slides[Math.abs(slideIndex)].style.float = "left";
    slides[Math.abs(slideIndex)].style.position = "absolute";
    slides[Math.abs(slideIndex)].style.marginLeft = "0px";
    slides[Math.abs(slideIndex)].style.clip = "rect(0px, 460px, 460px, 0px)";
    let next = Math.abs(slideIndex + 1) >= slides.length ? 0 : Math.abs(slideIndex + 1);
    slides[next].style.display = "block";
    slides[next].style.position = "absolute";
    slides[next].style.marginLeft = "460px";

    let next2 = Math.abs(slideIndex + 2) >= slides.length ? 1 : Math.abs(slideIndex + 2);
    slides[next2].style.display = "block";
    slides[next2].style.position = "absolute";
    slides[next2].style.marginLeft = "920px";
    let next3 = Math.abs(slideIndex + 3) >= slides.length ? 2 : Math.abs(slideIndex + 3);
    slides[next3].style.display = "block";
    slides[next3].style.position = "absolute";
    slides[next3].style.marginLeft = "1380px";
    slides[next3].style.clip = "rect(0px, 58px, 400px, -345px)";

    if (n >= slides.length - 1) {
        slideIndex = -1;
    }
    slides[(slideIndex + 1) === slides.length ? 0 : slideIndex + 1].style.display = "block";
    slides[(slideIndex + 1) === slides.length ? 0 : slideIndex + 1].style.float = "right";
}
