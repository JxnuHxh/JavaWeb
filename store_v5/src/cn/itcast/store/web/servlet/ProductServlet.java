package cn.itcast.store.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.Product;
import cn.itcast.store.service.ProductService;
import cn.itcast.store.service.ServiceImp.ProductServiceImp;
import cn.itcast.store.web.base.BaseServlet;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends BaseServlet {
	
	public String findProductByPid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��ȡid
		String pid=request.getParameter("pid");
		
		//������Ʒpid��ѯ��Ʒ��Ϣ
		ProductService productService=new ProductServiceImp();
		Product product=productService.findProductByPid(pid);
		//�������Ʒ����request
		request.setAttribute("product",product);
		//ת����
		return "/jsp/product_info.jsp";
	}
	//
	public String findProductsByCidWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		String cid=request.getParameter("cid");
		int curNum=Integer.parseInt(request.getParameter("num"));
		
		ProductService productService=new ProductServiceImp();
		PageModel pm= productService.findProductsByCidWithPage(cid,curNum);
		request.setAttribute("page", pm);
		return "/jsp/product_list.jsp";
	}
}
