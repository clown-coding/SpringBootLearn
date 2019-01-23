package com.clown.jest;

import com.clown.jest.model.Book;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/23
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JestTest {

    @Autowired
    JestClient jestClient;

    //构建一个索引,并添加类型和文档
    @Test
    public void jestSaveTest()  {
        Book book = new Book(1,"红楼梦","曹雪芹","贾王薛史");
        Index index = new Index.Builder(book).index("springboot_elasticsearch").type("book").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //搜索
    @Test
    public void jestSearchTest(){

        //创建查询表达式
        String query = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"bookName\" : \"红楼梦\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        //构建搜索功能
        Search search = new Search.Builder(query).addIndex("springboot_elasticsearch").addType("book").build();

        try {
            //执行搜索
            SearchResult book = jestClient.execute(search);
            System.out.println(book.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
