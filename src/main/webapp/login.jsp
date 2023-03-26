<%--
  Created by IntelliJ IDEA.
  User: s9538
  Date: 2023/3/11
  Time: 下午 03:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <style>
        body {
            background-color: #f2f2f2;
        }

        form {
            background-color: #ffffff;
            padding: 20px;
            width: 300px;
            margin: 50px auto;
            border-radius: 5px;
            box-shadow: 0px 0px 10px #888888;
            text-align: center;
        }

        h2 {
            margin-top: 0px;
        }

        label {
            display: inline-block;
            width: 80px;
            text-align: right;
            margin-right: 20px;
        }

        input[type="text"], input[type="password"] {
            padding: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-bottom: 20px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .register-link {
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>

<body>
<form action="/ptt-demo/userLoginServlet" method="post">
    <h2>登入</h2>
    <div id="errorMsg">${login_msg}${register_msg}${not_login_msg}</div>
    <label for="username">帳號:</label>
    <input type="text" id="username" name="username"  ><br><br>
    <label for="password">密碼:</label>
    <input type="password" id="password" name="password" ><br><br>
    <input type="submit" value="登入"  >
</form>
<div class="register-link">
    還沒有帳號嗎？<a href="register.jsp">註冊</a>
</div>


</body>
</html>