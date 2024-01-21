package com.example.limbusDeckMaker.service.dataInit;

import com.example.limbusDeckMaker.domain.Sinner;
import com.example.limbusDeckMaker.repository.SinnerRepository;
import org.springframework.stereotype.Service;

import static com.example.limbusDeckMaker.domain.Sinner.*;

@Service
public class SinnerDBInitService {

    private final SinnerRepository sinnerRepository;

    public SinnerDBInitService(SinnerRepository sinnerRepository) {
        this.sinnerRepository = sinnerRepository;
    }

    public void InputSinner(){
        Sinner yiSang = builder()
                .name("이상").image(null).build();

        Sinner faust = builder()
                .name("파우스트").image(null).build();

        Sinner donQuixote = builder()
                .name("돈키호테").image(null).build();

        Sinner ryoShu = builder()
                .name("로슈").image(null).build();

        Sinner meursault = builder()
                .name("뫼르소").image(null).build();

        Sinner hongLu = builder()
                .name("홍루").image(null).build();

        Sinner heathCliff = builder()
                .name("히스클리프").image(null).build();

        Sinner ishmael = builder()
                .name("이스마엘").image(null).build();

        Sinner rodion = builder()
                .name("로쟈").image(null).build();

        Sinner sinclair = builder()
                .name("싱클레어").image(null).build();

        Sinner outis = builder()
                .name("오티스").image(null).build();

        Sinner gregor = builder()
                .name("그레고르").image(null).build();

        sinnerRepository.save(yiSang);
        sinnerRepository.save(faust);
        sinnerRepository.save(donQuixote);
        sinnerRepository.save(ryoShu);
        sinnerRepository.save(meursault);
        sinnerRepository.save(hongLu);
        sinnerRepository.save(heathCliff);
        sinnerRepository.save(ishmael);
        sinnerRepository.save(rodion);
        sinnerRepository.save(sinclair);
        sinnerRepository.save(outis);
        sinnerRepository.save(gregor);
    }
}
