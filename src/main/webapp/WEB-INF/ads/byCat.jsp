<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Viewing All The Ads" />
  </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
  <h1>Choose your category!</h1>

  <div class="col-md-6">

    <a href="/categories"><h2>Help Wanted</h2></a>
    <a href="/categories"><h2>FREE</h2></a>
    <a href="/categories"><h2>Furniture</h2></a>
    <a href="/categories"><h2>Appliances</h2></a>
    <a href="/categories"><h2>Cars</h2></a>
    <a href="/categories"><h2>Bikes</h2></a>
    <a href="/categories"><h2>Books</h2></a>
    <a href="/categories"><h2>Electronics</h2></a>
    <a href="/categories"><h2>Household</h2></a>
    <a href="/categories"><h2>Jewelery</h2></a>
    <a href="/categories"><h2>Camping</h2></a>
    <a href="/categories"><h2>Tools</h2></a>
    <a href="/categories"><h2>General/Misc</h2></a>

  </div>

</div>

<%@ include file="/WEB-INF/partials/footer.jsp" %>
</body>
</html>