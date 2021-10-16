$("#btnDelete").click(function(){
    let el = $("#updateForm");
    el.attr("method", "post");
    el.attr("action", "/board/deleteBoard");
    el.submit();
})

$("#btnUpdate").click(function(){
    let el = $("#updateForm");
    el.attr("method", "post");
    el.attr("action", "/board/saveBoard");
    el.submit();
})