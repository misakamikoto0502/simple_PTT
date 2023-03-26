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
    <title>發布文章</title>
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

<form action="/ptt-demo/addArticleServlet" method="post">
    <label for="title">標題：</label>
    <input type="text" id="title" name="title" placeholder="輸入文章標題..." required>
    <label for="content">內容：</label>
    <textarea id="content" name="content" placeholder="輸入文章內容..." required></textarea>
    <input type="submit" value="發布文章">
</form>
<script>
    var url = location.href;

    //再來用去尋找網址列中是否有資料傳遞(QueryString)
    if(url.indexOf('?')!=-1)
    {
        //之後去分割字串把分割後的字串放進陣列中
        var ary1 = url.split('?');
        //此時ary1裡的內容為：
        //ary1[0] = 'index.aspx'，ary2[1] = 'id=U001&name=GQSM'

        //下一步把後方傳遞的每組資料各自分割
        var ary2 = ary1[1].split('=');
        //此時ary2裡的內容為：
        //ary2[0] = 'id=U001'，ary2[1] = 'name=GQSM'

        var bid = ary2[1];

    }
    document.getElementById("back").onclick = function (){
         // alert(id);
        location.href = "/ptt-demo/selectArticleByBidServlet?id="+bid;
    }
    // window.onload = function() {
    //     location.href = "/ptt-demo/selectAllBoardServlet";
    //
    // };

</script>
</body>
</html>
