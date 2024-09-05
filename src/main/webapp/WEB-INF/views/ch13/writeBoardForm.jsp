<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/common/top.jsp" %>

<div class="card">
	<div class="card-header">
		게시물 쓰기
	</div>

	<div class="card-body">
		<form id="writeBoardForm" method="post" action="writeBoard"
			enctype="multipart/form-data">
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">btitle</span>
				</div>
				<input id="btitle" type="text" name="btitle" class="form-control">
			</div>

			<div class="input-group mt-2">
				<div class="input-group-prepend">
					<span class="input-group-text">bcontent</span>
				</div>
				<textarea id="bcontent" name="bcontent" class="form-control"></textarea>
			</div>

			<div class="input-group mt-2">
				<div class="input-group-prepend">
					<span class="input-group-text">battach</span>
				</div>
				<input id="battach" type="file" name="battach" class="form-control">
			</div>

			<div class="mt-3">
				<button type="submit" class="btn btn-info btn-sm me-2">글쓰기</button>
				<a class="btn btn-info btn-sm" href="#">목록보기</a>
			</div>
		</form>
	</div>
</div>

<jsp:include page="/WEB-INF/views/common/bottom.jsp"></jsp:include>