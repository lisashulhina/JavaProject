public class Item
{
    private final int itemNumber;
    private final int quantity;
    private final int binNumber;
    private final boolean inStock;
    private final String name;
    private final double price;

    // constructor
    public Item(int itemNumber, int quantity, int binNumber, boolean inStock, String name, double price)
    {
        this.itemNumber = itemNumber;
        this.quantity = quantity;
        this.binNumber = binNumber;
        this.inStock = inStock;
        this.name = name;
        this.price = price;
    }

    public int getItemNumber()
    {
        return itemNumber;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public int getBinNumber()
    {
        return binNumber;
    }

    public boolean getInStock()
    {
        return inStock;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }
}