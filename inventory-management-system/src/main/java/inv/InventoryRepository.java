package inv;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

@Repository
public class InventoryRepository {
    private final JdbcTemplate template;
    private final JdbcClient jdbcClient;
    private List<Inventory> orders = new ArrayList<>();
    public InventoryRepository(JdbcTemplate template, JdbcClient jdbcClient) {
        this.template = template;
        this.jdbcClient = jdbcClient;
    }
    public String findById(int id) {
        int row=jdbcClient.sql("DELETE FROM inventory WHERE id = :id")
                .param("id",id).update();
        if(row>0){

            return "redirect:/home";
        }else{
            return "error";
        }
    }
    public String increment(int id){
       List<Count> co =  jdbcClient.sql("SELECT count FROM inventory WHERE id = :id").param("id",id)
                .query((rs,rowNum)->new Count(
                        rs.getInt("count")
                )).list();
       int count=(co.get(0)).getCount();
        count++;
        int row=jdbcClient.sql("UPDATE inventory SET count = :count WHERE id=:id;")
                .params(Map.of("id",id,"count",count)).update();
        if(row>0){
            return "deleted_success";
        }
        else{
            return "error";
        }
    }
    public String descrement(int id){
        List<Count> co =  jdbcClient.sql("SELECT count FROM inventory WHERE id = :id    ").param("id",id)
                .query((rs,rowNum)->new Count(
                        rs.getInt("count")
                )).list();
        int count=(co.get(0)).getCount();
        count--;
        int row=jdbcClient.sql("UPDATE inventory SET count = :count WHERE id=:id;")
                .params(Map.of("id",id,"count",count)).update();
        if(row>0){
            return "deleted_success";
        }
        else{
            return "error";
        }
    }
    public List<Inventory> cat1() {
        return jdbcClient.sql("SELECT * FROM Inventory where category_id=1 ;")
                .query((rs, rowNum) -> new Inventory(
                        rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getString("category_name"),
                        rs.getInt("category_id"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getInt("count"),
                        rs.getString("Location")
                )).list();

    }
    public List<Inventory> cat2() {
        return jdbcClient.sql("SELECT * FROM Inventory where category_id=2 ;")
                .query((rs, rowNum) -> new Inventory(
                        rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getString("category_name"),
                        rs.getInt("category_id"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getInt("count"),
                        rs.getString("Location"))).list();
    }
    public List<Inventory> cat33() {
        return jdbcClient.sql("SELECT * FROM Inventory where category_id=3 ;")
                .query((rs, rowNum) -> new Inventory(
                        rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getString("category_name"),
                        rs.getInt("category_id"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getInt("count"),
                        rs.getString("Location"))).list();
    }
    public List<Inventory> cat44() {
        return jdbcClient.sql("SELECT * FROM Inventory where category_id=4;")
                .query((rs, rowNum) -> new Inventory(
                        rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getString("category_name"),
                        rs.getInt("category_id"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getInt("count"),
                        rs.getString("Location"))).list();
    }
    public List<Inventory> catg55() {
        return jdbcClient.sql("SELECT * FROM Inventory ;")
                .query((rs, rowNum) -> new Inventory(
                        rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getString("category_name"),
                        rs.getInt("category_id"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getInt("count"),
                        rs.getString("Location"))).list();
    }
    public String update(Integer id, String name, Integer categoryId, Integer price, String description, Integer count,String location) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql("UPDATE inventory " +
                        "SET name = :name, " +
                        "    category_id = :category_id, " +
                        "    category_name = CASE " +
                        "                      WHEN :category_id = 1 THEN 'stationary' " +
                        "                      WHEN :category_id = 2 THEN 'dress' " +
                        "                      WHEN :category_id = 3 THEN 'gadgets' " +
                        "                      WHEN :category_id = 4 THEN 'snacks' " +
                        "                      ELSE NULL " +
                        "                    END, " +
                        "    price = :price, " +
                        "    description = :description, " +
                        "    count = :count " +
                        "     Location = :location"+
                        "WHERE id = :id")
                .params(Map.of(
                        "id", id,
                        "name", name,
                        "category_id", categoryId,
                        "price", price,
                        "description", description,
                        "count", count,
                        "location", location

                ))
                .update();
    return "home";

    }
    public String insert(Integer id, String name, Integer categoryId, Integer price, String description, Integer count,String location) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql("INSERT INTO inventory(id, name, category_id,category_name,  price, description, count,location) " +
                        "VALUES (:id, :name, :category_id, " +
                        "CASE " +
                        "   WHEN :category_id = 1 THEN 'stationary' " +
                        "   WHEN :category_id = 2 THEN 'dress' " +
                        "   WHEN :category_id = 3 THEN 'gadgets' " +
                        "   WHEN :category_id = 4 THEN 'snacks' " +
                        "   ELSE NULL " +
                        "END, " +
                        ":price, :description, :count,:location)")
                .params(Map.of(
                        "id", id,
                        "name", name,
                        "category_id", categoryId,
                        "price", price,
                        "description", description,
                        "count", count,
                        "location", location
                ))
                .update();
        return "home";
    }
    public List<Inventory> catgn() {
        return jdbcClient.sql("SELECT name,category_name,price,count FROM Inventory where location='Gandhipuram';")
                .query((rs, rowNum) -> new Inventory(
                        rs.getString("name"),
                        rs.getString("category_name"),
                        rs.getInt("price"),
                        rs.getInt("count"))).list();
    }
    public List<Inventory> catsn() {
        return jdbcClient.sql("SELECT name,category_name,price,count FROM Inventory where location='Singanallur';")
                .query((rs, rowNum) -> new Inventory(
                        rs.getString("name"),
                        rs.getString("category_name"),
                        rs.getInt("price"),
                        rs.getInt("count"))).list();
    }
    public List<Inventory> catpm() {
        return jdbcClient.sql("SELECT name,category_name,price,count FROM Inventory where location='Peelamedu';")
                .query((rs, rowNum) -> new Inventory(
                        rs.getString("name"),
                        rs.getString("category_name"),
                        rs.getInt("price"),
                        rs.getInt("count"))).list();
    }
    public List<Inventory> catuk() {
        return jdbcClient.sql("SELECT name,category_name,price,count FROM Inventory where location='Ukkadam';")
                .query((rs, rowNum) -> new Inventory(
                        rs.getString("name"),
                        rs.getString("category_name"),
                        rs.getInt("price"),
                        rs.getInt("count"))).list();
    }
}
