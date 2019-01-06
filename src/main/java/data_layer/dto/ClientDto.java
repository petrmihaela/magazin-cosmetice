package data_layer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ClientDto {

    @JsonProperty("username")
    private String username;
    @JsonProperty("parola")
    private String parola;

    public ClientDto() {

    }

    public ClientDto(String username, String parola) {
        this.username = username;
        this.parola = parola;
    }

    public String getUsername() {
        return username;
    }

    public String getParola() {
        return parola;
    }
}
