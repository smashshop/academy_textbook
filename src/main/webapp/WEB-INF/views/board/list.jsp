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
            <button type="button" class="btn btn-default" onclick = "location.href='${contextPath}/board/register'">글쓰기</button>
            <br><br>
        </div>
        <%-- /.col-lg-12 --%>
    </div>
    <%-- /.row --%>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading" style = "height : 50px;">
                    <h4 class = "col-md-6">게시글 목록</h4>
                </div>
                <%-- /.panel-heading --%>
                <div class="panel-body">
                
                
                <form id = "frmSendValue" class = "form-inline" action = "${contextPath }/board/list" method = "get" name = "frmSendValue">
                <div class = "form-group">
                	<select class="form-control" id="selectRowCnt" name="rowCntPerPage"><!-- 표시 게시물 수 선택 -->
						<option value="10" <c:out value="${pagingCreater.pag.rowCntPerPage eq '10'
															? 'selected' : ''}" /> >10개</option>
						<option value="15" <c:out value="${pagingCreater.pag.rowCntPerPage eq '15'
															? 'selected' : ''}" /> >15개</option>
						<option value="20" <c:out value="${pagingCreater.pag.rowCntPerPage eq '20'
															? 'selected' : ''}" /> >20개</option>
						<option value="25" <c:out value="${pagingCreater.pag.rowCntPerPage eq '25'
															? 'selected' : ''}" /> >25개</option>
						<option value="50" <c:out value="${pagingCreater.pag.rowCntPerPage eq '50'
															? 'selected' : ''}" /> >50개</option>									
					</select>
					
					
					<select class="form-control" id="selectScope" name="scope"><!-- 검색 범위 선택 -->
						<option value="" <c:out value="${pagingCreater.pag.scope == null
														? 'selected':''}" /> >검색범위</option>
						<option value="T" <c:out value="${pagingCreater.pag.scope eq 'T'
														? 'selected' : ''}" /> >제목</option>
						<option value="C" <c:out value="${pagingCreater.pag.scope eq 'C'
														? 'selected' : ''}" /> >내용</option>
						<option value="W" <c:out value="${pagingCreater.pag.scope eq 'W'
														? 'selected' : ''}" /> >작성자</option>
						<option value="TC" <c:out value="${pagingCreater.pag.scope eq 'TC'
														? 'selected' : ''}" /> >제목 + 내용</option>
						<option value="TW" <c:out value="${pagingCreater.pag.scope eq 'TW'
														? 'selected' : ''}" /> >제목 + 작성자</option>
						<option value="TCW" <c:out value="${pagingCreater.pag.scope eq 'TCW'
														? 'selected' : ''}" /> >제목 + 내용 + 작성자</option>
					</select>
					
					<div class="input-group"><!-- 검색어 입력 -->
						<input class="form-control" id="inputKeyword" name="keyword" type="text" placeholder="검색어를 입력하세요"
								value='<c:out value="${pagingCreater.pag.keyword}"/>' />
						<span class="input-group-btn"><!-- 전송버튼 -->
							<button class="btn btn-info" type="button" id="btnSearchGo">
							검색 &nbsp;<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
					
					<div class="input-group"><!-- 검색 초기화 버튼 -->
						<button id="btnReset" class="btn btn-warning" type="reset">검색초기화</button>
					</div>
					
                    <input type = "hidden" name = "pageNum" value = "${pagingCreater.pag.pageNum }"/>
                	<%--<input type = "hidden" name = "rowCntPerPage" value = "${pagingCreater.pag.rowCntPerPage }"/>
                	name이 rowCntPerPage가 두개이기때문에 하나를 없애줌--%>
                </div>
                </form><br>
                
                
                    <table class="table table-striped table-bordered table-hover"
                    	   style = "width : 100%; text-align:center;" >
                        <thead>
                            <tr>
                                <th style = "text-align:center">글 번호</th>
                                <th style = "text-align:center">제목</th>
                                <th style = "text-align:center">작성자</th>
                                <th style = "text-align:center">작성일</th>
                                <th style = "text-align:center">수정일</th>
                                <th style = "text-align:center">조회수</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach items="${boardList}" var="board">
                        	<c:if test="${board.bdelFlag == 1 }">
                        		<tr style = "background-color : moccasin;">
                        			<td colspan = "6">작성자가 삭제한 게시글입니다.</td>
                        		</tr>
                        	</c:if>
                        	<c:if test = "${board.bdelFlag == 0 }">
                        		<tr class="moveDetail" data-bno = '<c:out value="${board.bno }"/>'>
	                                <td>${board.bno }</td>
	                                <td style = "text-align:left;"><a href = "${contextPath}/board/detail?bno=${board.bno }">${board.btitle }</a></td>
	                                <td>${board.bwriter }</td>
	                                <td class="center">
	                                	<fmt:formatDate value="${board.bregDate }" pattern="yyyy년 MM월 dd일 E요일 HH시 mm분"/>
	                                </td>
	                                <td class="center">
	                                	<fmt:formatDate value="${board.bmodDate }" pattern="yyyy년 MM월 dd일 E요일 HH시 mm분"/>
	                                </td>
	                                <td>${board.bviewCnt }</td>
	                            </tr>
                        	</c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                    <%-- /.table-responsive --%>
                    
                    
                    <%-- pagination --%>
                    <div class = "pull-right">
                	<ul class="pagination">
                		<c:if test = "${pagingCreater.prev}">
							<li class = "pagingButton">
								<a href="1" aria-label = "first">
						    		<span>&laquo;</span>
								</a>
							</li>
							<li class = "pagingButton">
								<a href="${pagingCreater.startPagingNum-10}" aria-label = "prev">
						    		<span>&lt;</span>
								</a>
							</li>
						</c:if>
						<c:forEach var = "pagingNum" begin="${pagingCreater.startPagingNum }" end="${pagingCreater.endPagingNum }" >
							<li class = "pagingButton ${pagingCreater.pag.pageNum == pagingNum ? 'active' : '' }">
								<a href="${pagingNum }">${pagingNum }</a>
							</li>
						</c:forEach>
						
						
						<c:if test = "${pagingCreater.next }">
							<li class = "pagingButton">
								<a href="${pagingCreater.startPagingNum+10}" aria-label = "next">
							  		<span>&gt;</span>
								</a>
							<li/>
							<li class = "pagingButton">
								<a href="${pagingCreater.lastPageNum}" aria-label = "last">
							  		<span>&raquo;</span>
								</a>
							</li>
						</c:if>
					</ul>
					</div>
                    <%-- /.pagination --%>
                    
                </div>
                <%-- /.panel-body --%>
            </div>
            <%-- /.panel --%>
        </div>
        <%-- /.col-lg-12 --%>
    </div>
