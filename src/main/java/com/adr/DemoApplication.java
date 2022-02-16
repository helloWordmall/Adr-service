package com.adr;

import com.adr.service.AdrService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.Resource;

@SpringBootApplication
//此处使用了Command接口，否则重写run方法无效
public class DemoApplication implements CommandLineRunner{

    @Resource
    public AdrService adrService;

    public static void main(String[] args)
    {
        SpringApplication.run(DemoApplication.class, args);
    }

    //由于未知原因不能执行
    @Override
    public void run(final String...args)throws Exception{
        System.out.println("开始了");
        for(int i=0;i<3;i++){
            System.out.println("第"+i+"次测验如下");
            adrService.selectPartAge();
        }
    }

}
