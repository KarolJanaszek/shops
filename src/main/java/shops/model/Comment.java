package shops.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private boolean cheap;
    private Double price;

    //One to One sprawia, że stworzy się klucz obcy o nazwie shop_id, która będzie osnosić się do tabeli shop.
    //Co daje OneToOne?
    //1) W sposób magiczny działa metoda .getShop(), która zwraca sklep do którego przypisany jest komentarz.
    @OneToOne
    private Shop shop;

    @Override
    public String toString() {
        return "Komentarz o nr: "+id+". "+description+" Wartość koszyka: "+price;
    }
}
