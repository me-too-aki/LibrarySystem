<!-- home画面。ここに本一覧を表示する。 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<%@ page language="java" import="java.lang.*, java.util.*"
	contentType="text/html; charset=utf-8"%>

<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>貸出図書一覧</h1>
	<!-- 貸出図書一覧を表示する -->
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
		<!-- HomeControllerより、booksのlistを受け取り、それぞれタイトルを表示する。 -->
		<c:forEach var="list" items="${books}">
			<tr>
				<td><c:out value="${list.book_id}" /></td>
				<td><c:out value="${list.book_title}" /></td>
				<td>
					<!-- 貸出状況テーブルに対し、プロパティより対応するキーの値を取得して表示する。 --> <fmt:setBundle
						basename="application" var="sts" /> <fmt:message bundle="${sts}"
						key="${list.lending_status}" />
				</td>
				<td><c:out value="${list.lended_at}" /></td>
				<td><c:out value="${list.due_date}" /></td>
				<td><c:out value="${list.user_name}" /></td>
				<td><a href="">詳細</a></td>
				<td><a href="">貸出</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>