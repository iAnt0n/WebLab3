'use strict';

function addPoint(_x, _y, _r, _result) {
    const graph = document.getElementById('graph');
    let x = Number(_x);
    let y = Number(_y);
    let r = Number(_r);
    let color = _result==='true' ? "green" : "red";
    let dot = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    dot.setAttribute("r", "3");
    dot.setAttribute("cx", String(200 + x * 180/r));
    dot.setAttribute("cy", String(200 - y * 180/r));
    dot.setAttribute("data-x", String(x));
    dot.setAttribute("data-y", String(y));
    dot.setAttribute("class", "target-dot");
    dot.setAttribute("fill", color);
    graph.appendChild(dot);
}

function updatePoints(r) {
    document.querySelectorAll('.target-dot').forEach(function (elem) {
        const r = document.getElementById('form:r-input').value;
        const rescX = 200 + elem.getAttribute('data-x') * 180 / r;
        const rescY = 200 - elem.getAttribute('data-y') * 180 / r;
        elem.setAttributeNS("", 'cx', String(rescX)); //rescaling
        elem.setAttributeNS("", 'cy', String(rescY));
    });
}

