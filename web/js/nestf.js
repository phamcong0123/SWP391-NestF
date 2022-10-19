function incrementValue(e) {
    var max = document.getElementById("number-input").max;
    var fieldName = $(e.target).data('field');
    var parent = $(e.target).closest('div');
    var currentVal = parseInt(parent.find('input[name=' + fieldName + ']').val(), 10);
    var form = $(e.target).closest('form');
    if (!isNaN(currentVal) && currentVal < max) {
        parent.find('input[name=' + fieldName + ']').val(currentVal + 1);
        form.submit();
    }   
}

function decrementValue(e) {
    var fieldName = $(e.target).data('field');
    var parent = $(e.target).closest('div');
    var currentVal = parseInt(parent.find('input[name=' + fieldName + ']').val(), 10);
    var form = $(e.target).closest('form');
    if (!isNaN(currentVal) && currentVal > 1) {
        parent.find('input[name=' + fieldName + ']').val(currentVal - 1);
        form.submit();
    } else {
        parent.find('input[name=' + fieldName + ']').val(1);
    }    
}

$('.input-group').on('click', '.button-plus', function (e) {
    incrementValue(e);   
});

$('.input-group').on('click', '.button-minus', function (e) {
    decrementValue(e);
});

function maxCheck(object) {
    if (object.value > object.max)
        object.value = object.max;
}

function minCheck(object) {
    if (object.value == '' || object.value < object.min)
        object.value = object.min;
}
//function validate(){
//    let password = document.getElementById("password").value;
//    let confirm = document.getElementById("confirm").value;
//    if (password != confirm){
//        let form = document.getElementById("reg-form");
//        form.prevetDefault();
//        alert("ko trung");
//    } else {
//        form.removeEventListener()
//    }
//}
function pickVoucher(param){
    document.getElementById('buy-button').innerHTML = param.value;
    document.getElementById('voucher-use').value = param.firstElementChild.value;
    var newTotal = document.getElementById('total').value - param.lastElementChild.value;
    if (newTotal >0) document.getElementById('total-display').innerHTML = new Intl.NumberFormat('de-DE', { style: 'currency', currency: 'VND' }).format(newTotal);
    else document.getElementById('total-display').innerHTML = new Intl.NumberFormat('de-DE', { style: 'currency', currency: 'VND' }).format(0);
}
function cancelVoucher(){
    var total = document.getElementById('total').value
    document.getElementById('total-display').innerHTML = new Intl.NumberFormat('de-DE', { style: 'currency', currency: 'VND' }).format(total);
    document.getElementById('voucher-use').value = "";
    document.getElementById('voucher-button').firstElementChild.innerHTML = 'Chọn voucher';
}