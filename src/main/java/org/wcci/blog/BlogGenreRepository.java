package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BlogGenreRepository extends CrudRepository<BlogGenre, Long> {

}
