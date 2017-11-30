<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <link rel="stylesheet" type="text/css"
          href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>

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
                <th>RightsGroup</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Nickname</th>
                <th>Active</th>
            </tr>
            </thead>

            <c:forEach items="${UserList}" var="user">
                <tr>
                    <td><c:out value="${user.getId()}"/></td>
                    <td><c:out value="${user.getRightsGroup()}"/></td>
                    <td><c:out value="${user.getFirstname()}"/></td>
                    <td><c:out value="${user.getLastname()}"/></td>
                    <td><c:out value="${user.getNickname()}"/></td>
                    <td><c:out value="${user.getIsactive()}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
