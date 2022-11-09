function removeAndAddClass() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const type = urlParams.get('type');

    if (type !== null) {
        if (type === "process" || type === "process2") {
            if (type === "process") {
                processOrder();
            } else if (type === "process2") {
                processOrder2();
            }
        }
        if (type === "status" || type === "status2") {
            if (type === "status") {
                orderStatus();
            } else if (type === "status2") {
                orderStatus3();
            }
        }
    }
    cleanUri();
}

function cleanUri() {
    var uri = window.location.toString();
    if (uri.indexOf("?") > 0) {
        var clean = uri.substring(0, uri.indexOf("?"));
        window.history.replaceState({}, document.title, clean);
    }
}

function allOrder() {
    removeActiveAndShow();

    var allorder = document.getElementById('all-order');
    allorder.classList.add('active');

    var allOrderTab = document.getElementById('allorder-tab');
    allOrderTab.classList.add('active');

    var allOrderTabPane = document.getElementById('allorder-tab-pane');
    allOrderTabPane.classList.add('show');
    allOrderTabPane.classList.add('active');
}

function processOrder() {
    removeActiveAndShow();

    var processOrder = document.getElementById('process-order');
    processOrder.classList.add('active');

    var waitConfirmTab = document.getElementById('wait-confirm-tab');
    waitConfirmTab.classList.add('active');

    var waitConfirmTabPane = document.getElementById('wait-confirm-tab-pane');
    waitConfirmTabPane.classList.add('show');
    waitConfirmTabPane.classList.add('active');
}

function processOrder2() {
    removeActiveAndShow();

    var processOrder = document.getElementById('process-order');
    processOrder.classList.add('active');

    var waitConfirmTab = document.getElementById('wait-delivery-tab');
    waitConfirmTab.classList.add('active');

    var waitConfirmTabPane = document.getElementById('wait-delivery-tab-pane');
    waitConfirmTabPane.classList.add('show');
    waitConfirmTabPane.classList.add('active');
}

function orderStatus() {
    removeActiveAndShow();

    var orderStatus = document.getElementById('order-status');
    orderStatus.classList.add('active');

    var waitConfirmTab = document.getElementById('on-delivery-tab');
    waitConfirmTab.classList.add('active');

    var waitConfirmTabPane = document.getElementById('on-delivery-tab-pane');
    waitConfirmTabPane.classList.add('show');
    waitConfirmTabPane.classList.add('active');
}

function orderStatus2() {
    removeActiveAndShow();

    var orderStatus = document.getElementById('order-status');
    orderStatus.classList.add('active');

    var deliveredTab = document.getElementById('delivered-tab');
    deliveredTab.classList.add('active');

    var deliveredTabPane = document.getElementById('delivered-tab-pane');
    deliveredTabPane.classList.add('show');
    deliveredTabPane.classList.add('active');
}

function orderStatus3() {
    removeActiveAndShow();

    var orderStatus = document.getElementById('order-status');
    orderStatus.classList.add('active');

    var cancelOrder = document.getElementById('cancel-order-tab');
    cancelOrder.classList.add('active');

    var cancelOrderTabPane = document.getElementById('cancel-order-tab-pane');
    cancelOrderTabPane.classList.add('show');
    cancelOrderTabPane.classList.add('active');
}

function hasClass(element, className) {
    return (' ' + element.className + ' ').indexOf(' ' + className + ' ') > -1;
}

function removeActiveAndShow() {
    var clear = document.getElementsByClassName('txtSearch');
    for (var i = 0; i < clear.length; i++) {
        clear[i].value = '#';
        searchFunc(clear[i].id);
        clear[i].value = '';
    }

    var orderManager = document.getElementsByClassName('order-manager-header');
    for (var i = 0; i < orderManager.length; i++) {
        if (hasClass(orderManager[i], 'active')) {
            orderManager[i].classList.remove('active');
        }
    }

    var orderBtn = document.getElementsByClassName('order-btn');
    for (var i = 0; i < orderBtn.length; i++) {
        if (hasClass(orderBtn[i], 'active')) {
            orderBtn[i].classList.remove('active');
        }
    }

    var tabPane = document.getElementsByClassName('tab-pane');
    for (var i = 0; i < tabPane.length; i++) {
        if (hasClass(tabPane[i], 'show') && hasClass(tabPane[i], 'active')) {
            tabPane[i].classList.remove('show');
            tabPane[i].classList.remove('active');
        }
    }
}

function searchFunc(txtSearch) {
    var input, filter, p, txtValue;
    input = document.getElementById(txtSearch);
    if (input !== null) {
        var clear = document.getElementsByClassName('txtSearch');
        for (var i = 0; i < clear.length; i++) {
            if (clear[i].id !== txtSearch) {
                clear[i].value = '';
            }
            filter = input.value.toUpperCase();
        }
    }
    var content = document.getElementsByClassName('all-order-content');
    for (var i = 0; i < content.length; i++) {
        p = content[i].getElementsByTagName('p')[0];
        txtValue = p.textContent || p.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            content[i].style.display = "";
        } else {
            content[i].style.display = 'none';
        }
    }
}

function removeLabel() {
    var input = document.getElementById('reasonInput');
    var label = document.getElementById('labelRequired');
    if (input.value.length !== 0) {
        label.innerHTML = '';
    } else {
        label.innerHTML = '*';
    }
}

function checkEmptyReason(textbox) {
    if (textbox.value === '') {
        textbox.setCustomValidity
                ('Lí do hủy đơn không được để trống!');
    }
}