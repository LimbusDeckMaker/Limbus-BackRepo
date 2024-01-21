package com.example.limbusDeckMaker.service.dataInit;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class S3Service {

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    @Autowired
    public S3Service(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    public List<String> getAllImageUrls() {
        ListObjectsV2Request request = new ListObjectsV2Request().withBucketName(bucketName);
        ListObjectsV2Result result = amazonS3.listObjectsV2(request);
        List<String> urls = new ArrayList<>();

        for (S3ObjectSummary objectSummary : result.getObjectSummaries()) {
            String objectKey = objectSummary.getKey();
            if (objectKey.endsWith(".png") || objectKey.endsWith(".jpg")) {
                String url = "https://" + bucketName + ".s3.amazonaws.com/" + objectKey;
                urls.add(url);
            }
        }
        return urls;
    }

}
