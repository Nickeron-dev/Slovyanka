function show_remove_1() {
    let element = document.getElementById("timetable_1");
    remove_2_4();
    remove_5_7_11();
    remove_8_10();
    if (element.style.display === "none") {
        element.style.display = "block";
        document.getElementById("move_1").style.marginTop = "120px";
    } else {
        element.style.display = "none";
        document.getElementById("move_1").style.marginTop = "10px";
    }
}

function show_remove_2_4() {
    let element = document.getElementById("timetable_2_4");
    remove_1();
    remove_5_7_11();
    remove_8_10();
    if (element.style.display === "none") {
        element.style.display = "block";
        document.getElementById("move_2_4").style.marginTop = "140px";
    } else {
        element.style.display = "none";
        document.getElementById("move_2_4").style.marginTop = "10px";
    }
}

function show_remove_5_7_11() {
    let element = document.getElementById("timetable_5_7_11");
    remove_1()
    remove_2_4();
    remove_8_10();
    if (element.style.display === "none") {
        element.style.display = "block";
        document.getElementById("move_5_7_11").style.marginTop = "165px";
    } else {
        element.style.display = "none";
        document.getElementById("move_5_7_11").style.marginTop = "10px";
    }
}

function show_remove_8_10() {
    let element = document.getElementById("timetable_8_10");
    remove_1()
    remove_2_4();
    remove_5_7_11();
    if (element.style.display === "none") {
        element.style.display = "block";
        document.getElementById("move_8_10").style.marginTop = "165px";
    } else {
        element.style.display = "none";
        document.getElementById("move_8_10").style.marginTop = "10px";
    }
}

function remove_1() {
    document.getElementById("timetable_1").style.display = "none";
    document.getElementById("move_1").style.marginTop = "10px";
}

function remove_2_4() {
    document.getElementById("timetable_2_4").style.display = "none";
    document.getElementById("move_2_4").style.marginTop = "10px";
}

function remove_5_7_11() {
    document.getElementById("timetable_5_7_11").style.display = "none";
    document.getElementById("move_5_7_11").style.marginTop = "10px";
}

function remove_8_10() {
    document.getElementById("timetable_8_10").style.display = "none";
    document.getElementById("move_8_10").style.marginTop = "10px";
}
