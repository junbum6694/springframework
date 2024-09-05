<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top.jsp" %>

<div class="card">
	<div class="card-header">
		Session에 저장된 데이터 이용
	</div>

	<div class="card-body">
		<div class="m-3">
			<p>mid: ${member.mid}</p> <%-- ${}는 request범위에서 먼저 데이터를 찾는다. 없다면 이후 session범위에서 찾는다. --%>
			<p>mname: ${member.mname}</p>
			<p>memail: ${member.memail}</p>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/views/common/bottom.jsp"></jsp:include>