package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.IncomeDao;
import dao.ExpenseDao;
import entity.Expense;
import entity.Income;

public class FinanceInformationServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FinanceInformationServlet() {
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

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

        IncomeDao incomeDao=new IncomeDao();
        Income income=new Income();
        ExpenseDao expenseDao=new ExpenseDao();
        Expense expense=new Expense();
		HttpSession session = request.getSession(); 
		int userid=Integer.parseInt(session.getAttribute("userid").toString());
		income.setUserid(userid);
		expense.setUserid(userid);
    	List<Income> ilist = null;
    	ilist = (List<Income>)incomeDao.findById(income.getUserid());
    	request.setAttribute("ilist", ilist);
    	List<Expense> elist = null;
    	elist = (List<Expense>)expenseDao.findById(income.getUserid());
    	request.setAttribute("elist", elist);
    	float incomesum=incomeDao.SumIncome(userid);
    	request.setAttribute("incomesum", incomesum);
    	float expensesum=expenseDao.SumExpense(userid);
    	request.setAttribute("expensesum", expensesum);
    	float balance=incomesum-expensesum;
    	request.setAttribute("balance", balance);
		RequestDispatcher rd=request.getRequestDispatcher("/finance.jsp");
		rd.forward(request, response);
		
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
