package com.example.limbusDeckMaker.dto.steam;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class SteamAppNews {

    @JsonProperty("newsitems")
    private List<SteamNewsDto> newsItems;
}
