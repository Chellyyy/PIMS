package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import dao.UserDao;
import entity.User;

public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        UserDao user=new UserDao();
        User us=new User();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(user.findByUser(request.getParameter("username"))==true){
			JOptionPane.showMessageDialog(null, "用户名已存在");  
			response.sendRedirect("/PIMS/register.jsp");
		}else if(request.getParameter("username").equals("")||request.getParameter("password").equals("")){
			JOptionPane.showMessageDialog(null, "用户名或密码不能为空");  
			response.sendRedirect("/PIMS/register.jsp");
		}else if(request.getParameter("password").equals(request.getParameter("passwordconfirm"))==false){
			JOptionPane.showMessageDialog(null, "两次密码不一致"); 
			response.sendRedirect("/PIMS/register.jsp");
		}else{
			us.setUsername(request.getParameter("username"));
	    	us.setPassword(request.getParameter("password"));
	    	us.setName(request.getParameter("name"));
	    	us.setSex(request.getParameter("sex"));
	    	us.setYear(request.getParameter("year"));
	    	us.setMonth(request.getParameter("month"));
			user.addUser(us);
			response.sendRedirect("/PIMS/index.jsp");
			out.flush();
			out.close();
		}
    	

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
