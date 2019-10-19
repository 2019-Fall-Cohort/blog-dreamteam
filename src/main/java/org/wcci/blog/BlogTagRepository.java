package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogTagRepository extends CrudRepository<BlogTag, Long> {
	public Iterable<BlogTag> findAllByOrderByBlogTagNameAsc();
}
