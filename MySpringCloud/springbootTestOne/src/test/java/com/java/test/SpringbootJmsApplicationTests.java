/**
 * Project Name:mySpringboot
 * File Name:SpringbootJmsApplicationTests.java
 * Package Name:com.java.test
 * Date:2019年5月21日下午3:10:26
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.test;
import javax.jms.Destination;  
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import com.java.App;
import com.java.jms.Producer; 
/**
 * @Title: SpringbootJmsApplicationTests.java 
 * @Package com.java.test 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 刘云升  
 * @date 2019年5月21日 下午3:11:37 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@RunWith(SpringRunner.class)  
@SpringBootTest(classes =App.class)  
public class SpringbootJmsApplicationTests {  
      
    @Autowired  
    private Producer producer;  
      
    @Test  
    public void contextLoads() {  
        Destination destination = new ActiveMQQueue("mytest.queue");  
          
        for(int i=0; i<10; i++){  
            producer.sendMessage(destination, "myname is chhliu!!!");  
        }  
    }
}
