
public class Sandwich {
	private String bread;
    private String[] vegetables;
    private String meat;
    private double price;

    public Sandwich(String bread, String[] vegetables, String meat, double price) {
        this.bread = bread;
        this.vegetables = vegetables;
        this.meat = meat;
        this.price = price;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String[] getVegetables() {
        return vegetables;
    }

    public void setVegetables(String[] vegetables) {
        this.vegetables = vegetables;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

