package com.zea.geverytime.market.productsale.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zea.geverytime.market.productsale.model.service.ProductSaleService;
import com.zea.geverytime.market.productsale.model.vo.Product;

/**
 * Servlet implementation class ProductSaleProductEnroll
 */
@WebServlet("/product/productEnroll")
public class ProductSaleProductEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductSaleService pdtService = new ProductSaleService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pdtName = request.getParameter("pdtName");
		int pdtPrice = Integer.parseInt(request.getParameter("pdtPrice"));
		String pdtDiv = request.getParameter("pdtDiv");
		
		
		// 상품 요청 정보 입력
		Product pdt = new Product();
		// 나중에 session에 멤버 받아서 product Seller_id에 set 해야 합니다.
		// 우선 임의로 하드코딩해서 진행함.
		pdt.setSellerId("tarr4h");
		pdt.setPdtName(pdtName);
		pdt.setPdtPrice(pdtPrice);
		pdt.setPdtDiv(pdtDiv);
		
		
		int result = pdtService.productEnroll(pdt);
		System.out.println(result);
		
		String msg = "";
		if(result > 0) {
			msg = "상품 등록에 성공했습니다.";
			request.getSession().setAttribute("msg", msg);
		} else {
			msg = "상품 등록에 실패했습니다.";
			request.getSession().setAttribute("msg", msg);
		}
		
		response.sendRedirect(request.getContextPath()+"/product/onsaleProduct");
	}

}
