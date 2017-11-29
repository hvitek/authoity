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
            	<th width="50">Id</th>
                <th>Name</th>
                <th>Rights</th>
            </tr>
            </thead>

			
            <c:forEach items="${RightsGroupList}" var="rightsgroup">
                <tr>
                	<td><c:out value="${rightsgroup.getId()}"/></td>
                    <td><c:out value="${rightsgroup.getName()}"/></td>
                    <td><c:out value="${rightsgroup.getRightsAsString()}"/></td>
                </tr>
            </c:forEach>
            
            </tbody>
        </table>
        
        <select >		
              
			            <c:forEach items="${RightsGroupList}" var="rightsgroup">
			            
			                <option value="${rightsgroup.getId()}">${rightsgroup.getName()}</option>  
			            </c:forEach>
					</select>
    </div>
</div>

</body>
</html>
