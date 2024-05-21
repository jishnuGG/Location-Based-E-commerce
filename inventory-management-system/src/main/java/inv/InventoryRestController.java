package inv;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.List;

    @Controller
    public class InventoryRestController {
        private final InventoryService inventoryService;
        @GetMapping("home")
        public String h(){
            return "home";
        }
        @GetMapping("go_admin")
        public String admin(){
            return "login";
        }
        @PostMapping("put")
        public String hello(){
            return "home";
        }
        @GetMapping("login")
        public String log() {
            return "home";
        }

        public InventoryRestController(InventoryService inventoryService) {
            this.inventoryService = inventoryService;
        }

        @GetMapping("edit1")
        public String gett(Model model) {
            model.addAttribute("Inventory", this.inventoryService.catg1());
            return "home";
        }
        @GetMapping("add/edit11")
        public String get(Model model) {
            model.addAttribute("Inventory", this.inventoryService.catg1());
            return "home";
        }

        @RequestMapping("edit2")
        public String get11(Model m1) {
            m1.addAttribute("Inventory", this.inventoryService.catg2());
            return "home";
        }
        @RequestMapping("add/edit22")
        public String get1(Model m1) {
            m1.addAttribute("Inventory", this.inventoryService.catg2());
            return "home";
        }
        @RequestMapping("edit3")
        public String get33(Model m33) {
            m33.addAttribute("Inventory", this.inventoryService.catg33());
            return "home";
        }
        @RequestMapping("add/edit33")
        public String get3(Model m33) {
            m33.addAttribute("Inventory", this.inventoryService.catg33());
            return "home";
        }
        @RequestMapping("edit4")
        public String get44(Model m44) {
            m44.addAttribute("Inventory", this.inventoryService.catg44());
            return "home";
        }
        @RequestMapping("edit55")
        public String get55(Model m44) {
            m44.addAttribute("Inventory", this.inventoryService.catg44());
            return "home";
        }
        @RequestMapping("add/edit44")
        public String get4(Model m44) {
            m44.addAttribute("Inventory", this.inventoryService.catg44());
            return "home";
        }

        @RequestMapping("about")
        public String about(){
            return "about";
        }
        @RequestMapping("add/edit55")
        public String get5(Model m55) {
            m55.addAttribute("Inventory", this.inventoryService.catg55());
            return "home";
        }

        // @GetMapping
        //  public List<Inventory> getAll() {
        //      return this.inventoryService.getAllItems();
        //  }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public String create(
                @RequestBody Inventory item
        ) {
            return this.inventoryService.createNewItem(item);
        }



        @GetMapping("orders/edit3")
        public String getcreateform() {
            return "new-order";
        }
        @PostMapping("delete/post")
        public String deleteOrder(
                @RequestParam("id") String id
        ) {
            return this.inventoryService.deleteOrder(Integer.parseInt(id));
        }
        @PostMapping("inc1")
        public String inc(@RequestParam("inv_id") String id){
            return this.inventoryService.incrementCount(Integer.parseInt(id));
        }
        @PostMapping("desc")
        public String desc(@RequestParam("desc_id") String id){
            return this.inventoryService.descrementCount(Integer.parseInt(id));
        }
        @PostMapping("add/post")
        public String trandb(@RequestParam("id") String id,
                             @RequestParam("name") String name,
                             @RequestParam("category_id") String category_id,
                             @RequestParam("price") String price,
                             @RequestParam("description") String description,
                             @RequestParam("count") String count ,@RequestParam("location") String location)

                            {

            return this.inventoryService.CreateNewItem(Integer.parseInt(id), name, Integer.parseInt(category_id), Integer.parseInt(price), description, Integer.parseInt(count),location);
        }

        @PostMapping("update/post")
        public String trandbc(@RequestParam("id") String id,
                              @RequestParam("name") String name,
                              @RequestParam("category_id") String category_id,
                              @RequestParam("price") String price,
                              @RequestParam("description") String description,
                              @RequestParam("count") String count,@RequestParam("location") String location ){

            return this.inventoryService.UpdateItem(Integer.parseInt(id), name,Integer.parseInt(category_id), Integer.parseInt(price), description, Integer.parseInt(count),location);

        }
        @GetMapping("user")
        public String h1(){
            return "user";
        }
        @RequestMapping("gn")
        public String gn(Model model) {
            model.addAttribute("Inventory", this.inventoryService.catgn());
            return "user";
        }
        @RequestMapping("sn")
        public String sn(Model model) {
            model.addAttribute("Inventory", this.inventoryService.catsn());
            return "user";
        }
        @RequestMapping("pm")
        public String pm(Model model) {
            model.addAttribute("Inventory", this.inventoryService.catpm());
            return "user";
        }
        @RequestMapping("uk")
        public String uk(Model model) {
            model.addAttribute("Inventory", this.inventoryService.catuk());
            return "user";
        }



    }


