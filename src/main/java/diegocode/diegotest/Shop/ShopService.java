package diegocode.diegotest.Shop;


import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;
    
    public void createShop(Shop shop) 
    {
        shopRepository.save(shop);
    }

    public void updateShop(Shop shop) 
    {
        shopRepository.save(shop);
    }

    public void deleteShop(Integer id) 
    {
        shopRepository.deleteById(id);
    }

    public Shop getShop(Integer id) 
    {
        return shopRepository.findById(id).orElse(null);
    }

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    

    //@ para que solo los roles puedan hacer uso del sifguiente metodo
    

   
    



}
