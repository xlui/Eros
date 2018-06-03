$(function () {
    $('.content').each(function () {
        $(this).html(marked($(this).html()));
    });
});