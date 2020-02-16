package cn.itcast.gjp.tools;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JdbcUtil {
	
	private static BasicDataSource datasource = new BasicDataSource();
	
	static {
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/gjp?useUnicode=true&characterEncoding=UTF8");
		datasource.setUsername("root");
		datasource.setPassword("root");
		datasource.setInitialSize(10);
		datasource.setMaxActive(8);//最大连接数量
		datasource.setMaxIdle(5);//最大空闲数
		datasource.setMinIdle(1);//最小空闲
	}
	
	public static DataSource getDatasource(){
		return datasource;
	}
}
