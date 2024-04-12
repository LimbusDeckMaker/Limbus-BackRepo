package com.example.limbusDeckMaker.service.datainit;

import com.example.limbusDeckMaker.domain.Keyword;
import com.example.limbusDeckMaker.repository.KeywordRepository;
import com.example.limbusDeckMaker.dto.KeywordDto;
import com.example.limbusDeckMaker.util.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class KeywordDBService {

    private final KeywordRepository keywordRepository;
    private final JsonParser jsonParser;

    public KeywordDBService(KeywordRepository keywordRepository, JsonParser jsonParser) {
        this.keywordRepository = keywordRepository;
        this.jsonParser = jsonParser;
    }

    public void processAndSaveData(String filekey) throws IOException {
        List<KeywordDto> keywords = jsonParser.parseJsonFromS3(filekey,
            new TypeReference<>() {
            });

        keywords.forEach(keywordDto -> {
            Keyword keyword = Keyword.toEntity(keywordDto);
            keywordRepository.save(keyword);
        });
    }


}
