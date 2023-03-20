<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="User's Profile" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Welcome to ${user.username}'s page!</h1>
</div>

<div class="container">
    <h3>Here are all of ${user.username}'s ads:</h3>

    <c:forEach var="adsByUser" items="${adsByUser}">
        <div class="col-md-6">
            <h4>${adsByUser.title}</h4>
            <p>${adsByUser.description}</p>
        </div>
    </c:forEach>
</div>

<%@ include file="/WEB-INF/partials/footer.jsp" %>
</body>
</html>