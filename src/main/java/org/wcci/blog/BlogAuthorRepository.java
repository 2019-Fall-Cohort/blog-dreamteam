
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogAuthorRepository extends CrudRepository<BlogAuthor, Long> {

}
