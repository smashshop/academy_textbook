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
            <div class="panel panel-default">
           
                <div class="panel-heading">
                	제목 : ${board.btitle }
                	<span style = "float:right">조회수${board.bviewCnt }</span>
                </div>
                <%-- /.panel-heading --%>
                <div class="panel-body">
                작성자 : ${board.bwriter }
                <span style = "float:right">작성 날자 : <fmt:formatDate value="${board.bregDate }" pattern="yyyy년 MM월 dd일 E요일 HH시 mm분"/></span>
                	<div class="form-group">
                    	<textarea name = "bcontent" class="form-control" rows="3" readonly>${board.bcontent }</textarea>
                   	</div>
                   	<span style = "float:right">최종 수정일 : <fmt:formatDate value="${board.bmodDate }" pattern="yyyy년 MM월 dd일 E요일 HH시 mm분"/></span>
                </div>
                <%-- /.panel-body --%>
            </div>
            <button type="button" id = "BtnMoveModify" class="btn btn-default">수정하기</button>
            <button type="button" id = "BtnMoveList" class="btn btn-default">목록으로</button>
            <%-- /.panel --%>
            
        </div>
        <%-- /.col-lg-12 --%>
    </div>
    <form id = "frmSendValue">
		<input type = "hidden" name = "pageNum" value = "${paging.pageNum }"/>
		<input type = "hidden" name = "rowCntPerPage" value = "${paging.rowCntPerPage }"/>
		<input type = "hidden" id = "bno" name = "bno" value = "${board.bno }"/>
		<input type = "hidden" name = "scope" value = "${paging.scope }"/>
        <input type = "hidden" name = "keyword" value = "${paging.keyword }"/>
	</form>
</div>
<%-- /#page-wrapper --%>


<script>
	var frmSendValue = $("#frmSendValue");
	
	$("#BtnMoveList").on("click", function(e){
		frmSendValue.find("#bno").remove();
		frmSendValue.attr("action", "${contextPath}/board/list");
		frmSendValue.attr("method", "get");
		frmSendValue.submit();
	});
	
	$("#BtnMoveModify").on("click", function(e){
		frmSendValue.attr("method", "get");
		frmSendValue.attr("action", "${contextPath}/board/modify");
		frmSendValue.submit();
	});


	


	var result = '<c:out value = "${result}"/>';
	var msg = "";
	
	function checkModifiedOperation(result){
		if(result == "" || history.state){
			return;
		}else if(result == "modifySuccess"){
			msg = "글이 수정되었습니다";
		}
		alert(msg);
		msg = "";
	}
	
	$(document).ready(function(){
		checkModifiedOperation(result);
	})
</script>
<%@ include file = "../include/footertest.jsp"%>