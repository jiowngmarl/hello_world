<%@page import="com.yedam.common.PageDTO"%>
<%@page import="com.yedam.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"/>

	<!-- webapp/WEB-INF/views/boardList.jsp -->
	<%
		List<BoardVo> list = (List<BoardVo>) request.getAttribute("blist");
		PageDTO pageDTO = (PageDTO) request.getAttribute("paging");
		String sc = (String) request.getAttribute("searchCondition");
		String kw = (String) request.getAttribute("keyword");
	%>
	
	<p><%=pageDTO %></p>
	<h3>게시글 목록(boardList.jsp)</h3>
	<!-- 검색조건 -->
	<form action="boardList.do">
	<div class="row">
		<div class="col-sm-4">
			<select name="searchCondition" class="form-control">
				<option>선택하세요</option>
				<option value="T">제목</option>
				<option value="W">작성자</option>
				<option value="TW">제목&작성자</option>
			</select>
		</div>
		<div class="col-sm-4">
			<input type="text" name="keyword" class="form-control">
		</div>
		<div class="col-sm-2">
			<button type="submit" class="btn btn-info">검색</button>
		</div>
	</div>
	</form>
	
	
	<table class = "table">
		<thead>
			<tr><th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th></tr>
		</thead>
		<tbody>
			<%for (BoardVo board : list) { %>
			<tr>
				<td><%=board.getBoardNo() %></td>
				<td><a href='board.do?page=<%=pageDTO.getCurrentPage() %>&bno=<%=board.getBoardNo() %>'><%=board.getTitle() %></a></td>
				<td><%=board.getWriter() %></td>
				<td><%=board.getWriteDate() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>
	
	<!-- page 번호 처리 (부트스트랩에서 가져온 것) -->
	<nav aria-label="...">
  <ul class="pagination">
  	<!-- 이전 10개 페이지 여부 -->
  	<%if (pageDTO.isPrev()) {%>
    <li class="page-item">
      <a class="page-link" href="boardList.do?page=<%=pageDTO.getStartPage()-1 %>">Previous</a>
    </li>
    <%} else {%>
    <li class="page-item  disabled">
      <span class="page-link">Previous</span>
    </li>
    <%} %>
    <% for (int p = pageDTO.getStartPage(); p <= pageDTO.getEndPage(); p++) { %>
    <% 	  if(pageDTO.getCurrentPage() == p) { %>
        <li class="page-item active" aria-current="page">
      <span class="page-link"><%=p %></span>
    </li>
    <%} else { %>
    <li class="page-item"><a class="page-link" href="boardList.do?page=<%=p %>&searchCondition=<%=sc %>&keyword=<%=kw %>"><%=p %></a></li>
    <%}
    }%>

	<!-- 이후 10개 페이지 여부 -->
  	<%if (pageDTO.isNext()) {%>
    <li class="page-item">
      <a class="page-link" href="boardList.do?page=<%=pageDTO.getEndPage()+1 %>">Next</a>
    </li>
    <%} else {%>
    <li class="page-item disabled">
      <span class="page-link">Next</span>
    </li>
    <%} %>
  </ul>
</nav>
	
<jsp:include page="includes/footer.jsp"/>