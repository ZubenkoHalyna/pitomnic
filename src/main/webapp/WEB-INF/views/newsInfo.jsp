<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>${news.title}</title>
    <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon" />
    <link href="<c:url value="/resources/css/fullScreen.css" />" rel="stylesheet">
</head>
<body>
<section>
    <section:before></section:before>
    <div class="maindiv">
        <a href="<c:url value="/news" />">
            <spring:message code="label.news" />
        </a>|
        <sec:authorize access="isAuthenticated()">
            <a href="<c:url value="/logout" />">
                <spring:message code="label.logout" />
            </a>
        </sec:authorize>
        <sec:authorize access="isAnonymous()">
            <a href="<c:url value="/login" />">
                <spring:message code="label.login" />
            </a>
        </sec:authorize>
        <p></p>
        <a href="?lang=en">en</a>|
        <a href="?lang=ru">ru</a>
        <p></p>

        <h2>${news.title}</h2>
            ${news.description}</td>
        <p>
        <c:if test="${!empty photoIdList}">

                <c:forEach items="${photoIdList}" var="photoid">

                        <div style="padding: 2px; float: left; width: 100px;"><img src="../../photo/${photoid}/getPhoto" width="100"/></div>

                </c:forEach>

        </c:if>

    </div>
</section>
</body>
</html>