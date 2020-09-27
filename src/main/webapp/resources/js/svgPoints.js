'use strict';

function addPoint(_x, _y, _r, _result) {
    const graph = document.getElementById('graph');
    let x = Number(_x);
    let y = Number(_y);
    let r = Number(_r);
    let color;
    if (typeof _result === "boolean") {
        color = _result ? "green" : "red";
    }
    else color = _result==='true' ? "green" : "red";
    let dot = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    dot.setAttribute("r", "3");
    dot.setAttribute("cx", String(200 + x * 180/r));
    dot.setAttribute("cy", String(200 - y * 180/r));
    dot.setAttribute("data-r", String(r));
    dot.setAttribute("class", "target-dot");
    dot.setAttribute("fill", color);
    if (+r===+document.getElementById('form:r-input').value) {
        dot.setAttribute("style", "visibility: visible");
    }
    else dot.setAttribute("style", "visibility: hidden");
    graph.appendChild(dot);
}

function updatePoints(r) {
    document.querySelectorAll('.target-dot').forEach(function (elem) {
        if (+elem.getAttribute("data-r")===+r) {
            elem.setAttribute("style", "visibility: visible");
        }
        else elem.setAttribute("style", "visibility: hidden");
    });
}

