package diegocode.diegotest.Shop;




import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer>  {
    
      List<Shop> findAll();
     
    

}
