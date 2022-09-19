<%@ page import="com.liaobei.util.DateUtil" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh,en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <title>服务器启动页面</title>
</head>
<body>
    服务器已启动，时间：<%=DateUtil.DateFormat(new Date())%>
</body>
</html>
