'use strict';
window.onload = function () {
    document.getElementById('table_data').childNodes.forEach(row => {
        let cells = row.childNodes;
        addPoint(cells[0].innerText, cells[1].innerText, cells[2].innerText, cells[4].innerText);
    });
};
