package cn.itcast.gjp.controller;

import java.util.List;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.services.ZhangWuService;

public class ZhangWuController {
	
	private ZhangWuService zhangWuService = new ZhangWuService();
	
	public List<ZhangWu> selectZhangWu(){
		return zhangWuService.selectZhangWu();
		
	}
	
	public List<ZhangWu> select(String start,String end){
		return zhangWuService.select(start,end);
		
	}
	
	public int addZhangWu(ZhangWu zhangWu){
		return zhangWuService.addZhangWu(zhangWu);
	}	
	
	public int editZhangWu(ZhangWu zhangWu){
		return zhangWuService.editZhangWu(zhangWu);
	}
	
	public int deleteZhangWu(int zwid){
		return zhangWuService.deleteZhangWu(zwid);
	}

}
