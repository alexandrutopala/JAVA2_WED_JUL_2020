package server.convert;

import lib.dto.ProdusDto;
import server.model.Produs;

public final class ProdusConvertor {

    private ProdusConvertor() {
    }

    public static Produs convert(ProdusDto produsDto) {
        var produs = new Produs();

        produs.setCategorie(produsDto.getCategorie());
        produs.setId(produsDto.getId());
        produs.setNume(produsDto.getNume());
        produs.setPret(produsDto.getPret());

        return produs;
    }

    public static ProdusDto convert(Produs produs) {
        var produsDto = new ProdusDto(
                produs.getNume(),
                produs.getPret(),
                produs.getCategorie()
        );

        produsDto.setId(produs.getId());

        return produsDto;
    }
}
