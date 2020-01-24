package com.king.caching.runner;

import com.king.caching.controller.BookController;
import com.king.caching.mapper.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
public class AppRunner implements CommandLineRunner {

    private final BookRepository bookRepository;

    public AppRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("... fetch books");
        BookController.logTestBooks(log, bookRepository);
    }

}
