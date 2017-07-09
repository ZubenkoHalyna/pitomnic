<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>${news.title}</title>
</head>
<body>

<a href="<c:url value="/logout" />">
    <spring:message code="label.logout" />
</a>

<p></p>
<a href="?lang=en">en</a>|
<a href="?lang=ru">ru</a>
<p></p>

<h2>${news.title}</h2>
    ${news.description}</td>

<c:if test="${!empty photoIdList}">
    <table>

        <c:forEach items="${photoIdList}" var="photoid">
            <tr>
                <td><img src="../../photo/${photoid}/getPhoto" height="10%" width="10%"/></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>