<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginOk</title>
<script src="${root}/css/member/jquery.js"></script>
</head>
<body>
	<c:choose>
		<c:when test="${memberLevel !=null }">
			<c:set var="id" value="${id }" scope="session"/>
			<c:set var="memberLevel" value="${memberLevel }" scope="session" />
			<script>
				alert("로그인 성공");
				$(location).attr("href" ,"${root}/aStart.jsp" );
			</script>
		</c:when>	
		
		<c:otherwise>
			<script type="text/javascript">
				alert("로그인 실패");
				$(location).attr("href" ,"${root}/member/login.do" );
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>