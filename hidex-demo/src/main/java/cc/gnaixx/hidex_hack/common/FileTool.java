package cc.gnaixx.hidex_hack.common;

import android.content.Context;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static android.content.ContentValues.TAG;

/**
 * 名称: FileUtil
 * 描述:
 *
 * @author xiangqing.xue
 * @date 2016/11/29
 */

public class FileTool {

    //将文件复制到cache
    public static void copyFromAssets(Context context, String path, String filename) {
        try {
            byte[] data = readAssets(context, filename);

            String dexPath = path + File.separator + new String(filename);
            FileOutputStream fos = new FileOutputStream(dexPath);
            BufferedOutputStream outputStream = new BufferedOutputStream(fos);
            outputStream.write(data);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取文件流
    public static byte[] readAssets(Context context, String filename){
        try {
            InputStream is = context.getResources().getAssets().open(filename);
            int length = is.available();
            byte[] data = new byte[length];
            is.read(data);
            is.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //读取文件
    public static byte[] readFiles(String path, String filename){
        File file = new File(path, filename);
        if(!file.exists()){
            Log.e(TAG, path + "/" + filename + "not exist");
            return null;
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
