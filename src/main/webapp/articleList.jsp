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
    ${user.username}歡迎您
</h1>
<input type="button" value="新增" id="add"><br>
<input type="button" value="返回" id="back"><br>
<input type="hidden" id="bid" value="${bid}">
<h2>${del_article_msg}${add_article_msg}</h2>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>文章編號</th>
        <th>標題</th>
        <th>作者</th>
        <th>發布時間</th>


    </tr>


    <c:forEach items="${articles}" var="article" varStatus="status">
        <tr align="center">
                <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td><a href="/ptt-demo/showArticleServlet?id=${article.id}">${article.title}</a></td>
                    <td>${article.author}</td>
                    <td>${article.datetime}</td>
<%--                    <input type="hidden" id="bid" value="${article.bid}">--%>

                <%--            <td><a href="/brand-demo/selectByIdServlet?id=${board.id}">修改</a> <a href="/brand-demo/deleteByIdServlet?id=${board.id}">删除</a></td>--%>
        </tr>

    </c:forEach>

</table>

<script>
    let bid=document.getElementById("bid").value
    document.getElementById("add").onclick = function (){

        location.href = "/ptt-demo/addArticle.jsp?id="+bid;
    }
    // window.onload = function() {
    //     location.href = "/ptt-demo/selectAllBoardServlet";
    //
    // };
    document.getElementById("back").onclick = function (){

        location.href = "/ptt-demo/selectAllBoardServlet";
    }

</script>
</body>
</html>