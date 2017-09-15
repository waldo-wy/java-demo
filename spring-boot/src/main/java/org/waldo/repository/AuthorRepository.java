/**
 * @author waldo.wy
 * @date 2017/4/10
 */
package org.waldo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.waldo.entity.Author;

/**
 * 类AuthorRepository描述：
 *
 * @author waldo.wy 2017/4/10 16:30
 */
@Repository
//@Transactional(Transactional.TxType.REQUIRES_NEW)
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
