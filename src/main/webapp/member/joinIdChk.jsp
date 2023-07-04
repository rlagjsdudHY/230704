<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="dao" class="pack.dao.Join" />
<% 
request.setCharacterEncoding("UTF-8");

String userId = request.getParameter("userId");
int rtnCnt = 0;
if (userId != null) {
	rtnCnt = dao.chkUserId(userId);
}
%>

<%=rtnCnt %>