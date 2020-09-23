'use strict';
setInterval(updateDateTime, 12*1000);
updateDateTime();

function updateDateTime() {
    let timeText = document.getElementById("time").innerText = getCurrentTime();
    let dateText = document.getElementById("date").innerText = getCurrentDate();
}

function getCurrentTime() {
    let date = new Date();
    let hours = addLeadingZeros(date.getHours(), 2);
    let minutes = addLeadingZeros(date.getMinutes(),2);
    let seconds = addLeadingZeros(date.getSeconds(), 2);
    return hours+":"+minutes+":"+seconds;
}

function getCurrentDate() {
    let date = new Date();
    let year = date.getFullYear();
    let month = addLeadingZeros(date.getMonth()+1, 2);
    let day = addLeadingZeros(date.getDate(), 2);
    return day+"."+month+"."+year;
}

function addLeadingZeros(n, outputLength) {
    let res = ''+n;
    while (res.length < outputLength) res = "0"+res;
    return res;
}