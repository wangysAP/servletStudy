/**
 * 
 */
package com.wz.servletDemo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;

/**
 * MYSQL JDBC 
 * 使用单例模式：外部无法创建实例，实例对象由自己提供，确保系统中只有一个实例。
 * @author x.wang
 * @date  2018年1月22日
 */
public class MysqlConnection {
	private static MysqlConnection mySqlConnection ;
	private static Properties pro ;
	
	/**
	 * 将构造方法指定为private ，保证外部无法实例化对象。默认的构造方法是public。 
	 */
	private MysqlConnection (){
		pro = new Properties();
		//获取数据库连接配置文件的路径
		ClassLoader load = MysqlConnection.class.getClassLoader();
		//String path = load.getResource("/config/"+Constant.MYSQL_FILE_NAME).getPath();
		InputStream resourceAsStream = load.getResourceAsStream("/config/"+Constant.MYSQL_FILE_NAME);
		try {
			pro.load(resourceAsStream);
			resourceAsStream.close();
		} catch (IOException e) {
			System.out.println("read mysql.properties exception");
			e.printStackTrace();
		}
		
	}
	/**
	 * 对外访问的接口
	 * @return MysqlConnection
	 */
	public static MysqlConnection getInstance(){
		if(mySqlConnection==null){
			mySqlConnection = new MysqlConnection();
		}
		return mySqlConnection;
	}
	/**
	 * 根据key获取配置文件中的值
	 * @param key
	 * @return
	 */
	public static String getValueByKey(String key){
		return pro.getProperty(key);
	}
	/**
	 * 对外接口，直接返回数据库连接类
	 * @return
	 */
	public static Connection getMySqlConnection(){
		 
		Connection con = null ;
		try {
			//加载驱动
			Class.forName(getValueByKey("jdbc.driver_class"));
			con = (Connection) DriverManager.getConnection(getValueByKey("jdbc.connection.url"), getValueByKey("jdbc.connection.username"), getValueByKey("jdbc.connection.password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return con;
	}
	
}