</div>
<%-- /#page-wrapper --%>
<script>
	var frmSendValue = $("#frmSendValue");
	
	$("#btnReset").on("click", function(){
		$("#selectRowCnt").val(10);
		$("#selectScope").val("");
		$("#inputKeyword").val("");
		$("#pageNum").val("");
		$("#rowCntPage").val("");
		
		frmSendValue.submit();
	});

	$("#btnSearchGo").on("click", function(){
		if(!$("#selectScope").find("option:selected").val() ){
			alert("검색범위를 선택하세요");
			return;
		}
		
		if($("#inputKeyword").val() == null || $("#inputKeyword").val() == ""){
			alert("검색어를 입력하세요");
			return;
		}
	
		frmSendValue.find("input[name='pageNum']").val("1");
		frmSendValue.submit();
	});
	
	
	$("#selectRowCnt").on("change", function(){
		frmSendValue.find("input[name='pageNum']").val("1");
		frmSendValue.submit();
	});
	
	
	$(".pagingButton>a").on("click", function(e){
		e.preventDefault();
		
		frmSendValue.find("input[name='pageNum']").val($(this).attr("href"));
		frmSendValue.attr("action", "${contextPath}/board/list");
		frmSendValue.attr("method", "get");
		frmSendValue.submit();
	});
	
	
	$(".moveDetail").on("click", function(e){
		frmSendValue.append("<input type = 'hidden' name = 'bno' value = '" + $(this).data("bno") + "'>");
		frmSendValue.attr("action", "${contextPath}/board/detail");
		frmSendValue.attr("method", "get");
		frmSendValue.submit();
	});
	

	
	
	var result = '<c:out value = "${result}"/>';
	
	function checkModal(result){
		var myMsg = "";
		if(result == "" || history.state){
			return;
		}else if(result == "removeSuccess(실제삭제)"){
			myMsg = "글이 삭제되었습니다";
		}else if(result == "deleteSuccess"){
			myMsg = "글이 삭제되었습니다(삭제요청)";
		}else if(parseInt(result) > 0){
			myMsg = '<c:out value = "${result}"/>' + "번 글이 등록되었습니다";
		}
		
		$(".modal-body").html(myMsg);
		$("#myModal").modal("show");
		myMsg = "";
	}
	
	$(document).ready(function(){
		checkModal(result);
		
		window.addEventListener("popstate", function(event){
			history.pushState(null, null, location.href);
		});
		history.pushState(null, null, location.href);
	});
</script>
<%@ include file = "../include/footertest.jsp"%>