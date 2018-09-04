package com.daily.FreeMarkerPOI;

//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by json on 2018/7/31.
 * Describe: freemarker 导出 word
 */
public class FreeMarkTest {


//    @Test
//    public void testPoi(){
//
//        //创建配置实例
//            Configuration configuration = new Configuration();
//            String path1 = FreeMarkTest.class.getResource("/").getPath();
//            File files=new File(path1);
//            String parent = files.getParent();
//            String path=parent+"/classes/temp";
//        //设置编码
//            configuration.setDefaultEncoding("UTF-8");
//        try {
//            configuration.setDirectoryForTemplateLoading(new File(path));
//            Template template = configuration.getTemplate("fundxExample.ftl");
//
//
//            //文件路径
//            String filePath="D:\\study";
//            String fileName="基金.doc";
//            //输出文件
//            File outFile = new File(filePath+File.separator+fileName);
//
//            //如果输出目标文件夹不存在，则创建
//            if (!outFile.getParentFile().exists()){
//                outFile.getParentFile().mkdirs();
//            }
//            Map map=new HashMap();
//            map.put("fundname","长生科技");
//            //将模板和数据模型合并生成文件
//            Writer out = null;
//
//            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
//
//            template.process(map,out);
//            //关闭流
//            out.flush();
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//        System.out.println(path);
//
//
//    }
}
