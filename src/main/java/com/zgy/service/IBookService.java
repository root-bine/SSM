package com.zgy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zgy.domain.Book;

public interface IBookService extends IService<Book> {
    // 由于Mybatis-Plus中定义的分页方法过于复杂, 此处追加操作
//    IPage<Book> getPage(int current, int size);
    IPage<Book> getPage(int current, int size, Book book);
}
