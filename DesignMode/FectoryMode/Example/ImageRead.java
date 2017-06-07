package DesignMode.FectoryMode.Example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 读图像文件
 * Created by Charles on 2017/6/7
 */
public class ImageRead implements IRead<ImageInfo> {
    @Override
    public ImageInfo read(String... in) {
        BufferedImage bi=null;
        File f=new File(in[0]);//in[0]:图像文件名
        try {
            bi= ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int width=bi.getWidth();
        int height=bi.getHeight();
        int rgb[]=new int[width*height];
//        将图像数据读到result缓冲区
        bi.getRGB(0,0,width,height,rgb,width,height);
        ImageInfo obj=new ImageInfo();//设置图像信息
//        设置图像宽度、高度和rgb【】3基色信息
        obj.setWidth(width);
        obj.setHeight(height);
        obj.setRGB(rgb);
        return  obj;
    }
}
