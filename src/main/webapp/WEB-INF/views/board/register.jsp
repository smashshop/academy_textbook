<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:set var = "contextPath" value = "${pageContext.request.contextPath }"/>

<%@include file = "../include/headertest.jsp"%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h3 class="page-header">Board - List</h3>
        </div>
        <%-- /.col-lg-12 --%>
    </div>
    <%-- /.row --%>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <%-- /.panel-heading --%>
                <div class="panel-body">
                    <form name = "boardfrm" role="form" method = "post" action = "${contextPath }/board/register">
	                    <div class="form-group">
	                        <label>게시글 제목 입력</label>
	                        <input name = "btitle" class="form-control">
	                        <p class="help-block">Example block-level help text here.</p>
	                    </div>
	                    <div class="form-group">
                        	<label>글 내용 입력</label>
                        	<textarea name = "bcontent" class="form-control" rows="3"></textarea>
                        </div>
	                    <div class="form-group">
	                        <label>작성자</label>
	                        <input name = "bwriter" class="form-control" placeholder="Enter text">
	                    </div>
	                    <button type="submit" class="btn btn-default">글쓰기</button>
	                    <button type="button" class="btn btn-default" onclick = "location.href = '${contextPath}/board/list'">목록으로</button>
	                </form>
                </div>
                <%-- /.panel-body --%>
            </div>
            <%-- /.panel --%>
        </div>
        <%-- /.col-lg-12 --%>
    </div>
</div>
<%-- /#page-wrapper --%>
        
<%@ include file = "../include/footertest.jsp"%>