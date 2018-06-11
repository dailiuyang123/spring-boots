package com.daily.controller;

import com.daily.mybatis.entity.JsonMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Azir on 2018/6/9.
 * 服务监听器
 *
 */
@RestController
@RequestMapping("/server")
public class ServerController {

    Logger logger= LoggerFactory.getLogger(ServerController.class);

    public static String _pattern = "yyyy-MM-dd HH:mm:ss SSS";
    public static SimpleDateFormat format = new SimpleDateFormat(_pattern);
    // 设置超时间
    public static int _sec = 0;

    @RequestMapping(value = "/provider",method = RequestMethod.POST)
    public JsonMessage provider(HttpServletRequest request, HttpServletResponse response){
        JsonMessage jsonMessage=new JsonMessage();
        System.out.println("----------Server----------");
        logger.info("----------Server---------");
        System.out.println(format.format(new Date()));
        logger.info(format.format(new Date()));
        ServerSocket server;
        try {
            server = new ServerSocket(8001);
            System.out.println("监听建立 等你上线\n");
            logger.info("监听建立 等你上线");
            Socket socket = server.accept();
            System.out.println(format.format(new Date()));
            System.out.println("建立了链接\n");

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            socket.setSoTimeout(_sec * 1000);
            System.out.println(format.format(new Date()) + "\n" + _sec + "秒的时间 快写\n");

            System.out.println(format.format(new Date()) + "\n ^ _ ^Client :" + br.readLine() + "\n");

            Writer writer = new OutputStreamWriter(socket.getOutputStream());

            System.out.println(format.format(new Date()));
            logger.info("我在写回复");
            System.out.println("我在写回复\n");

            writer.write("收到\n");

            Thread.sleep(10000);
            writer.flush();

            System.out.println(format.format(new Date()));
            System.out.println("写完啦 你收下\n\n\n\n\n");
            logger.info("写完啦 你收下");
        } catch (SocketTimeoutException e) {
            System.out.println(format.format(new Date()) + "\n" + _sec + "秒没给我数据 我下啦\n\n\n\n\n");
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
            jsonMessage.setErrorMessage("内部错误");
        } catch (Exception e) {
            e.printStackTrace();
            jsonMessage.setErrorMessage("内部错误");
        }


        return jsonMessage;

    }


}



