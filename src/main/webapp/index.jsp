<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

<%--    <div class="card mx-auto" style="width: 85%;">--%>
<%--        <div class="card-header">--%>
            <h1>Welcome to RRRadlister!</h1>
<%--        </div>--%>
<%--        <ul class="list-group list-group-flush">--%>

<%--            <li class="list-group-item">--%>
<%--
                <img src="/imgs/recycle.png" alt="recycle" width="75%" height="75%">
--%>
                <p>Saving the environment one recycled item at a time!</p>
<%--            </li>--%>



        </ul>
    </div>

    <%@ include file="/WEB-INF/partials/footer.jsp" %>
</body>
</html>
