/**
 * @author waldo.wy
 * @date 2017/4/10
 */
package org.waldo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.waldo.entity.Book;

/**
 * 类BookRepository描述：
 *
 * @author waldo.wy 2017/4/10 16:30
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findBookByIsbn(String isbn);

}
