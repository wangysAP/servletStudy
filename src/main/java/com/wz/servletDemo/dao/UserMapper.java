/**
 * 
 */
package com.wz.servletDemo.dao;

import java.util.ArrayList;

import com.wz.servletDemo.entity.User;

/**
 * @author x.wang
 * @date  2018年1月22日
 */
public interface UserMapper {
	public Integer insertUser() ;
	
	public Integer deleteUser() ;
	
	public ArrayList<User> findUser() ;
	
	public Integer updateUser() ;
	
	
}
