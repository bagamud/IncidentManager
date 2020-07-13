function zero_first_format(value) {
    if (value < 10) {
        value = '0' + value;
    }
    return value;
}

/* ������� ��������� ������� ���� � ������� */
function date_time() {
    var current_datetime = new Date();
    var day = zero_first_format(current_datetime.getDate());
    var month = zero_first_format(current_datetime.getMonth() + 1);
    var year = current_datetime.getFullYear();
    var hours = zero_first_format(current_datetime.getHours());
    var minutes = zero_first_format(current_datetime.getMinutes());
    var seconds = zero_first_format(current_datetime.getSeconds());

    return day + "." + month + "." + year + " " + hours + ":" + minutes + ":" + seconds;
}

function short_date_time() {
    var current_datetime = new Date();
    var day = zero_first_format(current_datetime.getDate());
    var month = zero_first_format(current_datetime.getMonth() + 1);
    var year = current_datetime.getFullYear();

    return day + "." + month + "." + year;
}

setInterval(function () {
    document.getElementById('current_date_time_block2').innerHTML = date_time();
}, 1000);

/* ������� ������� ���� � ����� �� ���� � ���� � id "current_date_time_block" */
document.getElementById('date').setAttribute('value', short_date_time().toString());


