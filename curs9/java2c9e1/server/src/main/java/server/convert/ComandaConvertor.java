package server.convert;

import lib.dto.AdresaDto;
import lib.dto.ComandaDto;
import server.model.Adresa;
import server.model.Comanda;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

public final class ComandaConvertor {

    private ComandaConvertor() {
    }

    public static Comanda convert(ComandaDto comandaDto) {
        var comanda = new Comanda();

        Optional.ofNullable(comandaDto.getAdresa())
                .ifPresent(adresaDto -> {
                    var adresa = new Adresa();

                    adresa.setNumar(adresaDto.getNumar());
                    adresa.setStrada(adresaDto.getStrada());

                    comanda.setAdresa(adresa);
                });

        comanda.setId(comandaDto.getId());
        comanda.setTelefoane(comandaDto.getTelefoane());
        comanda.setTimestamp(comandaDto.getTimestamp());
        comanda.setTotal(comandaDto.getTotal());

        return comanda;
    }

    public static ComandaDto convert(Comanda comanda) {

        var comandaDto = new ComandaDto(
                comanda.getTotal(),
                comanda.getTimestamp(),
                null,
                new HashSet<>(comanda.getTelefoane()),
                Collections.emptySet()
        );

        Optional.ofNullable(comanda.getAdresa())
                .ifPresent(adresa -> {
                    comandaDto.setAdresa(new AdresaDto(
                            adresa.getStrada(),
                            adresa.getNumar()
                    ));
                });

        return comandaDto;
    }
}
