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
 * Servlet implementation class AddCart
 */
@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
		PrintWriter out =response.getWriter();
        String id=request.getParameter("pid");
        String qt=request.getParameter("quantity");
		int pid =Integer.parseInt(id);
		int qty=Integer.parseInt(qt);
		
		String ip=null;
		HttpSession hs=request.getSession();
		String user=(String)hs.getAttribute("email");
		if(user==null) {
		 user=new MyDao().ipAdd();
		 System.out.println("ippppppppppppppppppp"+user);
			}
			
	MyDao md=new MyDao();
	int x=md.AddCart(pid, qty, user);
	
		
		if (x!=0) {
			RequestDispatcher rd=request.getRequestDispatcher("ZappyProductStore");
			request.setAttribute("msg", "Item Added to Cart");
			rd.forward(request, response);

		}
		else {
			out.println("sorry");
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
