package com.uama.log;

import android.text.format.DateFormat;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * print log to file
 *
 * Created by xubt on 2016/3/28.
 */
public class PrintToFile {

    private static PrintToFile instance;

    public static PrintToFile getInstance() {
        if (instance == null) {
            instance = new PrintToFile();
        }
        return instance;
    }


    public void print(String tag, String fileName, String msg) {
        fileName = (fileName == null) ? getFileName() : fileName;
        StringBuffer sb = new StringBuffer();
        sb.append("\r\n");
        sb.append(getCurrentTime());
        sb.append("-->>>");
        sb.append(msg);
        if (save(LMLog.LOG_PATH, fileName, sb.toString())) {
            if(LMLog.DEBUG){
                Log.d(tag, "save log success ! location is >>>" + LMLog.LOG_PATH + "/" + fileName);
            }
        } else {
            if(LMLog.DEBUG){
                Log.e(tag, "save log fails !");
            }
        }
    }

    public boolean save(String dic, String fileName, String msg) {
        File file = new File(dic, fileName);
        try {
            OutputStream outputStream = new FileOutputStream(file,true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            outputStreamWriter.write(msg);
            outputStreamWriter.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

    private String getFileName() {
        StringBuffer sb = new StringBuffer("LMLog_");
        sb.append(DateFormat.format("yyyy-MM-dd", System.currentTimeMillis()).toString());
        sb.append(".log");
        return sb.toString();
    }

    private String getCurrentTime() {
        return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(new Date());
    }


}
