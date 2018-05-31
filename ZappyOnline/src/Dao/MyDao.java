package Dao;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.AddBean;

import Bean.CustomerBean;
import Bean.placedorderbean;
import Connection.Connect;
import Bean.placedorderbean;
import Dao.MyDao;
import Servelet.PlacedOrder;
import Bean.OrderBean;

import sun.security.x509.IPAddressName;


public class MyDao {

	public int AdminLogin(String u, String p) {
		int x=0;
		
		Connect c=new Connect();
		Connection con=c.start();
		try{
			PreparedStatement ps=con.prepareStatement("select * from admin where EmailId=? and Password=?");
			ps.setString(1, u);
			ps.setString(2, p);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				x=1;
				return x;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	
		
		return x;
		}
	
	
	
	public int AddProduct(AddBean b) {
		int x=0;
		try {		
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodzappy","root","");
		       PreparedStatement ps=con.prepareStatement("insert into zfood(pname,price,weight,description,catagory,image)values(?,?,?,?,?,?)");
		       ps.setString(1, b.getPname());
		       ps.setString(2, b.getPrice());
		       ps.setString(3, b.getWeight());
		       ps.setString(4, b.getDescription());
		       ps.setString(5, b.getCatagory());
		       ps.setString(6, b.getImage());
		       
		       x=ps.executeUpdate();
		       con.close(); 
		       
	}catch(Exception e) {
		System.out.println(e);
	}
		return x;
	}
	 
	public ArrayList<AddBean>  getAllBeanData()
	{
		ArrayList<AddBean> ar=new ArrayList<>();
		
		
		try {	
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodzappy","root","");
		        PreparedStatement ps=con.prepareStatement("select * from zfood");
			   ResultSet rs=ps.executeQuery();
			   while(rs.next()) {
				   AddBean b=new AddBean();
				   b.setPid(rs.getInt("pid"));
				   b.setPname(rs.getString("pname"));
				   b.setPrice(rs.getString("price"));
				   b.setWeight(rs.getString("weight"));
				   b.setDescription(rs.getString("description"));
				   b.setCatagory(rs.getString("catagory"));
				   b.setImage(rs.getString("image"));
				   
				   ar.add(b);
				   
				   }
			   con.close();
			   }
		catch(Exception e) {
    	 System.out.println(e);
    	 }
		return ar;
     }
	
	
	public int UpdateProduct(AddBean b) {
		
		int x=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/foodzappy", "root", "");//place holder=?
		PreparedStatement ps=con.prepareStatement("update zfood set pname=?,price=?,weight=?,description=?,catagory=? where pid=?");
		ps.setString(1, b.getPname());
		ps.setString(2, b.getPrice());
		ps.setString(3, b.getWeight());
		ps.setString(4, b.getDescription());
		ps.setString(5, b.getCatagory());
		ps.setInt(6, b.getPid());
		x=ps.executeUpdate();
		if (x!=0) {
			x=1;
			return x;
		}
		 }catch(Exception e) {
	System.out.println(e);
}
	return x;
}
 
