package com.example.limbusDeckMaker.util;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JsonParser {

    private final AmazonS3 amazonS3;
    private final ObjectMapper objectMapper;

    @Value("${cloud.aws.s3.data.bucket}")
    private String dataBucket;

    public JsonParser(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
        this.objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    public <T> T parseJsonFromS3(String fileKey, TypeReference<T> typeReference) throws IOException {
        S3Object s3Object = amazonS3.getObject(new GetObjectRequest(dataBucket, fileKey));
        String json = IOUtils.toString(s3Object.getObjectContent());
        return objectMapper.readValue(json, typeReference);
    }
}
