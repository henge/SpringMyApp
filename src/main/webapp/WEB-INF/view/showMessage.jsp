<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
  <head>
    <meta charset="utf-8">
    <title>${title}</title>
  </head>
  <body>
    <h1>${title}</h1>
    <p>${message}</p>

    <form:form modelAttribute="formModel">
      <form:input path="input1" />
      <form:checkbox path="check1" label="chackbox 1"/>
      <form:checkboxes path="checks" items="${checkItems}" itemLabel="label" itemValue="data" delimiter=" " />
      <input type="submit">
    </form:form>
    
    <ul>
    <c:forEach items="${checks}" var="item">
      <li>${item}</li>
    </c:forEach>
    </ul>
    
  </body>
</html>
