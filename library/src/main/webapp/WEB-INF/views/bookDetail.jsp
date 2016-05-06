<%-- ここに貸出図書詳細画面を表示する。 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<%@ page language="java" import="java.lang.*, java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>貸出図書詳細画面</title>
</head>
<body>
	<h1>貸出図書詳細画面</h1>
	<%-- 貸出図書詳細画面を表示する。 --%>
	<table border="1">
		<%-- BookDetailControllerよりlistを受け取り、それぞれ表示する。 --%>
		<c:forEach var="list" items="${booksJoinLendingsAndUsers}">
			<tr>
				<td>タイトル</td>
				<td><c:out value="${list.bookTitle}" /></td>
			</tr>
			<tr>
				<td>著者</td>
				<td><c:out value="${list.writterName}" /></td>
			</tr>
			<tr>
				<td>出版社</td>
				<td><c:out value="${list.publisher}" /></td>
			</tr>
			<tr>
				<td>出版日</td>
				<td><c:out value="${list.publishedAt}" /></td>
			</tr>
			<tr>
				<td>所有者</td>
				<td><c:out value="${list.userName}" /></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<p>貸出履歴</p>
	<table border="1">
		<tr>
			<td>貸出日</td>
			<td>返却日</td>
			<td>借入者</td>
		</tr>
		<%-- BookDetailControllerよりlistを受け取り、それぞれ表示する。 --%>
		<c:forEach var="list" items="${historysJoinUsers}">
			<tr>
				<%-- getterメソッドがそれぞれ実行される。 --%>
				<td><c:out value="${list.lendedAt}" /></td>
				<td><c:out value="${list.returnedAt}" /></td>
				<td><c:out value="${list.userName}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>