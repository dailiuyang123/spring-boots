package com.daily.socketTest;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by json on 2018/6/8.
 * Describe: socket 的 客户端
 */
public class Client {

    public static String _pattern = "yyyy-MM-dd HH:mm:ss SSS";
    public static SimpleDateFormat format = new SimpleDateFormat(_pattern);
    // 设置超时间
    public static int _sec = 15;
    /**
    *
    * 作者  json
    * 时间  2018/6/8 15:37
    * 描述  socket 套接字实现 -客户端
    *
    **/
    @Test
    public void ClientProvider(){

        System.out.println("----------Client----------");

        Socket socket = null;
        try {
            // 与服务端建立连接
            socket = new Socket("127.0.0.1", 8001);
            socket.setSoTimeout(_sec * 1000);

            System.out.println(format.format(new Date()));
            System.out.println("建立了链接\n");

            // 往服务写数据
            Writer writer = new OutputStreamWriter(socket.getOutputStream());

            System.out.println(format.format(new Date()));
            System.out.println("我在写啦\n");
            Thread.sleep(10000);
            writer.write("有没有收到\n");

            System.out.println(format.format(new Date()));
            System.out.println("写完啦 你收下\n");

            writer.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            System.out.println(format.format(new Date()) + "\n" + _sec + "秒的时间 告诉我你收到了吗\n");

            System.out.println(format.format(new Date()) + "\n {- -}Server:" + br.readLine());

        } catch (SocketTimeoutException e) {
            System.out.println(format.format(new Date()) + "\n" + _sec + "秒没收到回复 我下啦\n\n\n\n\n");
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
