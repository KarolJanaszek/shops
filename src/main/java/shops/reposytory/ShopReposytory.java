package shops.reposytory;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import shops.model.Shop;

import java.util.List;

public interface ShopReposytory extends CrudRepository<Shop, Integer> {
    //extends CrudRepository dodaje nam metody pozwalające działać na bazie mySQL
    @Query(value = "SELECT * FROM shop s WHERE s.name = :name", nativeQuery = true)
    List<Shop> findShopByName(@Param("name") String name);
}
