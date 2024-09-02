import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
	    private String customerName;
	    private Sandwich sandwich;
	    private String timestamp;

	    public Order(String customerName, Sandwich sandwich) {
	        this.customerName = customerName;
	        this.sandwich = sandwich;
	        this.timestamp = generateTimestamp();
	    }

	    private String generateTimestamp() {
	        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        Date date = new Date();
	        return dateFormat.format(date);
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public Sandwich getSandwich() {
	        return sandwich;
	    }

	    public void setSandwich(Sandwich sandwich) {
	        this.sandwich = sandwich;
	    }

	    public String getTimestamp() {
	        return timestamp;
	    }

	    public void setTimestamp(String timestamp) {
	        this.timestamp = timestamp;
	    }
	}
	
