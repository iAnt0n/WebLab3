'use strict';

function addPoint(_x, _y, _r, _result) {
    const graph = document.getElementById('graph');
    let x = Number(_x);
    let y = Number(_y);
    let r = Number(_r);
    let result = Boolean(_result);
    let dot = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    dot.setAttribute("r", "3");
    dot.setAttribute("cx", String(200 + x * 180/r));
    dot.setAttribute("cy", String(200 - y * 180/r));
    dot.setAttribute("data-x", String(x));
    dot.setAttribute("data-y", String(y));
    dot.setAttribute("class", "target-dot");
    dot.setAttribute("fill", "black");
    graph.appendChild(dot);
}


