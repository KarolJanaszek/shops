package shops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import shops.model.Comment;
import shops.model.Shop;
import shops.reposytory.ShopReposytory;

@Controller
public class ShopController {

    @Autowired //robimy to aby wygenerować klasę z generacjami metod dostępnych w interface CrudeReposytory, które teraz sa w interfejsie ShopReposytory.
    private ShopReposytory shopRepository;

    @GetMapping("/")
    public String home(ModelMap map){
        map.put("shops", shopRepository.findAll());
        map.put("shop", new Shop());
        return "home";
    }

    @PostMapping("/shops")
    public String create(@ModelAttribute Shop shop){
        shopRepository.save(shop);
        return "redirect:/";
    }

    @GetMapping("/shops/{id}")
    public String show(@PathVariable Integer id, ModelMap map){
        Shop shop = shopRepository.findById(id).get();
        map.put("shop", shopRepository.findById(id).get());
        Comment comment = new Comment();
        comment.setShop(shop);
        map.put("comment", comment);
        return "show";
    }


    @GetMapping("/search")
    public String search(@RequestParam String name, ModelMap redirectAttributes ){
        redirectAttributes.addAttribute("shops",shopRepository.findShopByName(name));

        if(shopRepository.findShopByName(name).size()>0)
        redirectAttributes.addAttribute("message", "Znalezione sklepy");
        else
            redirectAttributes.addAttribute("message", "Nie znaleziono sklepu");

        redirectAttributes.put("shop", new Shop());
        return "home";
    }
}
