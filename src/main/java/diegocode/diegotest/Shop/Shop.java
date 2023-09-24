package diegocode.diegotest.Shop;

import java.util.List;

import diegocode.diegotest.User.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "shops", uniqueConstraints = {@UniqueConstraint(columnNames = "shopName")} )
public class Shop {
    
    @Id
    @GeneratedValue
    Integer id;
    @Column(nullable = false)
    String shopName;
    String shopAddress;
    String shopPhone;
    String state;
    String representative;  
    String category;
    String subCategory;
    @OneToMany(mappedBy = "shop") // Nombre de la variable en la clase User
    private List<User> users;

}
