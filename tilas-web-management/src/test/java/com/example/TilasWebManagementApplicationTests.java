package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TilasWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void test() throws Exception{
        try {
            int i = 1/0;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
