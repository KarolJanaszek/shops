package shops.reposytory;

import org.springframework.data.repository.CrudRepository;
import shops.model.Shop;

public interface ShopReposytory extends CrudRepository<Shop, Integer> {
    //extends CrudRepository dodaje nam metody pozwalające działać na bazie mySQL
}
