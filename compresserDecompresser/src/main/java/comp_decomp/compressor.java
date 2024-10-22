package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author utkarshbansal
 */
public class compressor {
    public static void method(File file) throws IOException {
        String fileDirectory = file.getParent();
        String originalFileName = file.getName();
        String compressedFileName = originalFileName + ".gz"; // Retain original name and add .gz

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/" + compressedFileName);
        
        GZIPOutputStream gzip = new GZIPOutputStream(fos);
         
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            gzip.write(buffer, 0, len);
        }
        
        // Close resources
        gzip.finish(); // Ensure all data is written
        gzip.close();
        fos.close();
        fis.close();
    }
    
    public static void main(String[] args) throws IOException {
        File path = new File("/Users/utkarshbansal/Downloads/compressor/TestFile");
        method(path);
    }
}
