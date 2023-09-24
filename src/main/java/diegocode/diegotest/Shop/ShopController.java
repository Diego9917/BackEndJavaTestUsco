package diegocode.diegotest.Shop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/auth/shop")
@RequiredArgsConstructor
public class ShopController {
    
    private final ShopService shopService;

    @PostMapping(value="newShop")
    public void createShop(@RequestBody Shop shop)
    {
         
        shopService.createShop(shop);

    }

    //ver todas las tiendas
    @PostMapping(value="allShops")
    public void getAllShops()
    {
         
        shopService.getAllShops();

    }
    
 
    

}
