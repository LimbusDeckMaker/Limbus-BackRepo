package com.example.limbusDeckMaker.service.datainit;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.example.limbusDeckMaker.repository.EgoRepository;
import com.example.limbusDeckMaker.repository.IdentityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class S3Service {

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;
    private final AmazonS3 amazonS3;
    private final EgoRepository egoRepository;
    private final IdentityRepository identityRepository;

    public S3Service(AmazonS3 amazonS3, EgoRepository egoRepository, IdentityRepository identityRepository) {
        this.amazonS3 = amazonS3;
        this.egoRepository = egoRepository;
        this.identityRepository = identityRepository;
    }

    public void processS3ObjectAndDBMapping() {
        ListObjectsV2Request request = new ListObjectsV2Request().withBucketName(bucketName);
        ListObjectsV2Result result = amazonS3.listObjectsV2(request);

        for (S3ObjectSummary objectSummary : result.getObjectSummaries()) {
            String objectKey = objectSummary.getKey();
            String sinner = extractSinner(objectKey);
            String name = extractEgoIdentity(objectKey);
            String url = "https://" + bucketName + ".s3.amazonaws.com/" + objectKey;

            if(objectKey.contains("EGO")){
                updateEgoImage(sinner, name, url);
            } else if(objectKey.contains("Identity")){
                updateIdentityImage(sinner, name, url);
            }
        }
    }

    private void updateEgoImage(String sinnerName, String egoName, String url) {
        egoRepository.findBySinner_NameAndName(sinnerName, egoName)
                .ifPresent(ego -> {
                    if (url.contains("profile")) {
                        ego.updateZoomImage(url);
                    } else if (url.contains("cg")) {
                        ego.updateImage(url);
                    }
                    egoRepository.save(ego);
                });
    }

    private void updateIdentityImage(String sinnerName, String identityName, String url) {
        identityRepository.findBySinner_NameAndName(sinnerName, identityName)
                .ifPresent(identity -> {
                    if (url.contains("gacksung")) {
                        if (url.contains("info")) {
                            identity.updateAfterZoomImage(url);
                        } else {
                            identity.updateAfterImage(url);
                        }
                    } else if (url.contains("normal")) {
                        if (url.contains("info")) {
                            identity.updateBeforeZoomImage(url);
                        } else {
                            identity.updateBeforeImage(url);
                        }
                    }
                    identityRepository.save(identity);
                });
    }

    private String extractSinner(@org.jetbrains.annotations.NotNull String key) {
        return key.split("/")[0];
    }

    private String extractEgoIdentity(String key){
        String identityOrEgoName = key.split("/")[2];

        if (identityOrEgoName.contains("E.G.O")) {
            identityOrEgoName = identityOrEgoName.replace("E.G.O", "E.G.O ::");
        }
        return identityOrEgoName;
    }
}
