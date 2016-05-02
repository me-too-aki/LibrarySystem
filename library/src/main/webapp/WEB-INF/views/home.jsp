<%-- home画面。ここに本一覧を表示する。 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<%@ page language="java" import="java.lang.*, java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>書籍一覧</title>
</head>
<body>
	<h1>貸出図書一覧</h1>
	<%-- 貸出図書一覧を表示する。 --%>
	<table border="1">
		<tr>
			<td>No.</td>
			<td>タイトル</td>
			<td>状態</td>
			<td>貸出日</td>
			<td>返却予定日</td>
			<td>借入者</td>
			<td></td>
			<td></td>
		</tr>
		<%-- HomeControllerより、booksのlistを受け取り、それぞれタイトルを表示する。 --%>
		<c:forEach var="list" items="${books}">
			<tr>
			    <%-- BooksJoinLendingsAndUsersクラスの、getterメソッドがそれぞれ実行される。 --%>
				<td><c:out value="${list.bookId}" /></td>
				<td><c:out value="${list.bookTitle}" /></td>
				<td>
					<%-- 貸出状況テーブルに対し、プロパティより対応するキーの値を取得して表示する。 --%>
					<fmt:setBundle basename="code" var="sts" />
					<fmt:message bundle="${sts}" key="lendingStatus.${list.lendingStatus}" />
				</td>
				<td><c:out value="${list.lendedAt}" /></td>
				<td><c:out value="${list.dueDate}" /></td>
				<td><c:out value="${list.userName}" /></td>
				<%-- 本の詳細画面と、貸出画面へのリンク。 --%>
				<td><a href="">詳細</a></td>
				<td><a href="">貸出</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>