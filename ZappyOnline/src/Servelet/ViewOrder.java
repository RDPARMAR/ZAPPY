package Servelet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.OrderBean;
import Dao.MyDao;

/**
 * Servlet implementation class ViewOrder
 */
@WebServlet("/ViewOrder")
public class ViewOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("email");
		String pid= request.getParameter("pid");
		String oid= request.getParameter("oid");
		/*int x = new MyDao().dispatch(user, pid, oid);
		System.out.println(pid+" "+oid);
		if(x!=0) {
			request.setAttribute("Success", "orderis dispatched");
			RequestDispatcher rd=request.getRequestDispatcher("ViewAllOrder");
			rd.forward(request, response);*/
					/*response.sendRedirect("AllOrder.jsp");*/
					ArrayList<OrderBean> al = new MyDao().allorder(user, pid, oid);
					System.out.println(al);
					if(al!=null) {
					RequestDispatcher rd= request.getRequestDispatcher("AllOrder.jsp");
					request.setAttribute("orders", al);
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
