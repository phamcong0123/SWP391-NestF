/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function checkSimilar() {
    var password = $('#password').val();
    console.log(password);
    var confirm = $('#confirm');
    console.log($(confirm).val());
    var submitButton = $(confirm).closest('form').find('input[name=submitButton]');
    if (password != confirm.val()) {
        $(submitButton).prop('disabled', true);
        $('#similar-tooltip').css('display', 'inline-block');
    } else {
        $(submitButton).prop('disabled', false);
        $('#similar-tooltip').css('display', 'none');
    }
}

function checkLength(e) {
    var text = e.value;
    if (text.length >= e.maxLength) {
        e.value = text.slice(0, e.maxLength);
        $('#error-tooltip').css('display', 'none');
    } else {
        if ($('#error-tooltip').attr("aria-label") == "Số điện thoại phải dài 10 chữ số") {
            $('#error-tooltip').css('display', 'inline-block');
        }
    }
}
