package com.leyou.search.client;


import com.leyou.LeyouSearchApplication;
import com.leyou.item.pojo.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: hasee
 * @Date: 2020/11/17
 * @Description: com.leyou.search.client
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LeyouSearchApplication.class)
public class CategoryClientTest {

    @Autowired
    private CategoryClient categoryClient;

    public void testQueryCategories() {
        List<Category> categories = this.categoryClient.queryCategoryByIds(Arrays.asList(1L, 2L, 3L));
        categories.forEach(System.out :: println);


    }


}