<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Please Log In" />
  </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
  <h1>Search Results</h1>
  <div class="container-fluid">
<h3>
  Search results:
</h3>
    <div class="container-fluid" id="result-container">

    </div>
  </div>
</div>

<%@ include file="/WEB-INF/partials/footer.jsp" %>
</body>
</html>
