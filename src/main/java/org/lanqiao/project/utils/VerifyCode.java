package org.lanqiao.project.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class VerifyCode {
    private int w =70;
    private int h = 35;
    private Random r = new Random();
    // {"宋体", "华文楷体", "黑体", "华文新魏", "华文隶书", "微软雅黑", "楷体_GB2312"}
    private String[] fontNames = {"宋体","华文楷体","黑体","微软雅黑","楷体_GB2321"};
    private String codes ="23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
    private Color bgColor = new Color(255,255,255);
    private String text;
    //生成随机颜色
    private Color randomColor(){
        int red = r.nextInt(150);
        int green =r.nextInt(150);
        int blue = r.nextInt(150);
        return  new Color(red,green,blue);
    }
    //在备选字体数组中 选取字体
    private Font randonFont(){
        int index = r.nextInt(fontNames.length);
        String fontName = fontNames[index];
        int style =r.nextInt(4);
        int size = r.nextInt(5)+24;
        return  new Font(fontName,style,size);
    }
    //画干扰线
    private void drawLine(BufferedImage image){
        int num =3;
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        for(int i =0;i<num;i++){
            int x1 = r.nextInt(w);
            int y1 = r.nextInt(h);
            int x2 = r.nextInt(w);
            int y2 = r.nextInt(h);
            g2.setStroke(new BasicStroke(1.5F));
            g2.setColor(Color.BLUE);
            g2.drawLine(x1,y1,x2,y2);
        }
    }
    //选区验证码的字符
    private char randomChar(){
        int index =r.nextInt(codes.length());
        return codes.charAt(index);
    }
    //创建画布
    private BufferedImage createImage(){
        BufferedImage image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();//画笔
        g2.setColor(this.bgColor);//设置画笔的颜色
        g2.fillRect(0,0,w,h);//画一个矩形
        return image;
    }
    //画验证码中的字符
    public BufferedImage getImage(){
        BufferedImage image = createImage();
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        StringBuilder sb = new StringBuilder();
        //向图片中画出4个字符
        for(int i=0;i<4;i++){
            String s = randomChar()+"" ;
            sb.append(s);
            float x = i * 1.0F * w / 4;
            g2.setFont(randonFont());
            g2.setColor(randomColor());
            g2.drawString(s,x,h-5);
        }
        this.text = sb.toString();
        drawLine(image);
        return image;
    }
    //获取验证码中的真正的文本内容
    public String getText(){
        return text;

    }
    //输出
    public static  void output(BufferedImage image, OutputStream out) throws IOException {
        ImageIO.write(image,"JPEG",out);
    }
}
