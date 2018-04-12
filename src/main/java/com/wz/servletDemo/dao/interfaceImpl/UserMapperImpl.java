/**
 * 
 */
package com.wz.servletDemo.dao.interfaceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.wz.servletDemo.dao.UserMapper;
import com.wz.servletDemo.entity.User;
import com.wz.servletDemo.utils.MysqlConnection;

/**
 * @author x.wang
 * @date  2018年1月22日
 */
public class UserMapperImpl implements UserMapper {
	
	 
	/* (non-Javadoc)
	 * @see com.wz.servletDemo.dao.UserMapper#insertUser()
	 */
	public Integer insertUser() {
		// TODO Auto-generated method stub
		MysqlConnection.getInstance();
		//获取连接
		Connection con = MysqlConnection.getMySqlConnection();
		
		int i =0;
		//sql
		String sql = "insert into t_organize_user(loginName,userName,password) values(?,?,?)" ;
		//预编译SQL
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = con.prepareStatement(sql);
			prepareStatement.setString(1, "servlet-test");
			prepareStatement.setString(2, "testusername");
			prepareStatement.setString(3, "servlet-test-pwd");
			i = prepareStatement.executeUpdate();
			prepareStatement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return i;
	}

	/* (non-Javadoc)
	 * @see com.wz.servletDemo.dao.UserMapper#deleteUser()
	 */
	public Integer deleteUser() {
		// TODO Auto-generated method stub
		MysqlConnection.getInstance();
		//获取连接
		Connection con = MysqlConnection.getMySqlConnection();
		
		int i =0;
		//sql
		String sql = "delete from  t_organize_user where  loginName like ?" ;
		
		//预编译SQL
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = con.prepareStatement(sql);
			prepareStatement.setString(1, "%servlet-test%");
			i = prepareStatement.executeUpdate();
			prepareStatement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see com.wz.servletDemo.dao.UserMapper#findUser()
	 */
	public ArrayList<User> findUser() {
		ArrayList<User> list = new ArrayList<User>();
		// TODO Auto-generated method stub
		MysqlConnection.getInstance();
		//获取连接
		Connection con = MysqlConnection.getMySqlConnection();
		
		int i =0;
		//sql
		String sql = "select loginName from  t_organize_user " ;
		
		//预编译SQL
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = con.prepareStatement(sql);
			ResultSet executeQuery = prepareStatement.executeQuery();
			while(executeQuery.next()){
				String loginname = executeQuery.getString(1);
				User u = new User();
				u.setLoginName(loginname);
				list.add(u);
			}
			prepareStatement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.wz.servletDemo.dao.UserMapper#updateUser()
	 */
	public Integer updateUser() {
		// TODO Auto-generated method stub
		MysqlConnection.getInstance();
		//获取连接
		Connection con = MysqlConnection.getMySqlConnection();
		
		int i =0;
		//sql
		String sql = "update  t_organize_user  set loginName = ? where id = ?" ;
		
		//预编译SQL
		PreparedStatement prepareStatement = null;
			try {
				prepareStatement = con.prepareStatement(sql);
				prepareStatement.setString(1, "ffpa1");
				prepareStatement.setLong(2, 299);
				i = prepareStatement.executeUpdate();
				prepareStatement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 
		return i;
	}

}
