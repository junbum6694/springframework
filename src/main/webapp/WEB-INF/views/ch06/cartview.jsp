<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/top.jsp"%>

<div class="card">
	<div class="card-header">
		장바구니
	</div>

	<div class="card-body">
		<div class="m-3">
			<ul>
				<c:forEach items="${cart.contents}" var="item">
				<li class="mt-2">
					<span>${item.pname}</span>
					<a href="deleteitem?pno=${item.pno}" class="btn btn-danger btn-sm">삭제</a>
				</li>					
				</c:forEach>

			</ul>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/views/common/bottom.jsp"></jsp:include>