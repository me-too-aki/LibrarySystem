<%-- ここに図書貸出画面を表示する。 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" import="java.lang.*, java.util.*"
	contentType="text/html; charset=utf-8"%>

<html>
<head>
<title>図書貸出画面</title>
</head>
<body>
	<h1>図書貸出画面</h1>
	<%-- 図書貸出画面を表示する。 --%>
	<table border="1">
		<tr>
			<td>タイトル</td>
			<td>著者</td>
			<td>出版社</td>
			<td>出版日</td>
		</tr>
		<tr>
			<%-- LendControllerよりlistを受け取り、それぞれ表示する。 --%>
			<td><c:out value="${lendBookDetails.bookTitle}" /></td>
			<td><c:out value="${lendBookDetails.writterName}" /></td>
			<td><c:out value="${lendBookDetails.publisher}" /></td>
			<td><c:out value="${lendBookDetails.publishedAt}" /></td>
		</tr>
	</table>
	<br>
	<%-- 確認画面にデータを送信する為のフォームを準備する。 --%>
	<form method="post" action="">
		<table border="1">
			<tr>
				<td>借入者</td>
				<%-- LendControllerよりlistを受け取り、プルダウンでそれぞれ表示する。 --%>
				<td><select name="userName">
						<c:forEach var="list" items="${users}">
							<option><c:out value="${list.userName}" />
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<%-- LendControllerより現在の日付と7日後の日付を取得し、表示する。 --%>
				<td>貸出日</td>
				<td><input type="date" name="lendDate" value="${lendDate}"
					readonly><br></td>
			</tr>
			<tr>
				<td>返却日</td>
				<td><input type="date" name="dueDate" value="${dueDate}">
				</td>
			</tr>
		</table>
		<br> <input type="submit" value="確認" />
	</form>
</body>
</html>