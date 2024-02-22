package com.example.limbusDeckMaker.dto.steam;


import com.example.limbusDeckMaker.util.Views;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class SteamNewsDto {

    @JsonView(Views.Public.class)
    String title;

    @JsonView(Views.Public.class)
    String url;

    Long date;

    @JsonView(Views.Public.class)
    Date release;

    String contents;

    @JsonView(Views.Public.class)
    List<String> imageUrls;
}
