package com.xconst.vavatar.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.xconst.vavatar.data.Mp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownloader {

    private static final String TAG = " FileDownloader ";

    public class Inf extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            return "";
        }
    }

    public static String getInfoFromDev(Context context) {
        Log.d(TAG, "tryGetInfoFromDev");
        BufferedReader reader = null;
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(Mp.INFO_FROM_DEV_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            Log.d(TAG, "1");


            connection.connect();
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 从连接中获取输入流
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                // 逐行读取响应内容
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            } else {
                response.append("error: ").append(responseCode);
            }


            Log.d(TAG, "getInfoFromDev successfully");
        } catch (Exception e) {
            Log.e(TAG, "Error: " + e.getMessage());
            e.printStackTrace(); // 输出异常堆栈信息
        }
        response.append("error: ");
        return response.toString();


    }

    public static void downloadFile(Context context) {
        Log.d(TAG, "tryDownloadFile");
        // 文件的 URL
        String FILE_URL = Mp.getDownloadUrl(context);
        try {
            URL url = new URL(FILE_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.connect();

            // 获取文件名
            String fileName = getFileNameFromUrl(connection);
            // 创建输入流
            InputStream inputStream = new BufferedInputStream(url.openStream(), 8192);

            File fileDir = FileUtil.getAvatarDir(context);
            // 创建输出流
            FileOutputStream outputStream = new FileOutputStream(new File(fileDir, fileName));

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();

            Log.d(TAG, "Downloaded successfully " + fileDir.getAbsolutePath());
        } catch (Exception e) {
            Log.e(TAG, "Error: " + e.getMessage());
            e.printStackTrace(); // 输出异常堆栈信息
        }
    }

    private static String getFileNameFromUrl(HttpURLConnection connection) {
        String fileName = null;
        String contentDisposition = connection.getHeaderField("Content-Disposition");
        if (contentDisposition != null && contentDisposition.indexOf("filename=") != -1) {
            int index = contentDisposition.indexOf("filename=");
            fileName = contentDisposition.substring(index + 9);
            // Remove quotes if any
            if (fileName.startsWith("\"") && fileName.endsWith("\"")) {
                fileName = fileName.substring(1, fileName.length() - 1);
            }
        }
        if (fileName == null || fileName.isEmpty()) {
            fileName = "file.txt"; // 如果未找到文件名，则使用默认的文件名
        }
        return fileName;
    }
}
