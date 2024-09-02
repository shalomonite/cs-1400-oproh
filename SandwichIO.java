import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class SandwichIO {
	 public static void writeOrderToFile(Order order) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orderline.txt", true))) {
	            String orderLine = order.getTimestamp() + " " + order.getCustomerName() + " " +
	                                order.getSandwich().getBread() + " " +
	                                String.join(",", order.getSandwich().getVegetables()) + " " +
	                                order.getSandwich().getMeat() + " $" +
	                                String.format("%.2f", order.getSandwich().getPrice());
	            writer.write(orderLine);
	            writer.newLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
