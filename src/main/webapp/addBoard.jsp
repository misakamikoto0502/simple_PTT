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
    <title>看板名</title>
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
<form action="/ptt-demo/addBoardServlet" method="post">
    <label for="boardName">看板名：</label>
    <input type="text" id="boardName" name="boardName" placeholder="輸入看板名..." required>
    <input type="submit" value="新增看板">
</form>
<script>

    document.getElementById("back").onclick = function (){
        // alert(id);
        location.href = "/ptt-demo/selectAllBoardServlet";
    }


</script>
</body>
</html>
