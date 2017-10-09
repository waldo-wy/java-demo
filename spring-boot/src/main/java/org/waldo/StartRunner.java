/**
 * @author waldo.wy
 * @date 2017/4/1
 */
package org.waldo;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.waldo.entity.Author;
import org.waldo.entity.Book;
import org.waldo.repository.AuthorRepository;
import org.waldo.repository.BookRepository;
import org.waldo.service.AuthorReadService;

/**
 * 类StartRunner描述： 这个方法会在应用程序启动后首先被调用。
 *
 * @author waldo.wy 2017/4/1 16:41
 */
@Order(100)
public class StartRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(StartRunner.class);

    @Autowired
    private DataSource          ds;

    @Autowired
    private BookRepository      bookRepository;

    // @Autowired
    @Resource
    private AuthorRepository    authorRepository;

    @Autowired
    private AuthorReadService   authorReadService;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("start done. Say hello!");
        logger.info("DataSource: " + ds);
        Author author = new Author("Waldo", "Wang");
        authorRepository.save(author); // 思考，这里可以不执行该语句，而是在save book的时候自动保存吗？ 不行，如果不保存，无法获取到关联键author_id
        bookRepository.save(new Book("01-1200704-4532", "新书第二期", author));
        logger.info("Number of books: " + bookRepository.count());
        logger.info("===============splitter============");
        authorReadService.findAuthor(1L, true);
    }

    // 此注释只能写在non-args的方法上
    @Scheduled(initialDelay = 5000, fixedRate = 10000)
    public void run() {
        logger.info("Number of books: " + bookRepository.count());
    }

}
