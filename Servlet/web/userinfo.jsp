<%--
  Created by IntelliJ IDEA.
  User: 86173
  Date: 2021/3/14
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
    <jsp:useBean id="reguser" class="com.users.User" scope="session"/>
    <table width="600" cellpadding="0" cellspacing="0" border="1">
        <tr>
            <td class="title">用户名：</td>
            <td class="content">&nbsp;<jsp:getProperty name="reguser" property="username"/>
<%--            当获取的property是个数组的时候，需要用reguser.getFavorites();方法来获取这个数组，然后遍历数组，out.println(每个字符串);--%>
            </td>
        </tr><tr>
            <td class="title">密码：</td>
            <td class="content">&nbsp;<jsp:getProperty name="reguser" property="password"/></td>
        </tr><tr>
            <td class="title">邮箱：</td>
            <td class="content">&nbsp;<jsp:getProperty name="reguser" property="email"/></td>
        </tr>

    </table>
</body>
</html>
