package com.zgy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zgy.domain.Book;
import com.zgy.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试Service层方法是否能够实现
 */
@SpringBootTest
public class ServiceApplicationTest2 {
    @Autowired
    IBookService iBookService;

    @Test
    void testById(){
        iBookService.getById(2);
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据");
        book.setName("测试数据789");
        book.setDescription("测试数据789");
        iBookService.save(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(13);
        book.setType("更新数据");
        book.setName("测试数据7");
        book.setDescription("测试数据7");
        iBookService.updateById(book);
    }
    @Test
    void testDelete(){
        iBookService.removeById(13);
    }
   @Test
    void testGetAll(){
        iBookService.list();
    }
    @Test
    void testPage(){
        IPage<Book> iPage = new Page<Book>(1,5);
        iBookService.page(iPage);
        iPage.getPages();
        iPage.getTotal();
        iPage.getCurrent();
        iPage.getSize();
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
