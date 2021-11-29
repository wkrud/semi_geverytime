package com.zea.geverytime.common;

public class MvcUtils {

	public static String getPagebar(int cPage, int numPerPage, int pageBarSize, int totalContentCount,
			String url) {
		StringBuilder str = new StringBuilder();
		
		int totalPage = (int)Math.ceil((double)totalContentCount/numPerPage);
		int endPage = (int)Math.ceil((double)cPage/pageBarSize)*pageBarSize;
		int startPage = endPage-pageBarSize+1;
		System.out.println(totalContentCount);
		System.out.println(startPage);
		System.out.println(endPage);
		System.out.println(totalPage);
		int pageNum = startPage;
		
		// 1. startPage가 1페이지가 아닌 경우 prev만들기
		if(startPage!=1) {
			str.append("<a data-page='"+(startPage-1)+"'>prev</a>");
		}
		// 2. 숫자만들기 (+ next버튼)
		// 토탈페이지가 엔드페이지보다 큰 경우 -> 숫자 끝까지 + next
		if(totalPage>endPage) {
			while(pageNum<=endPage) {
				if(pageNum!= cPage) {
					str.append("<a data-page='"+pageNum+"'>"+pageNum+"</a>");
				}
				else {
					str.append("<span class='cPage'>"+cPage+"</span>");
				}
				pageNum++;
			}
			// next버튼 추가
			str.append("<a data-page='"+(endPage+1)+"'>next</a>");
		}
		// 토탈페이지가 엔드페이지보다 작거나 같은 경우 -> 토탈페이지까지 (next버튼 x)
		else {
			while(pageNum<=totalPage) {
				if(pageNum!= cPage) {
					str.append("<a data-page='"+pageNum+"'>"+pageNum+"</a>");
				}
				else {
					str.append("<span class='cPage'>"+cPage+"</span>");
				}
				pageNum++;
			}
		}
		return str.toString();
	}
}
