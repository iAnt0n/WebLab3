'use strict';
document.getElementById('graph').addEventListener('click', function (e) {
    let r = document.getElementById('form:r-input').value;
    if (!r) {
        return;
    }
    let svg = document.getElementById('graph');
    let htmlCoordinatesPoint = svg.createSVGPoint();
    htmlCoordinatesPoint.x = e.clientX;
    htmlCoordinatesPoint.y = e.clientY;
    let svgPoint = htmlCoordinatesPoint.matrixTransform(svg.getScreenCTM().inverse());
    let calcX = r*(svgPoint.x - 200) / 180; //svg coordinates to point coordinates
    let calcY = r*(svgPoint.y-200) / -180;
    document.getElementById('svg-form:svg-y-input').value = String(calcY);
    document.getElementById('svg-form:svg-x-input').value = String(calcX);
    document.getElementById('svg-form:svg-r-input').value = r;
    document.getElementById('svg-form:svg-btn').click();
});