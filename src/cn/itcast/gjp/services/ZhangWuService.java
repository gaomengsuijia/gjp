package cn.itcast.gjp.services;

import java.util.List;

import cn.itcast.gjp.dao.ZhangWuDao;
import cn.itcast.gjp.domain.ZhangWu;


/**
 * 服务层
 * @author Administrator
 *
 */
public class ZhangWuService {
	
	private ZhangWuDao zhangWuDao = new ZhangWuDao();
	
	public List<ZhangWu> selectZhangWu(){
		return zhangWuDao.selectZhangWu();
	}
	
	public List<ZhangWu> select(String start,String end){
		return zhangWuDao.select(start,end);
		
	}
	public int addZhangWu(ZhangWu zhangWu){
		return zhangWuDao.addZhangWu(zhangWu);
	}
	
	public int editZhangWu(ZhangWu zhangWu){
		return zhangWuDao.editZhangWu(zhangWu);
	}
	
	public int deleteZhangWu(int zwid){
		return zhangWuDao.deleteZhangWu(zwid);
	}

}
