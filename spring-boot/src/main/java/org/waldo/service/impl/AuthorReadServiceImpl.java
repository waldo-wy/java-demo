/**
 * @author waldo.wy
 * @date 2017/4/12
 */
package org.waldo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.waldo.entity.Author;
import org.waldo.repository.AuthorRepository;
import org.waldo.service.AuthorReadService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 类AuthorReadServiceImpl描述：
 *
 * @author waldo.wy 2017/4/12 16:28
 */
@Service
//@Transactional
public class AuthorReadServiceImpl implements AuthorReadService {

    private static final Logger logger = LoggerFactory.getLogger(AuthorReadServiceImpl.class);

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> findSimilarAuthorByKeywords(String keywords) {
        return null;
    }

    @Override
    @Transactional
    public Author findAuthor(Long id, boolean needBooks) {
        Iterable<Author> authors = authorRepository.findAll();
        authors.forEach(at -> {
            logger.info("author: {}, publish books: {}", at, at.getBooks());
        });
        return null;
    }
}
