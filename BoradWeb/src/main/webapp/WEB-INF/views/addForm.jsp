<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- action에는 서블릿할 페이지의 정보를 저장한다 -->
	<%
		String logId = (String) session.getAttribute("logId");
	%>
	<form action = "addBoard.do" method="post"> 
		<table class = "talbe">
			<tr>
				<th>글제목</th><td><input class="form-control" type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=logId %>
				<input class="form-control" type="hidden" name="writer" value="<%=logId %>">
				</td>
			</tr>
			<tr>
				<th>본문</th><td><textarea class="form-control" name="content" rows="3" cols="40"></textarea></td>
			</tr>
			<tr>
				<td colspan = "2" align = "center">
				<input type = "submit" class="btn btn-primary">
				<input type = "reset" class="btn btn-secondary">
				</td>
			</tr>
		</table>
	</form> 
