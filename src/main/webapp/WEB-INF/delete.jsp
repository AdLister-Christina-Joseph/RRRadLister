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

    <div class="col-md-6">
      <h3>${user.username}, are you sure you would like to remove this ad?</h3>

      <h4>${ad.title}</h4>
      <p>${ad.description}</p>
    </div>

    <a href="/profile"><button type="button" class="btn btn-secondary">Cancel</button></a> <form action="/delete?id=${ad.id}" method="POST">
        <input type="submit" class="btn btn-success" value="Delete">
    </form>




</div>

<%@ include file="/WEB-INF/partials/footer.jsp" %>
<input type="hidden" name="from" value="${param.from}">
</body>
</html>