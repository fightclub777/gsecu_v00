<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2><br>
<a href="<%=request.getContextPath() %>/admin/h">최고관리자</a><br>
<a href="<%=request.getContextPath() %>/admin/m">중간관리자</a><br>
<a href="<%=request.getContextPath() %>/admin/l">실무관리자</a><br>
<a href="<%=request.getContextPath() %>/user/in">사용자IN</a><br>
<a href="<%=request.getContextPath() %>/user/out">사용자OUT</a><br>
<br>
</body>
</html>