package Bean;

public class placedorderbean {

	

	String oid;
	String status;
	String date;
	String address;
	String ammount;
	String quantity;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAmmount(String ammount) {
		this.ammount = ammount;
	}
	public placedorderbean() {
		
	}
	
	public placedorderbean(String oid, String status, String address,String ammount,String date) {
		super();
		this.oid = oid;
		this.status =status;
		this.address = address;
		this.ammount=ammount;
		this.date = date;
		
	}
	

	@Override
	public String toString() {
		return "placedorderbean [oid=" + oid + ", status=" + status + ", date=" + date + ", address=" + address
				+ ", ammount=" + ammount + "]";
	}

	public placedorderbean(String oid,String date, String address) {
		this.oid = oid;
		this.date = date;
		this.address = address;
	
	}


	public String getOid() {
		return oid;
	}
	public String getDate() {
		return date;
	}
	public String getAddress() {
		return address;
	}

	

	public String getAmmount() {
		return ammount;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
