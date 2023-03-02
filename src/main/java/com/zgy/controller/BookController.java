package com.zgy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zgy.domain.Book;
import com.zgy.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 表现层数据未统一
 */
// @RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    IBookService iBookService;

    // 查询所有
    @GetMapping
    public List<Book> getAll() {
        List<Book> list = iBookService.list();
        return list;
    }

    // 添加数据
    @PostMapping
    public Boolean save(@RequestBody Book book) {
        return iBookService.save(book);
    }

    // 修改数据
    @PutMapping
    public Boolean update(@RequestBody Book book) {
        return iBookService.updateById(book);
    }

    // 删除数据
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return iBookService.removeById(id);
    }

    // 查询单个数据
    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id) {
        return iBookService.getById(id);
    }
    // 分页操作
    @GetMapping("/{current}/{size}")
    public IPage<Book> getByPage(@PathVariable int current, @PathVariable int size){
        return iBookService.getPage(current,size, null);
    }
}
