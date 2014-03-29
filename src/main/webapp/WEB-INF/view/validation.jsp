<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<html lang="ja">
<head>
<meta charset="UTF-8" />
<title>Validation</title>
</head>
<body>
  <h2>バリデーションのサンプル</h2>
  <table>
    <form:form modelAttribute="vModel">
      <tr>
      	<td></td>
      	<td><form:errors path="*" element="div" /></td>
      </tr>
      <tr>
        <td><form:label path="item">商品名</form:label></td>
        <td><form:input path="item" size="20" /></td>
      </tr>
      <tr>
        <td><form:label path="price">金額</form:label></td>
        <td><form:input path="price" size="20" /></td>
      </tr>
      <tr>
        <td><form:label path="memo">メモ</form:label></td>
        <td><form:input path="memo" size="20" /></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" /></td>
      </tr>
    </form:form>
  </table>
  
  <c:if test="${buylist != null}">
    <table border="1">
      <tr>
        <th>商品名</th>
        <th>価格</th>
      </tr>
      <c:forEach var="obj" items="${buylist}" varStatus="status">
        <tr>
          <td>${obj.item}</td>
          <td>${obj.price}</td>
        </tr>
      </c:forEach>
    </table>
  </c:if>
</body>
</html>