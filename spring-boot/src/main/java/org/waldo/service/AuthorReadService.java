/**
 * @author waldo.wy
 * @date 2017/4/12
 */
package org.waldo.service;

import org.waldo.entity.Author;

import java.util.List;

/**
 * 类AuthorReadService描述：
 *
 * @author waldo.wy 2017/4/12 16:24
 */
public interface AuthorReadService {

    List<Author> findSimilarAuthorByKeywords(String keywords);

    Author findAuthor(Long id, boolean needBooks);

}
