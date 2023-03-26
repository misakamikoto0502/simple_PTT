<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>
    ${user.username}   ${isAdmin}歡迎您
</h1>
<input type="button" value="返回" id="back"><br>
<input type="hidden" id="bid" value="${article.bid}">

<c:if test="${user.id==article.uid || isAdmin==1}">
    <input type="button" value="刪除" id="del"><br>
</c:if>
<c:if test="${user.id==article.uid }">
    <input type="button" value="修改" id="update"><br>
</c:if>
<h2>    ${update_article_msg} </h2>
<hr>
<div>
    <p>標題：${article.title}</p>
    <p>作者：${article.author}</p>
    <p>發布時間：${article.datetime}</p><hr>

    <article>
        <p>
            ${article.content}
        </p>
    </article>
</div>
<hr>
<form action="/ptt-demo/addCommentServlet" method="post">
    內容：<textarea id="content" name="content" placeholder="給點回應吧..." required></textarea>
    <input type="submit" value="回應">
    <input type="hidden" name="aid" id="aid" value="${article.id}">
</form>

<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>樓層</th>
        <th>作者</th>
        <th>回應內容</th>
        <th>發布時間</th>


    </tr>


    <c:forEach items="${comments}" var="comment" varStatus="status">
        <tr align="center">

            <td>${status.count}</td>
            <td>${comment.author}</td>
                    <td>${comment.content}</td>
                    <td>${comment.datetime}</td>

        </tr>

    </c:forEach>

</table>

<script>
    let bid=document.getElementById("bid").value
    let aid=document.getElementById("aid").value
    document.getElementById("back").onclick = function (){
        // alert(bid);
        location.href = "/ptt-demo/selectArticleByBidServlet?id="+bid;
    }
    // window.onload = function() {
    //     location.href = "/ptt-demo/selectAllBoardServlet";
    //
    // };
    document.getElementById("del").onclick = function (){
        // alert(bid);
        location.href = "/ptt-demo/deleteArticleServlet?aid="+aid+"&bid="+bid;
    }
    document.getElementById("update").onclick = function (){
        // alert(bid);
        location.href = "/ptt-demo/toUpdateArticleServlet?aid="+aid;
    }
</script>
</body>
</html>