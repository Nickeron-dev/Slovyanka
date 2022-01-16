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
        slides[i].style.clip = "auto";
    }
    slides[Math.abs(slideIndex)].style.display = "block";
    slides[Math.abs(slideIndex)].style.position = "absolute";
    slides[Math.abs(slideIndex)].style.marginLeft = "0px";
    slides[Math.abs(slideIndex)].style.clip = "rect(0px, 460px, 460px, 0px)";
    let next = Math.abs(slideIndex);
    if (next >= slides.length - 1){
        next = 0;
    }
    else {
        next++;
    }
    slides[next].style.display = "block";
    slides[next].style.position = "absolute";
    slides[next].style.marginLeft = "460px";

    if (next >= slides.length - 1){
        next = 0;
    }
    else {
        next += 1;
    }
    slides[next].style.display = "block";
    slides[next].style.position = "absolute";
    slides[next].style.marginLeft = "920px";

    if (next >= slides.length - 1){
        next = 0;
    }
    else {
        next++;
    }
    slides[next].style.display = "block";
    slides[next].style.position = "absolute";
    slides[next].style.marginLeft = "1380px";
    slides[next].style.clip = "rect(0px, 58px, 400px, -345px)";
}
