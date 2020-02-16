package cn.itcast.gjp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.tools.JdbcUtil;

public class ZhangWuDao {
	private static QueryRunner qr = new QueryRunner(JdbcUtil.getDatasource());
	
	public int deleteZhangWu(int zwid){
		String sql = "DELETE from gjp_zhangwu WHERE zwid=?";
		int result;
		Object[] param = {zwid};
		try{
			result = qr.update(sql, param);
			return result;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("数据操作失败");
		}
	}
	
	
	/**
	 * 编辑账务
	 * @param zhangWu
	 * @return
	 */
	public int editZhangWu(ZhangWu zhangWu){
		String sql = "UPDATE gjp_zhangwu set flname = ?," +
				"money = ?,zhanghu = ?,createtime=?,description=? WHERE zwid=?";
		int result;
		try{
			Object[] param = {zhangWu.getFlname(),zhangWu.getMoney(),zhangWu.getZhanghu(),
					zhangWu.getCreatetime(),zhangWu.getDescription(),zhangWu.getZwid()};
			result = qr.update(sql, param);
			return result;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("数据处理失败");
		}
	}
	
	/**
	 * 添加账务
	 * @param zhangWu
	 * @return
	 */
	public int addZhangWu(ZhangWu zhangWu){
		
		String sql = "INSERT INTO gjp_zhangwu(flname,money,zhanghu,createtime,description) VALUES(?,?,?,?,?)";
		int result;
		try{
			Object[] param = {zhangWu.getFlname(),zhangWu.getMoney(),zhangWu.getZhanghu(),
					zhangWu.getCreatetime(),zhangWu.getDescription()};
			result = qr.update(sql, param);
			return result;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("数据插入失败");
		}
		
	}
	
	/**
	 * 查询所有的账户数据
	 * @return
	 */
	public List<ZhangWu> selectZhangWu(){
		String sql  = "SELECT * from gjp_zhangwu";
		List<ZhangWu> result;
		try {
			result = qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class));
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("数据查询错误");
		}
		
	}
	
	/**
	 * 根据时间查询账户
	 * @param start
	 * @param end
	 * @return
	 */
	public List<ZhangWu> select(String start,String end){
		String sql = "SELECT * from gjp_zhangwu where createtime " +
				"BETWEEN ? and ?";
		List<ZhangWu> result;
		Object[] para = {start,end};
		try{
			result = qr.query(sql,new BeanListHandler<ZhangWu>(ZhangWu.class), para);
			return result;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("数据查询错误");
		}
		
		
	}

}
