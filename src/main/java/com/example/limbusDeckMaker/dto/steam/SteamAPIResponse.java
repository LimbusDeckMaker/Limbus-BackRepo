package com.example.limbusDeckMaker.dto.steam;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SteamAPIResponse {
    @JsonProperty("appnews")
    private SteamAppNews steamAppNews;
}
