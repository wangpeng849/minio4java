package test;

import io.minio.MinioClient;
import io.minio.errors.*;
import org.xmlpull.v1.XmlPullParserException;

import java.awt.image.BufferedImage;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author wangp
 * @Date 2020/7/17
 * @Version 1.0
 */
public class MinIOGetObject extends MinIOBaseInfo {

    public static void main(String[] args) {
        try {
            MinioClient minioClient = init();
            InputStream inputStream = minioClient.getObject(BUCKET_NAME, PORTRAIT_NAME);
            BufferedInputStream bufferedInputStream = new BufferedInputStream((inputStream));

            //输出到对应文件
            File file = new File(COPY_FILE_PATH);
            if(!file.exists()) file.createNewFile();
            //创建输出流
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            //读取输入流
            byte[] bytes = new byte[1024];
            int byteRead;
            while((byteRead = bufferedInputStream.read(bytes,0,bytes.length))>=0){
                bufferedOutputStream.write(bytes,0,byteRead);
                bufferedOutputStream.flush();
            }
            System.out.println("文件转换成功！");
            bufferedInputStream.close();
            bufferedOutputStream.close();
        } catch (InvalidPortException e) {
            e.printStackTrace();
        } catch (InvalidEndpointException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InsufficientDataException e) {
            e.printStackTrace();
        } catch (InternalException e) {
            e.printStackTrace();
        } catch (NoResponseException e) {
            e.printStackTrace();
        } catch (InvalidBucketNameException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (ErrorResponseException e) {
            e.printStackTrace();
        } catch (RegionConflictException e) {
            e.printStackTrace();
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }
    }
}
