package com.daily.socketTest;

import org.junit.Test;

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
 * Created by json on 2018/6/8.
 * Describe: socket(套接字) 服务端测试
 * 监听：
 */
public class Servcer {

    public static String _pattern = "yyyy-MM-dd HH:mm:ss SSS";
    public static SimpleDateFormat format = new SimpleDateFormat(_pattern);
    // 设置超时间
    public static int _sec = 0;

    /**
    *
    * 作者  json
    * 时间  2018/6/8 15:31
    * 描述  socket 服务端
    *
    **/
    @Test
    public void  ServerProvider(){

        System.out.println("----------Server----------");
        System.out.println(format.format(new Date()));

        ServerSocket server;
        try {
            server = new ServerSocket(8001);
            System.out.println("监听建立 等你上线\n");

            Socket socket = server.accept();
            System.out.println(format.format(new Date()));
            System.out.println("建立了链接\n");

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            socket.setSoTimeout(_sec * 1000);
            System.out.println(format.format(new Date()) + "\n" + _sec + "秒的时间 快写\n");

            System.out.println(format.format(new Date()) + "\n ^ _ ^Client :" + br.readLine() + "\n");

            Writer writer = new OutputStreamWriter(socket.getOutputStream());

            System.out.println(format.format(new Date()));
            System.out.println("我在写回复\n");

            writer.write("收到\n");

            Thread.sleep(10000);
            writer.flush();

            System.out.println(format.format(new Date()));
            System.out.println("写完啦 你收下\n\n\n\n\n");
        } catch (SocketTimeoutException e) {
            System.out.println(format.format(new Date()) + "\n" + _sec + "秒没给我数据 我下啦\n\n\n\n\n");
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    


}
