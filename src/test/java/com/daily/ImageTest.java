package com.daily;

import com.daily.util.ImageUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

/**
 * @ClassName ImageTest
 * Description: 测试图片工具类
 * @Author dailiuyang
 * @Date 2019/3/1 16:19
 **/
public class ImageTest {



    /*
    * 获取图片的长宽*/
    @Test
    public void testImageLengthAndWidth(){
        try {
            File images=new File("D:\\specailImage\\a.jpg");
            FileInputStream in=new FileInputStream(images);
            int[] sizeInfo = ImageUtils.getSizeInfo(in);
            String s = Arrays.toString(sizeInfo);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    *图片压缩
    * */
    @Test
    public void testImage(){
        try {
            File images=new File("D:\\specailImage\\a.jpg");
            FileInputStream in=new FileInputStream(images);
            File copyimages=new File("D:\\specailImage\\copya.jpg");
            FileOutputStream out=new FileOutputStream(copyimages);
            ImageUtils.optimize(images,copyimages,0.5f);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    /*
    *
    * */




}
