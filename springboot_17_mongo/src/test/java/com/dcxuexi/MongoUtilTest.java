package com.dcxuexi;

import com.dcxuexi.dao.Book;
import com.dcxuexi.dao.UserDao;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/***
 * @Title MongoUtilTest
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/10/1 21:56
 * @Version 1.0.0
 */
@SpringBootTest
public class MongoUtilTest {

    @Autowired
    private MongoTemplate mongoTemplate;


    @BeforeEach
    void setUp() {
        System.out.println("================ 开始  ========================");
    }

    @AfterEach
    void tearDown() {
        System.out.println("================ 结束  ========================");
    }


    @Test
    void  testceshi(){
        System.out.println("testceshi");

        UserDao userDao = new UserDao();
        userDao.setId(2);
        userDao.setUserName("李四222");
        userDao.setAddress("上海222");
        userDao.setEmail("lisi@126.com");
        userDao.setTel("13900003333");

        mongoTemplate.save(userDao);

        for (int i = 1; i <= 10; i++) {
            Book book =  new Book();
            book.setId(i);
            book.setBookName("第 "+ i + "本书");
            book.setDescribe("简介：第 "+ i + "本书");
            //mongoTemplate.save(book);
        }

    }

    @Test
    void testupdate(){
        Book book =  new Book();
        System.out.println(mongoTemplate.findAll(Book.class));
        Criteria criteria = Criteria.where("id").gt(8);

        Query query = new Query();
        query.addCriteria(criteria);


        System.out.println(mongoTemplate.count(query, Book.class));
        Update update = Update.update("bookName","第8本书修订版");


        //UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Book.class);
        //System.out.println(updateResult);


        DeleteResult deleteResult = mongoTemplate.remove(query, Book.class);
        System.out.println(deleteResult);


    }










}
