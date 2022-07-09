<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${requestScope.msg!=null}">
        <h3><c:out value="${requestScope.msg}"></c:out></h3>
        </c:if><br><br>
        <c:if test="${sessionScope.paymentDetail!=null}">
            <c:set var = "file" scope = "session" value = "${sessionScope.paymentDetail}"/>  
        </c:if>
         <a href = "<c:url value = "DownloadServlet?paymentDetail=${paymentdetail}"/>">Download</a>&nbsp;&nbsp;&nbsp;
         <a href = "<c:url value = "file-list.jsp"/>">View List</a>
</body>
</html>