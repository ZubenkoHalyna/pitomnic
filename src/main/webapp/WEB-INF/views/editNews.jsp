<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.editNews" /></title>
    <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon" />
    <link href="<c:url value="/resources/css/fullScreen.css" />" rel="stylesheet">
</head>
<body>
<section>
    <section:before></section:before>
    <div class="maindiv">
        <a href="<c:url value="/logout" />">
            <spring:message code="label.logout" />
        </a>|
        <a href="<c:url value="/news" />">
            <spring:message code="label.news" />
        </a>

        <p></p>
        <a href="?lang=en">en</a>|
        <a href="?lang=ru">ru</a>
        <p></p>

        <h2><spring:message code="label.editNews" /></h2>

        <form:form method="post" action="../../update/news" commandName="news">

            <table>
                <tr>
                    <td></td>
                    <td><form:hidden path="id" /></td>
                </tr>
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
                    <td><form:input  path="description" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit"
                                           value="<spring:message code="label.editNews"/>" /></td>
                </tr>
            </table>
        </form:form>
        <p></p>
        <form action = "../../add/photo?id=${news.id}" method = "POST" enctype="multipart/form-data">

            <h3><spring:message code="label.attachephoto" /></h3>
            <p></p>
            <input type="file" name="photo"  size="50"/>
            <td colspan = "2"><input type = "submit" value = "<spring:message code="label.attachephoto" />"/></td>
        </form>

        <h3><spring:message code="label.attachedphotos" /></h3>
        <c:if test="${!empty photoIdList}">
            <table>

                <c:forEach items="${photoIdList}" var="photoid">
                    <tr>
                        <td width="100"><img src="../../photo/${photoid}/getPhoto" width="100"/></td>
                        <td><a href="../../delete/photo/${photoid}/${news.id}"><spring:message code="label.delete" /></a></td>
                        <td></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</section>
</body>
</html>