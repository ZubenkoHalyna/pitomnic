<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.news" /></title>
    <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon" />
</head>
<body>

<a href="<c:url value="/logout" />">
    <spring:message code="label.logout" />
</a>

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
                <td><a href="../delete/news/${news.id}"><spring:message code="label.delete" /></a></td>
                <td><a href="../edit/news/${news.id}"><spring:message code="label.edit" /></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<a href="/add/news"><button type="button"> <spring:message code="label.postNews" /></button></a>


</body>
</html>