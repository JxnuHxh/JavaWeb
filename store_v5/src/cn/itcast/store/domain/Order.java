package cn.itcast.store.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private String oid; //�������
	private Date ordertime; //�µ�ʱ��
	private double total; //�ܼ�
	private int state; //״̬
	private String address; //�ջ��˵�ַ
	private String name; //�ջ�������
	private String telephone; //�ջ��˵绰

	// private String uid;
	// 1_�������Ͷ�������ϵ,�����Ƕ���Ͷ�������Է�����ϵ
	// 2_���OrderĿ��:��orderЯ�������ϵ�������service,dao����,user�����ǿ���Я�����������
	private User user;

	// ���������ֶ�������Ͷ�����֮���ϵ,��������Ŀ�еĲ��ֹ����������Ƶ�����:��ѯ������ͬʱ����Ҫ��ȡ���������еĶ�����
	private List<OrderItem> list = new ArrayList<OrderItem>();

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getList() {
		return list;
	}

	public void setList(List<OrderItem> list) {
		this.list = list;
	}
	

}
