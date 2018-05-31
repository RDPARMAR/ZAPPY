package Servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.AddBean;
import Dao.MyDao;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();		
		String id=request.getParameter("pid");
try {		
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodzappy","root","");
     PreparedStatement ps=con.prepareStatement("delete from zfood where pid=?");
     ps.setInt(1, Integer.parseInt(id));
	  int x=ps.executeUpdate();
	  if(x!=0)
	  {
		  RequestDispatcher rd=request.getRequestDispatcher("ViewProduct.jsp");
		  ArrayList<AddBean> list = new MyDao().getAllBeanData();
		  request.setAttribute("data", list);
		  request.setAttribute("pid", "Product Deleted this="+id);
		  rd.forward(request,response);
	  }
		  //out.println(eid+" deleted");
     
     
     con.close();	   
		   
}catch(Exception e)
{
	out.println(e);
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
