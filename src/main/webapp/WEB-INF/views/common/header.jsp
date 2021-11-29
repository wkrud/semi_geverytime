<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/summernote/summernote-lite.css">
<script src="<%= request.getContextPath() %>/js/jquery-3.6.0.js"></script>
<script src="<%= request.getContextPath() %>/js/summernote/summernote-lite.js"></script>
<script src="<%= request.getContextPath() %>/js/summernote/lang/summernote-ko-KR.js"></script>
</head>
<body>
    <div id="container">
        <section id="header" >
           <div class="wrapper">
               <div class="title"><a href="<%=request.getContextPath() %>/">타이틀</a></div>
               <ul class="lists" >
                   <li id="info"><a href="#">정보</a></li>
                   <li id="board"><a href="<%=request.getContextPath() %>/board/freeMain">게시판</a></li>
                   <li id="market"><a href="#">마켓</a></li>
               </ul>
               <ul>
                   <!--관리자페이지표시 안 보이게 할 때 아래 한 줄만 처리해야 흐트러지지 않음 -->
                   <li id="admin"><a href="#" style="color: red">관리자페이지</a></li>
               </ul>
            <nav>
               <ul class="navs">
               <li class="nav" id="login"><a href="#">로그인/로그아웃</a></li>
               <li class="nav" id="mypage"><a href="#">마이페이지</a></li>
               <li class="nav" id="dm"><a href="#">DM</a></li>
               <li class="nav"id="qna"><a href="#">고객센터</a></li>
               </ul>
            </nav>
           </div>
        </section>
        <div class="navbox-container">
	        <div class="info-navsbox">
	            <ul class="info-pagenavs">
	                <li class="info-pagenav" id="hospital"><a href="#">동물병원</a></li>
	                <li class="info-pagenav" id="cafe"><a href="#">카페</a></li>
	                <li class="info-pagenav" id="food"><a href="#">음식점</a></li>
	                <li class="info-pagenav" id="pension"><a href="#">펜션</a></li>
	                <li class="info-pagenav" id="salon"><a href="#">미용실</a></li>
	            </ul>
	        </div> 
	        <div class="board-navsbox">
	            <ul class="board-pagenavs">
	                <li class="board-pagenav" id="board"><a href="<%=request.getContextPath() %>/board/freeMain">자유게시판</a></li>
	                <li class="board-pagenav" id="review"><a href="#">후기</a></li>
	            </ul>
	        </div> 
	        <div class="market-navsbox">
	            <ul class="market-pagenavs">
	                <!-- <li class="pagenav3" id="point"><a href="#">내 Point 확인</a></li> -->
	                <li class="market-pagenav" id="store"><a href="#">일반상점</a></li>
	                <li class="market-pagenav" id="used"><a href="#">중고 매매</a></li>
	                <li class="market-pagenav" id="list"><a href="#">찜 목록</a></li>
	                <li class="market-pagenav" id="cart"><a href="#">장바구니</a></li>
	            </ul>
	        </div>
        </div>
    </div>
    <section id="content">
    
    <script>
    //중복코드제거(+이벤트버블링활용)
    $(".lists").mouseover((e) =>{
    	const id = $(e.target).parent().attr('id');
    	$(".navbox-container").children().hide();
        $(`.\${id}-navsbox`).show();
	});
    
    // 일반상점 이동
    $("#store").click((e) => {
    	location.href="<%= request.getContextPath() %>/product/main";
    });

	</script>