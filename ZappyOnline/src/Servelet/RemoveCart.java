package Servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.MyDao;

/**
 * Servlet implementation class RemoveCart
 */
@WebServlet("/RemoveCart")
public class RemoveCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession hs = request.getSession();
		String pid = request.getParameter("pid");
		String user = (String) hs.getAttribute("email");
		
		
		if (user != null) {
			int y = new MyDao().removeItemfromCart(user, pid);
			if (y != 0) {
				response.sendRedirect("ShowCart");
			} else {
				response.sendRedirect("ShowCart");
			}
		} else {
			String ip = new MyDao().ipAdd();
			int y = new MyDao().removeItemfromCart(user, pid);
			if (y != 0) {
				response.sendRedirect("ShowCart");
			} else {
				response.sendRedirect("ShowCart");
			}
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
