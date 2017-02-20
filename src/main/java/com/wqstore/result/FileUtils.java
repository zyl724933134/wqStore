package com.wqstore.result;


import java.io.File;
import java.io.FileOutputStream;

public class FileUtils {
    private static String baseFolder = "/data/img";
    public static String writeFileToHD(byte[] fileData,String fileName) throws Exception {
        File folder = new File(baseFolder);
        if (!folder.exists()){
            folder.mkdirs();
        }
        File f = new File(folder,fileName);
        f.createNewFile();
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(f);
            out.write(fileData);
            out.flush();
        }catch (Exception e){
            throw  e;
        }finally {
            if (out!=null){
                out.close();
            }
        }
        return f.getAbsolutePath();
    }

}
