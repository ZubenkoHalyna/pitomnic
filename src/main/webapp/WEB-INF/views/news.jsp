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
    <title><spring:message code="label.news" /></title>
    <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon" />
    <link href="<c:url value="/resources/css/fullScreen.css" />" rel="stylesheet">
</head>
<body>
<section>
    <section:before></section:before>
    <div class="maindiv">

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

<h2><spring:message code="label.news" /></h2>

<c:if test="${!empty newsList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.postDate" /></th>
            <th><spring:message code="label.title" /></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${newsList}" var="news">
            <tr>
                <td>${news.postDateStr}</td>
                <td><a href="../info/news/${news.id}">${news.title}</a></td>
                <sec:authorize access="isAuthenticated()">
                    <td><a href="../delete/news/${news.id}"><spring:message code="label.delete" /></a></td>
                    <td><a href="../edit/news/${news.id}"><spring:message code="label.edit" /></a></td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
</c:if>

<sec:authorize access="isAuthenticated()">
    <a href="/add/news"><button type="button"> <spring:message code="label.postNews" /></button></a>
</sec:authorize>


    </div>
</section>
</body>
</html>