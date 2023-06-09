<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<br>
<div class="container w-50">
    <h1>Please Log In</h1>
    <form action="/login" method="POST">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text" value="Tiggg">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" type="password" value="1234">
        </div>
        <input type="submit" class="btn btn-success btn-block mt-2" value="Log In"> <a href="/register"
                                                                                       style="color:white;">
        Create an Account</a>
    </form>
    <div class="container" <%=session.getAttribute("loginError")%>>

        <div class="alert alert-danger w-100" role="alert">
            Username or password is incorrect.
        </div>
    </div>
    <%@ include file="/WEB-INF/partials/footer.jsp" %>
</body>
</html>
