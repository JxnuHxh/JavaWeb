package cn.itcast.store.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//2������3������
public class Cart {
	
	
	
	//�ܼ�/����
	private double total=0;
	//������ȷ���Ĺ����� ��Ʒpid<===>CartItem
	Map<String,CartItem> map=new HashMap<String,CartItem>();
	
	//��ӹ�������ﳵ
	//���û�������빺�ﳵ��ť,���Խ���ǰҪ�������Ʒid,��Ʒ�������͵������,����˸�����Ʒid��ѯ����Ʒ��Ϣ
	//������Ʒ��ϢProduct����,����Ҫ������Ʒ����,��ǰ�Ĺ�����Ҳ�Ϳ��Ի�ȡ����
	public void addCartItemToCar(CartItem cartItem){
		//��ȡ�������빺�ﳵ����ӵ���Ʒpid
		String pid=cartItem.getProduct().getPid();
		
		//����ǰ�Ĺ�������빺�ﳵ֮ǰ,�ж�֮ǰ�Ƿ����������Ʒ
		//���û�����    list.add(cartItem);
		//������: ��ȡ��ԭ�ȵ�����,��ȡ�����ε�����,���֮�����õ�ԭ�ȹ�������
		if(map.containsKey(pid)){
			//��ȡ��ԭ�ȵĹ�����
			CartItem oldItem=map.get(pid);
			oldItem.setNum(oldItem.getNum()+cartItem.getNum());
			
		}else{
			map.put(pid, cartItem);
		}
	}
	
	
	//����MAP�����е�ֵ
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	
	
	
	
	//�Ƴ�������
	public void removeCartItem(String pid){
		map.remove(pid);
	}
	//��չ��ﳵ
	public void clearCart(){
		map.clear();
	}
	
	//�ܼ��ǿ��Ծ��������ȡ��
	public double getTotal() {
		//�����ܼ���0
		total=0;
		//��ȡ��Map�����еĹ�����
		Collection<CartItem> values = map.values();
		
		//�������еĹ�����,���������ϵ�С�����
		for (CartItem cartItem : values) {
			total+=cartItem.getSubTotal();
		}
		
		return total;
	}
	

	public void setTotal(double total) {
		this.total = total;
	}

	public Map<String, CartItem> getMap() {
		return map;
	}


	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
}
