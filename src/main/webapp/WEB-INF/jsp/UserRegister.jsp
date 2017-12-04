<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
        <form:form  modelAttribute="register-form" action="users" method="post" >
            <div class="form-group">
                <label for="firstName" class="col-sm-2 control-label">First Name:</label>
                <div class="col-sm-10">
                    <input class="form-control" id="firstName" name="firstName" placeholder="Jméno">
                </div>
            </div>
            <div class="form-group">
                <label for="lastName" class="col-sm-2 control-label">Last name:</label>
                <div class="col-sm-10">
                    <input class="form-control" id="lastName" name="lastName" placeholder="Příjmení">
                </div>
            </div>
            <div class="form-group">
                <label for="nickName" class="col-sm-2 control-label">Nickname:</label>
                <div class="col-sm-10">
                    <input class="form-control" id="nickName" name="nickName" placeholder="Nickname">
                </div>
            </div>
            
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">Password:</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                </div>
            </div>

            <div class="form-group">
                <label for="rightgroup" class="col-sm-2 control-label">Rights Group:</label>
                <div class="col-sm-10">
                    <form:select path="rightgroup" cssClass="form-control">
                        <form:option value="0" label="--- Select ---"/>
                        <form:options items="${rightsgroup}" />
                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>

                            <input type="checkbox" id="isActive" name="isActive"> Aktivní
                        </label>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button class="btn btn-default">Register</button>
                </div>
            </div>
        </form:form>
    </div>

    <div class="form-group">
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

            <c:forEach items="${users}" var="user">
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
