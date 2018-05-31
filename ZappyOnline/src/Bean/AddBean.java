package Bean;

public class AddBean {
	int pid;
	String pname;
	String price;
	String weight;
	String description;
	String catagory;
	String image;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	int cid;
	String quantity;
	String user;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int id) {
		this.pid = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	@Override
	public String toString() {
		return "AddBean [pid=" + pid + ", pname=" + pname + ", price=" + price + ", weight=" + weight + ", description="
				+ description + ", catagory=" + catagory + ", image=" + image + "]";
	}
	
	
	
}
