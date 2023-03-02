package com.zgy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zgy.controller.utils.Result;
import com.zgy.domain.Book;
import com.zgy.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@RestController
@RequestMapping("/books")
public class BookControllerReal {
    @Autowired
    IBookService iBookService;

    // 查询所有
    @GetMapping
    public Result getAll() {
        Result result = new Result(true, iBookService.list());
        return result;
    }

    // 添加数据
    @PostMapping
    public Result save(@RequestBody Book book) throws IOException {
        if(book.getName().equals("123")) {
            throw new IOException();
        }
        boolean flag = iBookService.save(book);
        return new Result(flag,flag? "添加成功^_^" : "添加失败-_-!");
    }

    // 修改数据
    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = iBookService.updateById(book);
        return new Result(flag,flag? "修改成功^_^" : "修改失败-_-!");
    }

    // 删除数据
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        Result result = new Result(iBookService.removeById(id));
        return result;
    }

    // 查询单个数据
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Result result = new Result(true, iBookService.getById(id));
        return result;
    }
    /*// 分页操作
    @GetMapping("/{current}/{size}")
    public Result getByPage(@PathVariable int current, @PathVariable int size){
        IPage<Book> page = iBookService.getPage(current, size);
        if(current > page.getPages()){
            // page.getPages()的返回值为long,所以这里需要强转
            page = iBookService.getPage((int)page.getPages(), size);
        }
        Result result = new Result(true, page);
        return result;
    }*/
    // 分页操作 + 按条件查询【前端】
    @GetMapping("/{current}/{size}")
    public Result getByPage(@PathVariable int current, @PathVariable int size, Book book){
        System.out.println("参数=>"+book);
        IPage<Book> page = iBookService.getPage(current, size, book);
        if(current > page.getPages()){
            // page.getPages()的返回值为long,所以这里需要强转
            page = iBookService.getPage((int)page.getPages(), size, book);
        }
        Result result = new Result(true, page);
        return result;
    }
}
