<%--
  Created by IntelliJ IDEA.
  User: s9538
  Date: 2023/3/15
  Time: 下午 05:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>修改文章</title>
    <style>
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 50px;
        }
        input[type=text], textarea {
            width: 80%;
            padding: 12px 20px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 2px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }
        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type=submit]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<input type="button" value="返回" id="back"><br>

<form action="/ptt-demo/updateArticleServlet" method="post">
    <label for="title">標題：</label>
    <input type="text" id="title" name="title" value="${title}" required>
    <label for="content">內容：</label>
    <textarea id="content" name="content" placeholder="輸入文章內容..." required>${content}</textarea>
    <input type="hidden" name="aid" id="aid" value="${aid}">
    <input type="submit" value="更新文章">
</form>
<script>
    var aid=document.getElementById("aid").value;
    document.getElementById("back").onclick = function (){
         // alert(id);
        location.href = "/ptt-demo/showArticleServlet?id="+aid;
    }
    // window.onload = function() {
    //     location.href = "/ptt-demo/selectAllBoardServlet";
    //
    // };

</script>
</body>
</html>
