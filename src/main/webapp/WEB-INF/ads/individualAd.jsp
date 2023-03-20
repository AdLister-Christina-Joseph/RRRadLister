<%--
  Created by IntelliJ IDEA.
  User: cantonuccio
  Date: 3/17/23
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="col-md-6">
    <h2>${ad.title}</h2>
    <p>${ad.description}</p>
</div>

<div class="col-md-6">
    <a href="/user?id=${userID}"><h6>${user.username}</h6></a>

</div>

<%@ include file="/WEB-INF/partials/footer.jsp" %>
</body>
</html>
