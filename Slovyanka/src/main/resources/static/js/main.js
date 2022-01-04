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
    let indexLeft;
    let indexRight;
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
    }
    slides[Math.abs(slideIndex)].style.display = "block";
    slides[Math.abs(slideIndex)].style.float = "left";
    slides[Math.abs(slideIndex)].style.position = "absolute";

    indexLeft = Math.abs(slideIndex) + 1;

    if (n >= slides.length - 1) {
        slideIndex = -1;
    }
    slides[(slideIndex + 1) === slides.length ? 0 : slideIndex + 1].style.display = "block";
    slides[(slideIndex + 1) === slides.length ? 0 : slideIndex + 1].style.float = "right";
    indexRight = (slideIndex + 2);
    document.getElementById("current_slide").innerHTML = "< " + indexLeft + "-" + indexRight + " >  ";
    document.getElementById("total_pages").innerHTML = slides.length.toString();
}
