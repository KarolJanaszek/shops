package shops.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@NoArgsConstructor
@Data
@Entity
public class Comment {

    private String description;
    private boolean cheap;
    private Double price;

    //One to One sprawia, że stworzy się klucz obcy o nazwie shop_id, która będzie osnosić się do tabeli shop
    @OneToOne
    private Shop shop;

}
