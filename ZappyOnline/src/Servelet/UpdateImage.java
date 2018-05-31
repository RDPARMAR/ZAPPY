


package Servelet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Bean.AddBean;
import Dao.MyDao;

/**
 * Servlet implementation class UpdateImage
 */
@WebServlet("/UpdateImage")
public class UpdateImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private String filePath;
	   private int maxFileSize = 1000 * 4096;
	   private int maxMemSize = 1000 * 4096;
	   private File file ;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		  boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		  if( !isMultipart ){
	             return;
	      }
			  
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	      // maximum size that will be stored in memory
	      factory.setSizeThreshold(maxMemSize);
	      // Location to save data that is larger than maxMemSize.
	       // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      // maximum file size to be uploaded.
	      upload.setSizeMax( maxFileSize );

	      try{

	      // Parse the request to get file items.
	      List fileItems = upload.parseRequest(request);

	      // Process the uploaded file items
	      Iterator i = fileItems.iterator();
	  
	      String pid=null;
	      
	     String filename=null;
	      
	      while ( i.hasNext())
	      {

	         FileItem fi = (FileItem)i.next();
	         if ( fi.isFormField () )
	         {
	            // Get the uploaded file parameters
	           String  fieldName = fi.getFieldName();
	           if(fieldName.equals("pid"))
	             {
	        	  pid=fi.getString();
	              System.out.println(pid);
	             }
	
	         }
	         else
	          {    
	        	 String fieldName = fi.getFieldName();

	            if(fieldName.equals("file"))
	            {
	             ServletConfig sc=getServletConfig();
	            // String field=fi.getString();
	            // String contentType = fi.getContentType();
	             filename=fi.getName();
	              //boolean isInMemory = fi.isInMemory();
	              //long sizeInBytes = fi.getSize();

	              //create folder
	              File f = new File(sc.getServletContext().getRealPath("/")+"imgupload/") ;
	                 if(!f.exists())
	                	 f.mkdir();
	              // Write the file
	              file = new File(sc.getServletContext().getRealPath("/")+"imgupload/"+filename) ;
	               fi.write( file ) ;
	              out.println("Uploaded Filename: " +filename + "<br>");
	            System.out.println("PATH="+file.getPath());
	            }
	         }
	      
	      }
		
  
		      AddBean b = new AddBean();
				
				MyDao md =new MyDao();
				int x =md.EditImage(pid, filename);
				if(x!=0) {
					
					RequestDispatcher rd = request.getRequestDispatcher("ViewProduct.jsp");
					ArrayList<AddBean> list = new MyDao().getAllBeanData();
					request.setAttribute("data", list);
					request.setAttribute("msg", "Image Updated Successfully");
					rd.forward(request, response);
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("UpdateProduct.jsp");
					request.setAttribute("msg", "Process Failed");
					rd.forward(request, response);
			
				}
		}catch(Exception e ) {
			out.println(e);
			// Get the uploaded file parameters
	          
		}
		
		
		/*String name=request.getParameter("pname");
		String cat=request.getParameter("category");
		String rate=request.getParameter("price");
		String weight=request.getParameter("weight");
		String disc=request.getParameter("discription");*/
		
		
	}


		
		/*
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		String p=request.getParameter("p");
		String wt=request.getParameter("wt");
		String cat=request.getParameter("cat");
		String desc=request.getParameter("des");
		String filename=request.getParameter("filename");
		MyDao md=new MyDao();
		int x=0;//md.EditImage(pid);
		if(x!=0) {
			RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");
			request.setAttribute("msg", "update product Succesfully");
			rd.forward(request, response);
		}
		*/
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}