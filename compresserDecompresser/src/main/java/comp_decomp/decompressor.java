/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author utkarshbansal
 */
public class decompressor {
    public static void method(File file) throws IOException {
        String fileDirectory = file.getParent();
        String originalFileName = file.getName();
        String originalFilePath = fileDirectory + "/" + originalFileName.substring(0, originalFileName.length() - 3); // Remove .gz

        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(originalFilePath);

        byte[] buffer = new byte[1024];
        int len;
        while ((len = gzip.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        gzip.close();
        fos.close();
        fis.close();
    }

    public static void main(String[] args) throws IOException {
        File path = new File("/Users/utkarshbansal/Downloads/compressor/CompressedFile.gz");
        method(path);
    }
}
