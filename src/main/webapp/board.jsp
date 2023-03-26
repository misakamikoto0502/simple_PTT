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
<img src="img/congratulations.jpg" id="congratulations" style="display: none;">
<input type="button" id="logout" value="登出" style="display: none;" >

<c:if test="${isAdmin==1}">
<input type="button" value="新增" id="add"><br>
</c:if>
<h2> ${add_board_msg}</h2>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>看板編號</th>
        <th>看板名稱</th>


    </tr>


    <c:forEach items="${boards}" var="board" varStatus="status">
        <tr align="center">
                <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td><a href="/ptt-demo/selectArticleByBidServlet?id=${board.id}">${board.boardName}</a></td>


<%--            <td><a href="/brand-demo/selectByIdServlet?id=${board.id}">修改</a> <a href="/brand-demo/deleteByIdServlet?id=${board.id}">删除</a></td>--%>
        </tr>

    </c:forEach>

</table>

<script>
    var button = document.getElementById("logout");
    var img = document.getElementById("congratulations");
    var targetString = ["a","r","a","w","a","r","e"];
    var inputString = [];
    document.addEventListener("keydown", function(event) {
        // 將輸入的字符添加到inputString陣列中
        if (event.key === "a" || event.key === "r" || event.key === "w" || event.key === "e") {
            inputString.push(event.key);
            console.log(event.key);


            // 檢查inputString陣列中的字符是否與targetString陣列匹配
            for (var i = 0; i < inputString.length; i++) {
                if (inputString[i] !== targetString[i]) {
                    // 字符不匹配，清空inputString陣列
                    inputString = [];
                    break;
                }
            }

            // 如果inputString陣列與targetString陣列匹配，則顯示按鈕
            if (inputString.length === targetString.length) {
                button.style.display = "";
                img.style.display="";
            }
        }
    });
    document.getElementById("logout").onclick = function (){
        location.href = "/ptt-demo/logoutServlet";
    }
    document.getElementById("add").onclick = function (){
        location.href = "/ptt-demo/addBoard.jsp";
    }


</script>
</body>
</html>