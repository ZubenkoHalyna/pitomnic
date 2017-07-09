<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.title" /></title>
</head>
<body>

<a href="<c:url value="/logout" />">
    <spring:message code="label.logout" />
</a>

<p></p>
<a href="?lang=en">en</a>|
<a href="?lang=ru">ru</a>
<p></p>

<h2><spring:message code="label.postNews" /></h2>

<form:form method="post" action="../add/news" commandName="news">

    <table>
        <tr>
            <td><form:label path="title">
                <spring:message code="label.title" />
            </form:label></td>
            <td><form:input path="title" /></td>
        </tr>
        <tr>
            <td><form:label path="description">
                <spring:message code="label.description" />
            </form:label></td>
            <td><form:input path="description" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="<spring:message code="label.postNews"/>" /></td>
        </tr>
    </table>
</form:form>
</html>