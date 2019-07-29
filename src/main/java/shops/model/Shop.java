package shops.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor //tworzy pusty konstruktor jeżeli nie istnieje (możemy go sami zrobić, ale nie wiadomo po co)
@AllArgsConstructor //construktor jeden ze wszytskimi argumentami
@Data //żeby mić gettery i settery, toStrinha, equals i hashCode
@Entity //tworzy tabele w mySQL
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //tworzy klucz główny gdzie ID będą w sposób automatyczny generowane za nas bez powtórek
    private Integer id;

    private String name;
    private String address;

    @Transient //sprawia że nie będzie kolumny w mySQL
    private String description;

    @Override
    public String toString() {
        return name + ": " + address;
    }

    @OneToMany(mappedBy = "shop") //"shop" odnosi się do "@OneToOne private Shop shop;" z klasy Comment.
    private List<Comment> comments = new ArrayList<>();
}
