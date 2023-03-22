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
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body>
<<<<<<< HEAD
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<br>
=======
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

>>>>>>> 5d7526398ffa097bc9c30d3f719982edcea48596
<div class="card mx-auto">
    <div class="card-body bg-dark">
        <h4 class="card-title">${ad.title}</h4>
        <h6 class="card-text">${ad.description}</h6>
        <br>
        <p class="card-link" style="text-align:left;" style="font-size: 5px;">Post by user: <a
                href="/user?id=${ad.userId}" class="card-link" style="color:white;">${username}</a></p>
    </div>
</div>

<%@ include file="/WEB-INF/partials/footer.jsp" %>
</body>
</html>
