package com.example.limbusDeckMaker.dto.steam;


import com.example.limbusDeckMaker.util.Views;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    String imageUrl;
}
