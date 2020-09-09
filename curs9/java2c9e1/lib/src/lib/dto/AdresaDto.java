package lib.dto;

import java.io.Serializable;

public class AdresaDto implements Serializable {

    private final String strada;

    private final String numar;

    public AdresaDto(String strada, String numar) {
        this.strada = strada;
        this.numar = numar;
    }

    public String getStrada() {
        return strada;
    }

    public String getNumar() {
        return numar;
    }
}
