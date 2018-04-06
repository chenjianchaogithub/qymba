package com.hzs.qymba.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Server {
    private static final Logger LOG = LoggerFactory.getLogger(Server.class);
    public static void main(String[] args) {
        try {
            LOG.info("Server start!");
            FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("classpath:config/applicationContext.xml");
//            FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("config/applicationContext.xml");
            LOG.info("Server 加载配置文件成功!");
            context.start();
        } catch (Exception e) {
            LOG.error("== DubboProvider context start error:",e);
        }
        synchronized (Server.class) {
            while (true) {
                try {
                    Server.class.wait();
                } catch (InterruptedException e) {
                    LOG.error("== synchronized error:",e);
                }
            }
        }
    }
}