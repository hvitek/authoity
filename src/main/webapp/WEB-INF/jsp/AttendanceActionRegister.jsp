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
        <form class="form-horizontal" method="post" action="attendanceActionController">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">Name:</label>
                <div class="col-sm-10">
                    <input class="form-control" id="name" name="name" placeholder="Name">
                </div>
                <label for="isincoming" class="col-sm-2 control-label">Incoming</label>
                <div class="col-sm-10">
                    <input  type="checkbox" class="form-control" id="isincoming" name="isincoming" placeholder="Is outcoming">
                </div>
                <label for="isoutcoming" class="col-sm-2 control-label">Outcoming</label>
                <div class="col-sm-10">
                    <input  type="checkbox" class="form-control" id="isoutcoming" name="isoutcoming" placeholder="Is incoming">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button class="btn btn-default">Create</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
