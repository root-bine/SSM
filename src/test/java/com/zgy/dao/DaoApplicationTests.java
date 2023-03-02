package com.zgy.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zgy.dao.BookDao;
import com.zgy.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试Dao层数据方法是否能够实现
 */
@SpringBootTest
class DaoApplicationTests {
    @Autowired
    private BookDao bookDao;
    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(2));
    }

    @Test
    void testSave() {
        // 进行数据操作时,需要事先在 配置文件/实体类 中标明id增长方式, 否则会出现错误
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);
    }
    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(10);
        book.setType("更新数据");
        book.setName("测试数据456");
        book.setDescription("测试数据456");
        bookDao.updateById(book);
    }
    @Test
    void testDelete() {
        bookDao.deleteById(9);
    }
    @Test
    void testGetAll() {
        System.out.println(bookDao.selectList(null));
    }
    /*@Test
    void testGetPage() {
        // 设置分页的当前页、每页显示数据条数
        IPage<Book> iPage = new Page<>(1,5);
        bookDao.selectPage(iPage,null);
        // 当前页码
        System.out.println(iPage.getCurrent());
        // 当前页中的数据条数
        System.out.println(iPage.getSize());
        // 总共有多少条数据
        System.out.println(iPage.getTotal());
        // 总共有多少页
        System.out.println(iPage.getPages());
    }
    @Test
    void testGetBy1() {
        // 分页功能
        IPage<Book> iPage = new Page<>(1,5);
        // 按条件查询
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name","Spring");
        bookDao.selectPage(iPage,qw);
    }*/
    @Test
    void testGetBy() {
        String name = "Spring";
        IPage<Book> iPage = new Page<>(1,2);
        // 避免输入参数错误, 而造成无法访问数据库
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name!=null,Book::getName,name);
        bookDao.selectPage(iPage,lqw);

    }

}
