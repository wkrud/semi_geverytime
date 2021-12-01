<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<form
	id="boardEnrollFrm"
	name="boardEnrollFrm"
	action="<%=request.getContextPath() %>/board/boardEnroll" 
	method="post"
	enctype = "multipart/form-data">
	<table id="tbl-board-view">
	<tr>
		<th>게시판 선택</th>
		<td>
			<select name="boardCode" id="boardCode">
				<option value="bb1b">자유게시판 - 강아지</option>
				<option value="bb2b">자유게시판 - 고양이</option>
				<option value="bb3b">후기게시판 - 가는거</option>
				<option value="bb4b">후기게시판 - 먹는거</option>
				<option value="bb5b">후기게시판 - 쓰는거</option>
			</select>
		</td>
	</tr>
	<tr>
		<th>제 목</th>
		<td><input type="text" name="title" required></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>
			<input type="text" name="writer" value="<%-- <%=loginMember.getMemberid() %> --%>"/>
		</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td>			
			<input type="file" name="file1">
			<br>
			<input type="file" name="file2">
		</td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea id="summernote" rows="5" cols="40" name="content"></textarea></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" value="등록하기">
		</th>
	</tr>
</table>
</form>
<script>
	$(document.boardEnrollForm).submit((e)=>{
		console.log('hi');
	})
	$(document).ready(function() {
		$('#summernote').summernote({
			  height: 300,                 // 에디터 높이
			  minHeight: null,             // 최소 높이
			  maxHeight: null,             // 최대 높이
			  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
			  lang: "ko-KR",					// 한글 설정
			  placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
	          
		});
			//이미지 업로드 세팅
		let setting = {
            height : 300,
            minHeight : null,
            maxHeight : null,
            focus : true,
            lang : 'ko-KR',
            toolbar : toolbar,
            //콜백 함수
            callbacks : { 
            	onImageUpload : function(files, editor, welEditable) { // onImageUpload : 이미지를 업로드했을 때 동작되는 함수
	            // 파일 업로드(다중업로드를 위해 반복문 사용)
		            	for (var i = files.length - 1; i >= 0; i--) {
			            	uploadSummernoteImageFile(files[i],this);
	            		}
            		}
            	}
			};
        	$('#summernote').summernote(setting); //세팅 적용
        });
        
		//이미지 파일을 서버로 전송, 저장하게 하는 함수
         function uploadSummernoteImageFile(file, el) {
			data = new FormData();
			data.append("file", file);
			$.ajax({
				data : data,
				type : "POST",
				url : "/board/uploadImageFile",
				contentType : false,
				enctype : 'multipart/form-data',
				processData : false,
				success : function(data) {
					console.log('ho');
					console.log(data);
					$(el).summernote('editor.insertImage', data.url);
				},
				error : console.log
			});
		} 

</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>