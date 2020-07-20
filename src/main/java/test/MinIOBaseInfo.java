package test;

import io.minio.MinioClient;
import io.minio.errors.*;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author wangp
 * @Date 2020/7/17
 * @Version 1.0
 */
public class MinIOBaseInfo {
    public static String BUCKET_NAME = "fii-oauth-image";
    public static String PORTRAIT_NAME = "portrait";
    public static String FILE_PATH = "./123.jpg";
    public static String COPY_FILE_PATH = "./456.jpg";
    public static String MINIO_URL = "http://minio-01.10-124-130-142.sslip.io/";
    public static String MINIO_ACCESS_KEY = "admin";
    public static String MINIO_SECRET_KEY = "mysecret";

    public static MinioClient init() throws InvalidPortException, InvalidEndpointException, IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, InternalException, NoResponseException, InvalidBucketNameException, XmlPullParserException, ErrorResponseException, RegionConflictException {
        MinioClient minioClient = new MinioClient(MINIO_URL, MINIO_ACCESS_KEY, MINIO_SECRET_KEY);
        //检查存储桶是否存在
        boolean isExist = minioClient.bucketExists(BUCKET_NAME);
        if (isExist) {
            System.out.println("Bucket 【" + BUCKET_NAME + "】is exist");
        } else {
            //创建一个名为fii-oauth-image的痛
            minioClient.makeBucket(BUCKET_NAME);
        }
        return minioClient;
    }
}
