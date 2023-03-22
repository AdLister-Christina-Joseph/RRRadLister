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
    <br>
    <div class="card mx-auto">
        <div class="card-body bg-dark">
            <h2 class="card-title">${user.username}, are you sure you would like to remove this ad?</h2>
            <br>
            <h4 class="card-title">${ad.title}</h4>
            <h6 class="card-text">${ad.description}</h6>
            <br>
            <p class="card-link" style="text-align:right;">
            <div class="d-flex flex-row">
                <a href="/profile">
                    <button type="button" class="btn btn-secondary" style="margin: 10px">Cancel</button>
                </a>
                <form action="/delete?id=${ad.id}" method="POST"><input type="submit" class="btn btn-success" value="Delete" style="margin: 10px"></form>
            </div>
            </p>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/partials/footer.jsp" %>

</body>
</html>