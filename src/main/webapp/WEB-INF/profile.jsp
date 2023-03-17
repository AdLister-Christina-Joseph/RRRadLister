<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>

    <div class="container">
        <h1>Here are all your ads:</h1>

        <c:forEach var="adsByUser" items="${adsByUser}">
            <div class="col-md-6">
                <h2>${adsByUser.title}</h2>
                <p>${adsByUser.description}</p>
            </div>
        </c:forEach>
    </div>

    <%@ include file="/WEB-INF/partials/footer.jsp" %>
</body>
</html>
