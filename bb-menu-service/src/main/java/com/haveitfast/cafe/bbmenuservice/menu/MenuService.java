package com.haveitfast.cafe.bbmenuservice.menu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MenuService {
	public static List<Menu> menus = new ArrayList();
	private static int idCounter=0;
	
	static {
		menus.add(new Menu(++idCounter,"Water",60,true));
		menus.add(new Menu(++idCounter,"Tea",40,true));
		menus.add(new Menu(++idCounter,"Coffee",50,true));
		
	} 
	
	public static List<Menu> findAllMenu(){
		return menus;
	}
	public static Menu findMenuById(long id) {
		for(Menu i:menus) {
			if(i.getId()==id)
				return i;
		}
			
		return null;
	}
	public static long findIdCounter() {
		// TODO Auto-generated method stub
		return idCounter;
	}
	public static Menu updateMenu(long id ,Menu menus1) {
		// TODO Auto-generated method stub
//		if(menus1.getId()==-1) {
//			menus1.setId(++idCounter);
//			menus.add(menus1);
//		}
//		else {
//			deleteById(menus1.getId());
//			menus.add(menus1);
//		}
		Menu x=findMenuById(id);
		x.setEnable(menus1.isEnable());
		return x;
	}
	public static Menu createMenu(Menu menus1) {
		// TODO Auto-generated method stub
		menus1.setId(++idCounter);
			menus.add(menus1);
		return menus1;
	}
	private static Menu deleteById(long id) {
		// TODO Auto-generated method stub
		Menu menus1 = findMenuById(id);
		if(menus1 == null)
			return null;
		if(menus.remove(menus1))
			return menus1;
		return null;	
		
	}
	public static boolean findEnableStatus(long id) {
		// TODO Auto-generated method stub
		Menu x =findMenuById(id);
		return x.isEnable();
	}
	

}
