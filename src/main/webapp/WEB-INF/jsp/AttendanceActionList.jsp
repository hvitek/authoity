<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <link rel="stylesheet" type="text/css"
          href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
    <c:url value="/css/main.css" var="jstlCss"/>
    <link href="${jstlCss}" rel="stylesheet"/>

</head>

<body>
<div class="container">
    <div class="row col-sm-8">
        <table class="table table-condensed">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>IsIncomming</th>
                <th>IsOutcomming</th>
            </tr>
            </thead>

            <c:forEach items="${AttendanceActionList}" var="attendanceAction">
                <tr>
                    <td><c:out value="${attendanceAction.getId()}"/></td>
                    <td><c:out value="${attendanceAction.getName()}"/></td>
                    <td><c:out value="${attendanceAction.getIsincoming()}"/></td>
                    <td><c:out value="${attendanceAction.getIsoutcoming()}"/></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>

</body>
</html>
