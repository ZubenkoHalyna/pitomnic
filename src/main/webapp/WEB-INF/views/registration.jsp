<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="label.registration" /></title>
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

<p></p><spring:message code="label.registration" />
<p></p>

<form:form method="post" action="/add/user" commandName="registrationForm">
    <table>
        <tr>
            <td><form:label path="login">
                <spring:message code="label.login" />
            </form:label></td>
            <td><form:input path="login" /></td>
            <td><form:errors path="login" /></td>
        </tr>
        <tr>
            <td><form:label path="password">
                <spring:message code="label.password" />
            </form:label></td>
            <td><form:password path="password"  /></td>
            <td><form:errors path="password" /></td>
        </tr>
        <tr>
            <td><form:label path="confirmPassword">
                <spring:message code="label.confirmPassword" />
            </form:label></td>
            <td><form:password cssClass="password-field" path="confirmPassword" /></td>
            <td><form:errors path="confirmPassword" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <p></p>
                <input type="submit" value="<spring:message code="label.registration"/>" />
                <input type="reset" value="<spring:message code="label.reset"/>" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>