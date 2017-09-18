package com.example.chengyonghui.normalbutton.util;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by chengyonghui on 2017/9/18.
 */
public class FileSdcardUtil {
    private String SDPATH;
    public String getSDPATH() {
        return SDPATH;
    }
    public FileSdcardUtil() {
        //得到当前外部存储设备的目录
        SDPATH = Environment.getExternalStorageDirectory() + "/";
    }

    /*
    在SD卡上创建文件
     */
    public File createSDFile(String fileName) throws IOException {
        File file = new File(SDPATH + fileName);
        file.createNewFile();
        return file;
    }

    /*
    在SD卡上创建目录
     */
    public File createSDDir(String dirName) {
        File dir = new File(SDPATH + dirName);
        dir.mkdir();
        return dir;
    }

    /*
    判断SD上的文件是否存在
     */
    public boolean isFileExist(String fileName) {
        File file = new File(SDPATH + fileName);
        return file.exists();
    }

    /*
    将一个InputStream里面的数据写入到SD卡中
     */
    public File write2SDFromInput(String path, String fileName, InputStream inputStream) {
        File file = null;
        OutputStream output = null;
        try {
            //调用自己类中写的方法
            createSDDir(path);
            file = createSDFile(path + fileName);
            output = new FileOutputStream(file);
            byte buffer [] = new byte[4 * 1024];
            while ((inputStream.read(buffer)) != -1) {
                output.write(buffer);
            }
            output.flush();//写完之后，记得清除缓存
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
