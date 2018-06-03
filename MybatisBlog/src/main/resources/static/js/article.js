$(function () {
    var content = $('#content');
    content.html(marked(content.html()));
});

function checkComment() {
    if (!$('#comment').val().trim().length) {
        alert("评论不能为空！");
    } else {
        {
            location.href = location.pathname + '/comment';
        }
    }
}