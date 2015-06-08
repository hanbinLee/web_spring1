<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath }"/>
	
	<c:choose>
		<c:when test="${check==1 }">
			<script type="text/javascript">
				alert("수정완료");
				location.href="${root}/fileBoard/list.do?pageNumber=${pageNumber}";
			</script>
		</c:when>
		
		<c:otherwise>
			<script type="text/javascript">
				alert("수정 실패 비밀번호 확인");
				location.href="${root}/fileBoard/read.do?boardNumber=${boardNumber}&pageNumber=${pageNumber}";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>