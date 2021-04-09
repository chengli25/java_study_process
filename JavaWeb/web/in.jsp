<%--
  Created by IntelliJ IDEA.
  User: 86173
  Date: 2021/3/14
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>九九乘法表</h1>
    <%! String printMultiTable() {
        String s = "";
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= i; j++){
                s += i + "*" + j + "=" + (i*j) + "&nbsp;&nbsp;&nbsp;&nbsp;";
            }
            s += "<br>";    //追加换行标签
        }
        return s;

    }
    void printMultiTable1(JspWriter out) throws Exception{
        for(int i = 1; i<=9; i++) {
            for(int j = 1; j <= i; j++){
                out.println(i + "*" + j + "=" + (i*j) + "&nbsp;&nbsp;&nbsp;&nbsp;");
            }
            out.println("<br>");    //追加换行标签
        }
    }

    %>

    <%=printMultiTable()%>
    <br>
    <% printMultiTable1(out); %>

</body>
</html>
