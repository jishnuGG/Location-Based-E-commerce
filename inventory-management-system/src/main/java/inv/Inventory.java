package inv;

public class Inventory {
    private String location;
    private int id;
    private String name;
    private int category_id;
    private int price;
    private String description;

  private String category_name;
    private int count;



    public Inventory(int id, String name, String category_name, int category_id, int price, String description, int count, String location){
        this.id=id;
        this.name=name;
        this.description=description;
        this.count=count;
        this.category_name=category_name;
        this.category_id=category_id;
        this.price=price;
        this.location=location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public  Inventory(String name, String categoryName, int price, int count) {
        this.name=name;
        this.category_name=categoryName;
        this.price=price;
        this.count=count;


    }

    public int getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    public void setLocation() {
        this.location= location;
    }
    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Inventory{" +

                "id=" + id +
                ", name='" + name + '\'' +
                ", category_id=" + category_id +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category_name='" + category_name + '\'' +
                ", count=" + count + '\''+"location='" + location  +
                '}';
    }
}
