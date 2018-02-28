package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import dao.UserDao;
import entity.User;

public class EditUserDatabaseServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public EditUserDatabaseServlet() {
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        UserDao user=new UserDao();
        User usup=new User();

		PrintWriter out = response.getWriter();

		if(request.getParameter("password").equals(request.getParameter("passwordconfirm"))==false){
			JOptionPane.showMessageDialog(null, "两次密码不一致");  
			HttpSession session = request.getSession(); 
			int userid=Integer.valueOf(session.getAttribute("userid").toString());
			usup.setUserid(userid);
	    	List<User> list = null;
	    	list = (List<User>)user.findById(usup.getUserid());
	    	request.setAttribute("list", list);
	    	response.sendRedirect("EditUserServlet");
		}else{
			HttpSession session = request.getSession(); 
			int userid=Integer.parseInt(session.getAttribute("userid").toString());
			usup.setUserid(userid);
			usup.setUsername(request.getParameter("username"));
	    	usup.setPassword(request.getParameter("password"));
	    	usup.setName(request.getParameter("name"));
	    	usup.setSex(request.getParameter("sex"));
	    	usup.setYear(request.getParameter("year"));
	    	usup.setMonth(request.getParameter("month"));
	    	
			user.UpdateUser(usup);

			response.sendRedirect("InformationServlet");
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
