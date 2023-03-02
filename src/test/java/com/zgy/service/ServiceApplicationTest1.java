package com.zgy.service;

import com.zgy.domain.Book;
import com.zgy.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试Service层方法是否能够实现
 */
@SpringBootTest
public class ServiceApplicationTest1 {
    @Autowired
    BookService bookService;

    @Test
    void testById(){
        bookService.getById(2);
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据");
        book.setName("测试数据789");
        book.setDescription("测试数据789");
        bookService.save(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(10);
        book.setType("更新数据");
        book.setName("测试数据789");
        book.setDescription("测试数据789");
        bookService.update(book);
    }
    @Test
    void testDelete(){
        bookService.delete(12);
    }
    @Test
    void testGetAll(){
        bookService.getAll();
    }
    @Test
    void testPage(){
        bookService.getPage(1,2);
    }
    @Test
    void test(){
        String []sA={"0","1"};
        String []sA2={"0","1"};
        int rtn = 0;
        for (int i = 0; i < sA.length; i++) {
            for (int j = 0; j < sA2.length; j++) {
                boolean lxbz = false;
                if("0".equals(sA[i])  && "0".equals(sA2[j])){
                    lxbz = true;
                }
                if(!lxbz){
                    if("1".equals(sA[i])  && "1".equals(sA2[j])){
                        lxbz = true;
                    }
                }
                if(!lxbz){
                    if("0".equals(sA[i])){
                        lxbz = true;
                    }else {
                        continue;
                    }
                }
                if (lxbz){
                    rtn++;
                }
            }
        }
        System.out.println(rtn);
    }
}
