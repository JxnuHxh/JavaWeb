package cn.itcast.store.service.ServiceImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.dao.OrderDao;
import cn.itcast.store.dao.daoImp.OrderDaoImp;
import cn.itcast.store.domain.Order;
import cn.itcast.store.domain.OrderItem;
import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.User;
import cn.itcast.store.service.OrderService;
import cn.itcast.store.utils.JDBCUtils;

public class OrderServiceImp implements OrderService {
	
	OrderDao orderDao=new OrderDaoImp();

	@Override
	public List<Order> findAllOrders() throws Exception {
		return orderDao.findAllOrders();
	}

	@Override
	public List<Order> findAllOrders(String st) throws Exception {
		return orderDao.findAllOrders(st);
	}

	@Override
	public void saveOrder(Order order) throws SQLException {
		//���涩���Ͷ��������еĶ�����(ͬʱ�ɹ�,ʧ��)
		/*try {
			JDBCUtils.startTransaction();
			OrderDao orderDao=new OrderDaoImp();
			orderDao.saveOrder(order);
			for(OrderItem item:order.getList()){
				orderDao.saveOrderItem(item);
			}
			JDBCUtils.commitAndClose();
		} catch (Exception e) {
			JDBCUtils.rollbackAndClose();
		}
		*/
		
		Connection conn=null;
		try {
			//��ȡ����
			conn=JDBCUtils.getConnection();
			//��������
			conn.setAutoCommit(false);
			//���涩��
			
			orderDao.saveOrder(conn,order);
			//���涩����
			for (OrderItem item : order.getList()) {
				orderDao.saveOrderItem(conn,item);	
			}
			//�ύ
			conn.commit();
		} catch (Exception e) {
			//�ع�
			conn.rollback();
		}
	}

	@Override
	public PageModel findMyOrdersWithPage(User user, int curNum) throws Exception {
		//1_����PageModel����,Ŀ��:���㲢��Я����ҳ����
		//select count(*) from orders where uid=?
		int totalRecords=orderDao.getTotalRecords(user);
		PageModel pm=new PageModel(curNum, totalRecords, 3);
		//2_��������  select * from orders where uid=? limit ? ,?
		List list=orderDao.findMyOrdersWithPage(user,pm.getStartIndex(),pm.getPageSize());
		pm.setList(list);
		//3_����url
		pm.setUrl("OrderServlet?method=findMyOrdersWithPage");
		return pm;
	}

	@Override
	public Order findOrderByOid(String oid) throws Exception {
		return orderDao.findOrderByOid(oid);
		
	}

	@Override
	public void updateOrder(Order order) throws Exception {
		orderDao.updateOrder(order);
		
	}
}