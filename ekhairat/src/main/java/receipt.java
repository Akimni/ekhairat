
public class receipt {
	
	String receiptID;
	String memberID;
	String receiptdatentime;
	double totalAmount;
	
	public String setreceiptID() {
		return receiptID;
	}
	public void getreceiptID(String receiptID) {
		this.receiptID=receiptID;
	}
	public String setmemberID() {
		return memberID;
	}
	public void getmemberID(String memberID) {
		this.memberID=memberID;
	}
	public String setreceiptdatentime() {
		return receiptdatentime;
	}
	public void getreceiptdatentime(String receiptdatentime) {
		this.receiptdatentime = receiptdatentime;
	}
	public double settotalAmount() {
		return totalAmount;
	}
	public void gettotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
