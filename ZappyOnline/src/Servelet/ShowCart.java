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

import Bean.AddBean;
import Dao.MyDao;

/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/ShowCart")
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		MyDao cd = new MyDao();
        HttpSession hss = request.getSession();
        String user = (String) hss.getAttribute("email");
        System.out.println("gvfdjitkdjfdn"+user);
        if(user!=null){
            ArrayList<AddBean> i = cd.ShowCart(user);
            RequestDispatcher rd = request.getRequestDispatcher("ShowCart1.jsp");
            request.setAttribute("data", i);
            rd.forward(request, response);
        }else if(user==null){

String ip = cd.ipAdd();
ArrayList<AddBean> i = cd.ShowCart(ip);

RequestDispatcher rd = request.getRequestDispatcher("ShowCart1.jsp");
request.setAttribute("data", i);
rd.forward(request, response);

    

        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
