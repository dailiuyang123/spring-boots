package com.daily;

import com.daily.utils.RemoteApiInvoke;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.Map;

/**
 * Created by json on 2018/5/16.
 * Describe:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOne {

    @Test
    public void  test() throws IOException {

        RemoteApiInvoke remoteApiInvoke=new RemoteApiInvoke();
        Map map = remoteApiInvoke.invokeRemoteApi();
    }
    
    /**
    *
    * 作者  json
    * 时间  2018/5/24 10:22
    * 描述 二叉树 遍历
    *
    **/
    @Test
    public void testTree(){

        
    }

    /**
    *
    * 作者  json
    * 时间  2018/5/29 14:36
    * 描述  Docx 转html
    *
    **/
    @Test
    public void testPDF(){
        String path= "D:\\163Music";
        String file = "D:\\163Music\\jdbcTemplet类型.docx";
        String file2 ="D:\\163Music\\word07.html";
        File f = new File(file);
        if (!f.exists()) {
            System.out.println("Sorry File does not Exists!");
        } else {
            try {
                if (f.getName().endsWith(".docx") || f.getName().endsWith(".DOCX")) {
                    //读取文档内容
                    InputStream in = new FileInputStream(f);
                    XWPFDocument document = new XWPFDocument(in);

                    File imageFolderFile = new File(path);
                    //加载html页面时图片路径
                    XHTMLOptions options = XHTMLOptions.create().URIResolver( new BasicURIResolver("./"));
                    //图片保存文件夹路径
                    options.setExtractor(new FileImageExtractor(imageFolderFile));
                    OutputStream out = new FileOutputStream(new File(file2));
                    XHTMLConverter.getInstance().convert(document, out, options);
                    out.close();
                } else {
                    System.out.println("Enter only MS Office 2007+ files");
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
}
