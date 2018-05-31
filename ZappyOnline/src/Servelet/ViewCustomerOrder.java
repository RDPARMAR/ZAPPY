package Servelet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.OrderBean;
import Bean.placedorderbean;
import Dao.MyDao;

/**
 * Servlet implementation class ViewCustomerOrder
 */
@WebServlet("/ViewCustomerOrder")
public class ViewCustomerOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCustomerOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderid=request.getParameter("oid");
		HttpSession hs = request.getSession();
		String user = (String)hs.getAttribute("email");
		ArrayList<OrderBean> al = new MyDao().viewCustomerOrder(user, orderid);
		
	
			
		
		/*int count=0;
		String cnt=null;
		if(user!=null) {
		count = md.count(user);
		cnt=String.valueOf(count);
		System.out.println(count+" "+user);
		}else {
			String ip = md.ipAdd();
			count = md.count(ip);
			cnt=String.valueOf(count);
			System.out.println(count+" "+ip);
		}*/
		if(al!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("CustomerOrderDetail.jsp"); 
			request.setAttribute("data", al);
			/*request.setAttribute("count", cnt);*/
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