	public int EditImage(String pid,String b) {
		int x=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/foodzappy", "root", "");//place holder=?
		PreparedStatement ps=con.prepareStatement("update zfood set image=? where pid=?");
		ps.setString(1, b);
		ps.setString(2, pid);
		x=ps.executeUpdate();
		
		if(x!=0) {
			x=1;
			return x;
		}
		
}catch(Exception c) {
		System.out.println(c);
		}
		return x;
	}
	
	
	
	public AddBean Update(String pid) {
		AddBean b=new AddBean();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/foodzappy", "root", "");//place holder=?
			PreparedStatement ps=con.prepareStatement("select * from zfood where pid=?");
			ps.setString(1, pid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
			b.setPid(rs.getInt("pid"));
			b.setPname(rs.getString("pname"));
			b.setPrice(rs.getString("price"));
			b.setWeight(rs.getString("weight"));
			b.setDescription(rs.getString("description"));
			b.setCatagory(rs.getString("catagory"));
			b.setImage(rs.getString("image"));
			
			return b;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return b;
	}
	
/*public AddBean update(String pid) {
		AddBean b =null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/foodzappy", "root", "");//place holder=?
			PreparedStatement ps = con.prepareStatement("select * from zfood where pid=?");
			ps.setString(1, pid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String name=rs.getString(2);
				String price=rs.getString(3);
				String wt=rs.getString(4);
				String descrription = rs.getString(5);
				String catagory =rs.getString(6);
				String image =rs.getString(7);
				
				b = new Products
				
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return p;
	} */
		
	public int AddCart(int pid,int quantity,String user) {
		int x=0;
		Connect c=new Connect();
		Connection con=c.start();
		try{
			PreparedStatement ps = con.prepareStatement("update cart set quantity=quantity+? where pid=? and user=?");
			 ps.setInt(1, quantity);
			 ps.setInt(2, pid);
			 ps.setString(3, user);
			 x = ps.executeUpdate();
		
			if(x==0){
			PreparedStatement ps1=con.prepareStatement("insert into cart(pid,quantity,user) values(?,?,?)");
			ps1.setInt(1, pid);
			ps1.setInt(2, quantity);
			ps1.setString(3, user);
	x=	ps1.executeUpdate();
		con.close();
			}	
	}catch(Exception e) {
		
	System.out.println(e);
	}return x;
	
	}
	
	
	     
   
	
	

/*public ArrayList<CustomerBean> showCart(String ip) {
int x[]=new int[2];
ArrayList<CustomerBean> ar=new ArrayList<>();

Connect c=new Connect();
Connection con=c.start();
 try {
	    PreparedStatement ps=con.prepareStatement("SELECT products.pname,products.price,products.weight,products.image,products.pid,cart.userid,cart.quantity FROM products INNER JOIN cart ON products.pid = cart.pid where cart.userid=?");
	              ps.setString(1, ip);
		System.out.println(ps);   
				   ResultSet rs1=ps.executeQuery();
				   while(rs1.next())
				   {   
			           AddBean b=new AddBean();		   
					   int qty=rs1.getInt("quantity");
					   b.setPid(rs1.getInt("pid"));
					   b.setQuantity(qty);
					   b.setPname(rs1.getString("pname"));
					   b.setPrice(rs1.getInt("price"));
					   b.setWeight(rs1.getString("weight"));
					   b.setFilename(rs1.getString("image"));
					   
					   ar.add(e);
				   }
			     	con.close();	   
	   
		   }catch(SQLException ex)
			{
				ex.printStackTrace();
			}
 return ar;
}
*/
public String ipAdd() {
String  ipAddrs=null;
try {
	InetAddress	ipAddr=InetAddress.getLocalHost();
	ipAddrs=InetAddress.getLocalHost().toString();
} catch (UnknownHostException e) {
	
	e.printStackTrace();
}
return ipAddrs;
}

public int removeItemfromCart(String user,String pid) {
int x=0;
Connect c=new Connect();
Connection con=c.start();
try {
	System.out.println(pid);
	PreparedStatement ps=con.prepareStatement("delete from cart where pid=? and user=?");
    ps.setString(1, pid);
    ps.setString(2, user);
    x=ps.executeUpdate();
    
    
    if(x!=0) {
    	return x;
    }
}catch (SQLException e) {
	
	e.printStackTrace();
}
return x;
}

public static void main(String[] args) {
	System.out.println(new MyDao().ipAdd());
}	






	
	
	
public int Register(CustomerBean b) {
	int x=0;
	Connect c=new Connect();
	Connection con=c.start();
	try {
		PreparedStatement ps=con.prepareStatement("insert into register(username,email,mobile,password,address) values(?,?,?,?,?)");
		ps.setString(1,b.getUsername());
		ps.setString(2, b.getEmail());
		ps.setString(3, b.getMobile());
		ps.setString(4, b.getPassword());
		ps.setString(5, b.getAddress());
	 x=ps.executeUpdate();
	 
	if(x!=0) {
		return x;
	}	
		
		
	}catch(Exception e) {
		System.out.println(e);
	}
	return x;
	
	
}


/*public ArrayList<CustomerBean> getAllRegisterdata() {
	
ArrayList<CustomerBean> ar=new ArrayList<>()	;

try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodzappy", "root", "");
	PreparedStatement ps = con.prepareStatement("select * from regiter");
ResultSet rs=ps.executeQuery();
while(rs.next()) {
	CustomerBean b=new CustomerBean();
	b.setUsername(rs.getString("username"));
	b.setEmail(rs.getString("email"));
	b.setMobile(rs.getString("mobile"));
	b.setPassword(rs.getString("password"));
	 ar.add(b);
}
	con.close();




}catch(Exception a) {
	System.out.println(a);
}
return ar;
}
*/

public int CustomerLogin(String email,String password) {
	int x=0;
	Connect c=new Connect();
	Connection con =c.start();
	 try {
		 PreparedStatement ps=con.prepareStatement("select * from register where email=? and password=?");
		 ps.setString(1, email);
		 ps.setString(2, password);
		 
		ResultSet rs= ps.executeQuery();
		if(rs.next()) {
			
			
			x=1;
				return x;
		}
		 
	 }catch(Exception e) {
		 System.out.println(e);
	 }
	 return x;
	
	
}




public ArrayList<AddBean>  viewProduct()
{
	ArrayList<AddBean> ar=new ArrayList<>();
	
	
	try {	
		   Class.forName("com.mysql.jdbc.Driver");
		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodzappy","root","");
	        PreparedStatement ps=con.prepareStatement("select * from zfood");
		   ResultSet rs=ps.executeQuery();
		   while(rs.next()) {
			   AddBean b=new AddBean();
			   b.setPid(rs.getInt("pid"));
			   b.setPname(rs.getString("pname"));
			   b.setPrice(rs.getString("price"));
			   b.setWeight(rs.getString("weight"));
			   b.setDescription(rs.getString("description"));
			   b.setCatagory(rs.getString("catagory"));
			   b.setImage(rs.getString("image"));
			   
			   ar.add(b);
			   
			   }
		   con.close();
		   }
	catch(Exception e) {
	 System.out.println(e);
	 }
	return ar;
 }


public ArrayList<AddBean> ShowCart(String user) {
    ArrayList<AddBean> al = new ArrayList<>();
    Connect c=new Connect();
	Connection con =c.start();
    int x = 0;
    try {
        PreparedStatement ps = con.prepareStatement("select zfood.pname,zfood.price,zfood.weight,cart.quantity,cart.user,cart.pid,zfood.Image from zfood INNER JOIN cart ON zfood.pid=cart.pid where cart.user=?");
        ps.setString(1, user);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           AddBean b = new AddBean(); 
           b.setPname(rs.getString("pname"));
           b.setPrice(rs.getString("price"));
           b.setWeight(rs.getString("weight"));
           b.setQuantity(rs.getString("quantity"));
           b.setUser(rs.getString("user"));
           b.setPid(rs.getInt("pid"));
           b.setImage(rs.getString("image"));
           
      
      
            System.out.println(b);
            al.add(b);
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    return al;
}

/*public ArrayList<OrderBean> viewPendingOrder(String user, String oid) {
	ArrayList<OrderBean> al = new ArrayList<>();
	 Connect c=new Connect();
		Connection con =c.start();
	try {
		PreparedStatement ps = con
				.prepareStatement("SELECT oid,order1.pid,quantity,USER,STATUS,amount,DATE,image FROM order1 INNER JOIN zfood ON pid=order1.pid WHERE STATUS=? AND oid=? AND USER=?");
		ps.setString(1, "0");
		ps.setString(3, user);
		ps.setString(2, oid);
		System.out.println(oid + "My oid");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			OrderBean b = new OrderBean(rs.getString("oid"), rs.getString("pid"), rs.getString("quantity"),
					rs.getString("user"), rs.getString("status"), rs.getString("amount"), rs.getString("date"));
			b.setImage(rs.getString("image"));
			al.add(b);
			System.out.println("Zappy Order");
			System.out.println(b);
		}
		System.out.println("my skjocnj" + al);
	} catch (SQLException e) {
		System.out.println(e);
	}
	return al;
}*/




public int pendingStatus(String user, String oid) {
	 Connect c=new Connect();
		Connection con =c.start();
	int x = 0;
	try {
		PreparedStatement ps = con.prepareStatement("select status from order1 where oid=? and user=?");
		ps.setString(1, oid);
		ps.setString(2, user);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			if (!rs.getString(1).equals("0")) {
				PreparedStatement ps1 = con
						.prepareStatement("update placedorder set status = 1 where user = ? and oid=?");
				ps1.setString(1, user);
				ps1.setString(2, oid);
				x = ps1.executeUpdate();
			} else {
				PreparedStatement ps1 = con
						.prepareStatement("update placedorder set status = 0 where user = ? and oid=?");
				ps1.setString(1, user);
				ps1.setString(2, oid);
				x = ps1.executeUpdate();
			}
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	return x;
}

public int notAvailable(String user, String pid, String oid) {
	int x = 0;
	 Connect c=new Connect();
		Connection con =c.start();
	try {
		PreparedStatement ps = con.prepareStatement("update order1 set status=? where oid=?");
		ps.setString(1, "1");
		ps.setString(2,oid);
		
		x = ps.executeUpdate();
		
		
		System.out.println(x);
		/*if (x != 0) {
			x = new MyDao().pendingStatus(user, oid);*/
		
	
	} catch (Exception e) {
		System.out.println(e);
	}
	return x;
}

public int dispatch(String user, String pid, String oid) {
	int x = 0;
	 Connect c=new Connect();
		Connection con =c.start();
	try {
		PreparedStatement ps = con.prepareStatement("update order1 set status=? where oid=?");
		ps.setInt(1, 1);
		ps.setString(2, oid);
		x = ps.executeUpdate();
		System.out.println(x);
	} catch (Exception e) {
		System.out.println(e);
	}
	return x;
}



public  ArrayList<OrderBean>  allorder(String user, String pid, String oid) {
	ArrayList<OrderBean> al = new ArrayList<>();
	
	 Connect c=new Connect();
		Connection con =c.start();
	try {
		PreparedStatement ps = con.prepareStatement("select * from order1 where status NOT IN(0)");
		ResultSet rs = ps.executeQuery();
	if(rs.next()) {
		
		OrderBean b = new OrderBean(rs.getString("oid"), rs.getString("pid"), rs.getString("quantity"), rs.getString("amount"),rs.getString("status"),
				rs.getString("user"),  rs.getString("date"));
		
		al.add(b);
		System.out.println(al);
	}
	} catch (Exception e) {
		System.out.println(e);
	}
	return al;
}









public String ForgetPassword(String Email){
    
    int x = 0;
    Connect c=new Connect();
	Connection con =c.start();
    try {
    
        
        
        PreparedStatement ps = con.prepareStatement("select password from register where email= ?");
        
        ps.setString(1, Email);
        
        
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            String pass = rs.getString("password");
            return pass;
        }
        
        
        if(x!=0){
            
        System.out.println("your password forget");
        
        }else{
            System.out.println("Enter your Emailid");
        }
        
        
        
    } catch (SQLException e) {
            System.out.println(e);
    }
    return null;
}



public int order(String user) {
	Connect c=new Connect();
	Connection con =c.start();	 
	int x = 0;
	int y = 0;
	long z= System.currentTimeMillis();
	String oid = z+"";
	String oidd="O-ID  "+oid.substring(8);
	try {
		PreparedStatement ps = con.prepareStatement("select cart.quantity,cart.pid,zfood.price,register.address from cart INNER JOIN zfood ON cart.pid=zfood.pid INNER JOIN register ON register.email=cart.user where user = ? ");
		ps.setString(1, user);
		ResultSet rs = ps.executeQuery();
		int gttl=0;
		String address="myname";
		while (rs.next()) {
			String quantity = rs.getString(1);
			String pid = rs.getString(2);
			String price = rs.getString(3);
			address=rs.getString(4);
			int unit = Integer.parseInt(quantity);
			int rate = Integer.parseInt(price);
			int total = unit * rate;
			gttl=total+gttl;
	PreparedStatement ps1 = con.prepareStatement("insert into order1(pid,quantity,user,amount,oid,address) value(?,?,?,?,?,?) ");
		ps1.setString(1, pid);
			ps1.setString(2, quantity);
			ps1.setString(3, user);
			ps1.setInt(4, total);
			ps1.setString(5, oidd);
			ps1.setString(6, address);
			
			PreparedStatement ps2 = con.prepareStatement("delete from cart where user=?");
			ps2.setString(1, user);
			con.setAutoCommit(false);
			y = ps2.executeUpdate();
			x = ps1.executeUpdate();
			con.commit();
			
			z++;
		}
		
		PreparedStatement ps3 = con.prepareStatement("insert into placedorder (orderid,amount,user,address) values(?,?,?,?)");
		ps3.setString(1, oidd);
		ps3.setInt(2, gttl);		
		ps3.setString(3, user);
		ps3.setString(4, address);
		con.setAutoCommit(true);
		int r = ps3.executeUpdate();
		if (x != 0 && y != 0 && r!=0) {

			return x;
		
		}
		

	} catch (Exception e) {
		System.out.println(e);
	}
	return 0;
}












public ArrayList<placedorderbean> placedorder(String email) {
	ArrayList<placedorderbean> al = new ArrayList<>();
	Connect c=new Connect();
	Connection con =c.start();
	try {
		PreparedStatement ps = con.prepareStatement(/*"select  from placedorder where user=? and oid = ?");*/
 
				"SELECT placedorder.orderid,placedorder.status,placedorder.date,placedorder.amount,placedorder.address FROM placedorder INNER JOIN order1 ON placedorder.orderid=order1.oid  WHERE placedorder.user = ?");
		ps.setString(1, email);
		
		ResultSet rs = ps.executeQuery();
		placedorderbean p = new placedorderbean();
		while (rs.next()) {
				
			p.setOid(rs.getString(1));
			p.setAmmount(rs.getString(4));
			p.setStatus(rs.getString(2));
			p.setDate(rs.getString(3));
			p.setAddress(rs.getString(5));
			
			System.out.println("ooooooooooooooooooooooooooooooo"+p);
			
		}
		al.add(p);
		
	} catch (Exception e) {
		System.out.println(e);
	}
	return al;
}

public int count(String user) {

	Connect c=new Connect();
	Connection con =c.start();
	try {
		PreparedStatement ps = con.prepareStatement("select COUNT(user) FROM cart where user=?");
		ps.setString(1, user);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int x = rs.getInt(1);
			return x;
		}

	} catch (SQLException e) {
		System.out.println(e);
	}

	return 0;
}



public ArrayList<OrderBean> viewCustomerOrder(String user, String oid) {
	ArrayList<OrderBean> al = new ArrayList<>();
	Connect c=new Connect();
	Connection con = c.start();
	try {
		PreparedStatement ps = con.prepareStatement(
				"select order1.oid,order1.quantity,order1.status,order1.amount,order1.date,zfood.image,zfood.pid from order1 INNER JOIN zfood ON order1.pid=zfood.pid where user=? and pid=?");
		ps.setString(1, user);
		ps.setString(2, oid);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			OrderBean b=new OrderBean();
			b.setOid(rs.getString(1));
			b.setQuantity(rs.getString(2));
			b.setStatus(rs.getString(3));
			b.setAmount(rs.getString(4));
			b.setDate(rs.getString(5));
			b.setImage(rs.getString(6));
			b.setPid(rs.getString(7));
			al.add(b);
		}
		for (OrderBean b : al) {
			System.out.println(b);
		}
	} catch (SQLException e) {
		System.out.println(e);
	}
	return al;
}


public ArrayList<OrderBean> viewAllOrders() {
	ArrayList<OrderBean> al = new ArrayList<>();
	Connect c=new Connect();
	Connection con = c.start();
	try {
		PreparedStatement ps = con.prepareStatement("select * from order1");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			OrderBean b = new OrderBean(rs.getString("oid"), rs.getString("pid"), rs.getString("quantity"),
					 rs.getString("status"), rs.getString("date"), rs.getString("amount"),rs.getString("user"));
			al.add(b);
			System.out.println(b.getOid()+"   "+b.getPid()+"   "+b.getQuantity()+"   "+b.getAmount()+"   "+b.getDate()+"   "+b.getStatus()+"  "+b.getUser());
		}
		
	} catch (Exception e) {
		System.out.println(e);
	}

	return al;
}




}

