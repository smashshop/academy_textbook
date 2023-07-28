<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:set var = "contextPath" value = "${pageContext.request.contextPath }"/>

<%@include file = "../include/headertest.jsp"%>
<div id="page-wrapper">
    <br><br><br>
    <%-- /.row --%>
    <div class="row">
        <div class="col-lg-12">
            <h3 class="page-header">수정하기</h3>
        </div>
        <%-- /.col-lg-12 --%>
        <div class="col-lg-12">
        <form role = "form" method = "post" id = "modifyfrm" name = "modifyfrm" action = "${contextPath}/board/modify">
        <input type = "hidden" name = "bno" value = "${board.bno }">
            <div class="panel panel-default">
                <div class="panel-heading">
                	<div class="form-group">
	                        <input type = "text" name = "btitle" class="form-control" value="${board.btitle }"/>
	                 </div>
                </div>
                <%-- /.panel-heading --%>
                <div class="panel-body">
                작성자 <input type = "text" name = "bwriter" class="form-control" value = "${board.bwriter }" readonly/>
                	<div class="form-group">
                    	<textarea name = "bcontent" class="form-control" rows="3">${board.bcontent }</textarea>
                   	</div>
                </div>
                <%-- /.panel-body --%>
            </div>
            <input type = "hidden" name = "pageNum" value = '<c:out value = "${paging.pageNum }"/>'/>
			<input type = "hidden" name = "rowCntPerPage" value = '<c:out value = "${paging.rowCntPerPage }"/>'/>
			<input type = "hidden" name = "scope" value = "${paging.scope }"/>
            <input type = "hidden" name = "keyword" value = "${paging.keyword }"/>
            
            <button type="button" class="btn btn-default" id = "btnModify" data-oper = "modify">수정하기</button>
            <button type="button" class="btn btn-default" id = "btnRemove" data-oper = "delete">삭제하기</button>
            <button type="button" class="btn btn-default" id = "btnList" data-oper = "list">목록으로</button>
            <%-- /.panel --%>
        </form>
        </div>
        <%-- /.col-lg-12 --%>
    </div>
</div>
<%-- /#page-wrapper --%>
<script>
	var modifyfrm = $("#modifyfrm");
	
	$("button").on("click", function(e){
		var operation = $(this).data("oper");
		
		if(operation == "modify"){
			modifyfrm.attr("action", "${contextPath}/board/modify");
		}else if(operation == "list"){
			modifyfrm.attr("action", "${contextPath}/board/list").attr("method", "get");
			var pageNumInput = $("input[name='pageNum']").clone();
			var rowCntPerPageInput = $("input[name='rowCntPerPage']").clone();
			var scopeInput = $("input[name='scope']").clone();
			var keywordInput = $("input[name='keyword']").clone();
			
			modifyfrm.empty();
			
			
		}else if(operation == "delete"){
			modifyfrm.attr("action", "${contextPath}/board/delete");
		}
		modifyfrm.submit();
	});
</script>
<%@ include file = "../include/footertest.jsp"%>