package com.wz.servletDemo.servlet;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.servletDemo.dao.UserMapper;
import com.wz.servletDemo.dao.interfaceImpl.UserMapperImpl;
import com.wz.servletDemo.entity.User;

/**
 * 
 * @author x.wang
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String methodName = request.getParameter("method");
		boolean rightRequest = false;
//		MysqlConnection instance = MysqlConnection.getInstance();
//		 @SuppressWarnings("static-access")
//		String valueByKey = instance.getValueByKey("jdbc.driver_class");
		if(methodName!=null && !"".equals(methodName)){
			rightRequest = true;
		}
		if(rightRequest ){
			if(methodName.equals("index")){
				index(request,response);
			}
			if(methodName.equals("test")){
				test(request,response);
			}
		}
		
	}
	/**
	 * ��ҳ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("servlet 复习 ");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		 
	}
	
	public void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//servlet中获取服务器当前路径
		ServletContext path = getServletContext();
		String path_url = path.getRealPath("/");
		//获取Class文件的绝对路径
		URL resource = AdminServlet.class.getClassLoader().getResource("/");
		UserMapper userdao = new UserMapperImpl();
		//int i = userdao.deleteUser();
		//userdao.insertUser();
		//int i = userdao.updateUser();
		ArrayList<User> list = userdao.findUser();
		//System.out.println("servlet test "+path_url+"========url"+resource.getPath());
		request.getRequestDispatcher("jsp/test.jsp").forward(request, response);
	}
}
