$(document).ready(function () {
    $('#register').validate({
        rules: {
            password: {
                required: true
            },
            passwordAgain: {
                required: true,
                equalTo: "#password"
            }
        }
    });
});
