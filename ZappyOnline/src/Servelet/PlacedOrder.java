package Servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.AddBean;
import Bean.placedorderbean;
import Dao.MyDao;


/**
 * Servlet implementation class PlacedOrder
 */
@WebServlet("/PlacedOrder")
public class PlacedOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlacedOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		HttpSession hs = request.getSession();
		String user = (String)hs.getAttribute("email");
		String address=null;
		String orderid=null;
		String amount="";
		String date=null;
		MyDao md=new MyDao();
		int x=md.order(user);
		ArrayList<placedorderbean> p = new MyDao().placedorder(user);
		for(placedorderbean b : p) {
			orderid=b.getOid();
			address=b.getAddress();
			amount=b.getAmmount();
			System.out.println("My amount is brabar : "+amount);
			date=b.getDate();
			
		}
		/*MyDao md = new MyDao();
		int count=0;
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
		
		if(user==null) {
			/*response.sendRedirect("register.jsp");*/
			user=new MyDao().ipAdd();
			response.sendRedirect("register.jsp");
			 System.out.println("ippppppppppppppppppp"+user);
				}
				
	
		
			
			
		
			
		if(x!=0) {
			
				String to = user;
			      String sub="your Order is confirmed";
			      String msg=" Hi "+user+",\r\n" + 
			      		"\r\n" + 
			      		"We've got it! We'd like to confirm your order, the details of which are below. We will be sending Email Alerts about your order delivery status on your registered Email Address.\r\n" + 
			      		"  	\r\n" + 
			      		"Your order will be send to:\r\n" + 
			      		"\r\n" + 
			      		address+"\r\n"
			      				+ "\r\n"
			      				+ " 	\r\n" +""
			      						+ "\r\n"
			      						+ "Order Id:-"+orderid+"\r\n"+ 
			      				"Subtotal :-	"+amount+"\r\n" + 
			      				"Shipping Charges 	Free\r\n" + 
			      				"Convenience Charges 	Free\r\n" + 
			      				"	 \r\n" + 
			      				"Total 	 "+amount+"\r\n" + 
			      				"	 ";
			      
			      		
			      // Sender's email ID needs to be mentioned
			      String from = "decentboyakash@gmail.com";
			      final String username = "decentboyakash@gmail.com";//change accordingly
			      final String password = "9589999334";//change accordingly

			      // Assuming you are sending email through relay.jangosmtp.net
			      String host = "smtp.gmail.com";

			      Properties props = new Properties();
			      props.put("mail.smtp.auth", "true");
			      props.put("mail.smtp.starttls.enable", "true");
			      props.put("mail.smtp.host", host);
			      props.put("mail.smtp.port", "587");

			      // Get the Session object.
			      Session session = Session.getInstance(props,
			      new javax.mail.Authenticator() {
			         protected PasswordAuthentication getPasswordAuthentication() {
			            return new PasswordAuthentication(username, password);
			         }
			      });

			      try {
			         // Create a default MimeMessage object.
			         Message message = new MimeMessage(session);

			         // Set From: header field of the header.
			         message.setFrom(new InternetAddress(from));

			         // Set To: header field of the header.
			         message.setRecipients(Message.RecipientType.TO,
			         InternetAddress.parse(to));

			         // Set Subject: header field
			         message.setSubject(sub);

			         // Now set the actual message
			         message.setText(msg);

			         // Send message
			         
			         Transport.send(message);
			        /*RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					request.setAttribute("msg", "Your Password Has Been Sent To Your Email Address");
					request.setAttribute("pagename1","Index" );
					rd.forward(request, response);*/
			         } catch (MessagingException e) {
			    	  e.printStackTrace();
			         }
			RequestDispatcher rd = request.getRequestDispatcher("PlacedOrder.jsp");
			request.setAttribute("data", p);
			System.out.println(">>>>>>>>>>>>>>>>>>>>"+p);
			request.setAttribute("msg", "Confirmation Email Has Been Sent to Your Email Address");
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
