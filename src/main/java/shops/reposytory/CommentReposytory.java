package shops.reposytory;

import org.springframework.data.repository.CrudRepository;
import shops.model.Comment;

public interface CommentReposytory extends CrudRepository<Comment, Integer> {



}
