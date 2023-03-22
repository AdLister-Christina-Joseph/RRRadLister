<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="User's Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1></h1>
</div>
<div class="card mx-auto bg-dark">
    <div class="card-header">
        <h2>Welcome to ${user.username}'s page!</h2>
        <h3>All of ${user.username}'s ads:</h3>
    </div>
    <ul class="list-group list-group-flush bg-dark">

        <c:forEach var="adsByUser" items="${adsByUser}">
            <li class="list-group-item bg-dark">
                <a href="/individualAd?id=${adsByUser.id}"><h6><i class="fa-solid fa-recycle"></i> ${adsByUser.title}
                </h6></a>
            </li>
        </c:forEach>
    </ul>
</div>
<%@ include file="/WEB-INF/partials/footer.jsp" %>
</body>
</html>