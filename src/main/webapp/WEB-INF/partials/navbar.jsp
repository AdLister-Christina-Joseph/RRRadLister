<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:choose>

    <c:when test ="${sessionScope.user.username != null}">

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark text-white text-center">
                <div class="container-fluid text-white">
                    <a class="navbar-brand" href="/ads/index"><i class="fa-solid fa-recycle"></i> RRRadLister</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse text-white" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" href="/profile">Profile</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="/ads/create">Create Listing</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="/ads/index">All Ad Listings</a>
                            </li>
                            <%--<li class="nav-item">
                                <a class="nav-link active" href="/ads/byCat">Ads By Category</a>
                            </li>--%>
                            <li class="nav-item">
                                <a class="nav-link active" href="/logout">Logout</a>
                            </li>


                        </ul>
                        <form class="d-flex justify-content-center align-items-center input-group-sm " role="search" method="post" action="/searchAds">
                            <input class="form-control me-2" type="search" placeholder="Search listings" name="searchAds">
                            <button class="btn btn-outline-light" type="submit" ><i class="fa-solid fa-magnifying-glass"></i></button>
                        </form>
                    </div>
                </div>
            </nav>

    </c:when>

    <c:otherwise>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark text-white text-center">
            <div class="container-fluid text-white">
                <a class="navbar-brand" href="/ads/index"><i class="fa-solid fa-recycle"></i> RRRadLister</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse text-white" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" href="/login">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="/register">Register</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="/ads/index">All Ad Listings</a>
                        </li>
                        <%--<li class="nav-item">
                            <a class="nav-link active" href="/ads/byCat">Ads By Category</a>
                        </li>--%>


                    </ul>
                    <form class="d-flex justify-content-center align-items-center input-group-sm " role="search" method="post" action="/searchAds">
                        <input class="form-control me-2" type="search" placeholder="Search listings" name="searchAds">
                        <button class="btn btn-outline-light" type="submit" ><i class="fa-solid fa-magnifying-glass"></i></button>
                    </form>
                </div>
            </div>
        </nav>

    </c:otherwise>
</c:choose>


