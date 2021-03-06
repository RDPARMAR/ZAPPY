package Servelet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Bean.AddBean;
import Dao.MyDao;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/UploadProduct")
public class UploadProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private String filePath;
	   private int maxFileSize = 1000 * 4096;
	   private int maxMemSize = 1000 * 4096;
	   private File file ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	  
	      String pn=null;
	      String p=null;
	     String wt=null;
	     String des=null;
	     String cat=null;
	     String filename=null;
	      
	      while ( i.hasNext())
	      {
	         FileItem fi = (FileItem)i.next();

	         if ( fi.isFormField () )
	         {
	            // Get the uploaded file parameters
	           String  fieldName = fi.getFieldName();
	           if(fieldName.equals("pname"))
	             {
	        	  pn=fi.getString();
	              System.out.println(pn);
	             }
	           if(fieldName.equals("price"))
	           {
	        	   p=fi.getString();
	            System.out.println(p);
	           }
	           if(fieldName.equals("weight"))
	           {
	        	   wt=fi.getString();
	            System.out.println(wt);
	           }
	           if(fieldName.equals("description"))
	           {
	        	   des=fi.getString();
	            System.out.println(des);
	           }
	           if(fieldName.equals("catagory"))
	           {
	        	   cat=fi.getString();
	            System.out.println(cat);
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
		
		AddBean b=new AddBean();
		b.setPname(pn);
		b.setPrice(p);
		b.setWeight(wt);
		b.setDescription(des);
		b.setCatagory(cat);
		b.setImage(filename);
		
		
		
		MyDao md=new MyDao();
		int x=md.AddProduct(b);
		if(x!=0) {
			RequestDispatcher rd=request.getRequestDispatcher("AdminHome.jsp");
			request.setAttribute("msg", "Add product Succesfully");
			rd.forward(request, response);
		}
		else {
			System.out.println("Sorry");
		
	
		
		}
	      }catch(Exception ex)
	      {
	          ex.printStackTrace();
	         out.println("file size is max");
	     }
	}
}