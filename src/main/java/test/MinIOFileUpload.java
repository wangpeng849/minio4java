package test;

import com.google.common.reflect.ClassPath;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author wangp
 * @Date 2020/7/17
 * @Version 1.0
 */
public class MinIOFileUpload extends MinIOBaseInfo {

    public static void main(String[] args) {
        try {
            MinioClient minioClient = init();
            //使用putObject上传一个文件到存储桶
            minioClient.putObject(BUCKET_NAME, PORTRAIT_NAME, FILE_PATH);
            System.out.println("successful upload file!");
        } catch (InvalidEndpointException | InvalidKeyException | NoSuchAlgorithmException | NoResponseException | XmlPullParserException | InvalidBucketNameException | InvalidArgumentException | RegionConflictException | InsufficientDataException | ErrorResponseException | InternalException | IOException | InvalidPortException e) {
            e.printStackTrace();
        }
    }
}
