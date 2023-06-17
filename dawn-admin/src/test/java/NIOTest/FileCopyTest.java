package NIOTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import org.apache.commons.io.FileUtils;

/**
 * Package: NIOTest Description: Date:  2020/5/26 0:11 Author: kousq Modified By:
 */
public class FileCopyTest {
    private static final String INPUT_SOURCE =  "C:\\Users\\kousq\\Desktop\\filetest\\source\\11.数理统计.mp4";
    private static final String OUTPUT_SOURCE =  "C:\\Users\\kousq\\Desktop\\filetest\\dest\\11.数理统计.mp4";


    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    //  NIO
    private static void copyFileUsingChannel(File source, File dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } finally {
            sourceChannel.close();
            destChannel.close();
        }
    }

    //UsingApacheCommonsIO

    private static void copyFileUsingApacheCommonsIO(File source, File dest) throws IOException {
        FileUtils.copyFile(source, dest);
    }


    private static void copyFileUsingJavaFiles(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }


    public static void main(String[] args) throws InterruptedException, IOException {

        File source = new File(INPUT_SOURCE);
        File dest = new File(OUTPUT_SOURCE);
        long start = System.currentTimeMillis();
//        copy file conventional way using Stream

        copyFileUsingStream(source, dest);
        System.out.println("Time taken by Stream Copy = " + (System.currentTimeMillis() - start));   //9171ms(10s左右)

        //copy files using java.nio FileChannel
        source = new File(INPUT_SOURCE);
        dest = new File(OUTPUT_SOURCE);
        start = System.currentTimeMillis();
        copyFileUsingChannel(source, dest);
        System.out.println("Time taken by Channel Copy = " + (System.currentTimeMillis() - start));    // 4231(5s左右)

        //copy files using apache commons io
        source = new File(INPUT_SOURCE);
        dest = new File(OUTPUT_SOURCE);
        start = System.currentTimeMillis();
        copyFileUsingApacheCommonsIO(source, dest);
        System.out.println("Time taken by Apache Commons IO Copy = " + (System.currentTimeMillis() - start)); //6293(6s左右)

        //using Java 7 Files class
        source = new File(INPUT_SOURCE);
        dest = new File(OUTPUT_SOURCE);
        start = System.currentTimeMillis();
        copyFileUsingJavaFiles(source, dest);
        System.out.println("Time taken by Java7 Files Copy = " + (System.currentTimeMillis() - start)); //3361 (3s左右)
    }
}