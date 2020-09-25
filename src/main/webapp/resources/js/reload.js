'use strict';
window.onload = function () {
    document.getElementById('table_data').childNodes.forEach(row => {
        let cells = row.childNodes;
        let r = document.getElementById('form:r-input').value;
        addPoint(cells[0].innerText, cells[1].innerText, r, cells[5].innerText);
    });
};
