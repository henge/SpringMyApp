<!DOCTYPE html>

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
      <input type="submit">
    </form:form>
  </body>
</html>
