package inv;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public List<Inventory> catg1() {
        return this.repository.cat1();
    }
    public List<Inventory> catg2() {
        return this.repository.cat2();
    }
    public List<Inventory> catg33() {
        return this.repository.cat33();
    }
    public List<Inventory> catg44() {
        return this.repository.cat44();
    }
    public List<Inventory> catgn() {
        return this.repository.catgn();
    }
    public List<Inventory> catsn() {return this.repository.catsn();}
    public List<Inventory> catpm() {return this.repository.catpm();}
    public List<Inventory> catuk() {return this.repository.catuk();}
    public List<Inventory> catg55() {
        return this.repository.catg55();
    }

    public String updateItem(Integer id, String name, Integer categoryId, Integer price, String description, Integer count ,String location) {
        // Assuming you have a method named `update` in your repository for updating an inventory item
        return this.repository.update(id, name, categoryId, price, description, count,location);
    }

    public String CreateNewItem(Integer id, String name, Integer categoryId, Integer price, String description, Integer count, String location){
        return this.repository.insert(id, name, categoryId, price, description, count,location);
    }
    public String UpdateItem(Integer id, String name, Integer categoryId, Integer price, String description, Integer count, String location){
        return this.repository.update(id, name, categoryId,price, description, count,location);
    }
    public String createNewItem(Inventory item) {return "null";}
    public String getOneItem(Integer id) {
        return "null";
    }
    public String deleteOrder(int id) {
        return this.repository.findById(id);
    }
    public String incrementCount(int id){
        return this.repository.increment(id);
    }
    public String descrementCount(int id){
        return this.repository.descrement(id);
    }


    /*public String SearchOrder(String data) {
        return this.repository.toString(data);
    }*/
}

