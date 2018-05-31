package Servelet;

import java.io.IOException;
import java.io.PrintWriter;
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
import sun.print.PrinterJobWrapper;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//int pid=Integer.parseInt(request.getParameter("pid"));
	    PrintWriter out =response.getWriter();
		String pname=request.getParameter("pname");
		String p=request.getParameter("price");
		String wt=request.getParameter("weight");
		String des=request.getParameter("description");
		String cat=request.getParameter("catagory");
		//String filename=request.getParameter("")
		AddBean b=new AddBean();
		String pid=request.getParameter("pid");
		
		b.setPname(pname);
		b.setPrice(p);
		b.setWeight(wt);
		b.setDescription(des);
		b.setCatagory(cat);
	    b.setPid(Integer.parseInt(pid)); 	
		out.println(b);
		
		MyDao md=new MyDao();
		int x=md.UpdateProduct(b);
		
		if(x!=0) {
			RequestDispatcher rd=request.getRequestDispatcher("UpdateProduct.jsp");
			ArrayList<AddBean> list = new MyDao().getAllBeanData();
			request.setAttribute("msg", "update product Succesfully");
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
