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

import Bean.CustomerBean;
import Dao.MyDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		
		CustomerBean b=new CustomerBean();
		b.setUsername(username);
		b.setEmail(email);
		b.setMobile(mobile);
		b.setPassword(password);
		b.setAddress(address);
		MyDao md=new MyDao();
		int x=md.Register(b);
	
			if(x!=0) {
				out.println("register");
				RequestDispatcher rd=request.getRequestDispatcher("CustomerLogin.jsp");
				request.setAttribute("msg", "register Succesfully");
				rd.forward(request, response);
			}
			else {
				out.println("Sorry");
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
