package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.Category;
import cn.itcast.store.service.CategoryService;
import cn.itcast.store.service.ServiceImp.CategoryServiceImp;
import cn.itcast.store.utils.JedisUtils;
import cn.itcast.store.web.base.BaseServlet;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;


@WebServlet("/CategoryServlet")
public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/*public  String findAllCats(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//����ҵ����ȡȫ������
	Jedis jedis=JedisUtils.getJedis();
	String jsonStr=jedis.get("allCats");
	if(null==jsonStr||"".equals(jsonStr)) {
		
	
		CategoryService CategoryService=new CategoryServiceImp();
		List<Category> list=CategoryService.getAllCats();
		//��ȫ������ת��ΪJSON��ʽ������
	 jsonStr = JSONArray.fromObject(list).toString();
	System.out.println(jsonStr);
	//����ȡ�������ݴ���
	jedis.set("allCats",jsonStr);
	
		//��ȫ��������Ϣ��Ӧ���ͻ���
	
		response.setContentType("application/json;chart=utf-8");
		response.getWriter().print(jsonStr);
	}else {
		System.out.println("youshuju");
		response.setContentType("application/json;chart=utf-8");
		response.getWriter().print(jsonStr);
	}
	JedisUtils.closeJedis(jedis);
	
	<script >
$(function(){
	var url="/store_v5/CategoryServlet";
	var obj={"method":"findAllCats"};
	$.post(url,obj,function(data){
		alert(data)
		
		$.each(data,function(i,obj){
		var li="<li><a href='#'>"+obj.cname+"</a></li>";
		$("#myUL").append(li);
		});
	},"json");
})

</script����header.jsp���µ�
		return null;
	}
	
*/
}
