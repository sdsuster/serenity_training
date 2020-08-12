package com.ivanwidyan.module.api.response.get10_pokemons;

import com.ivanwidyan.module.api.data.Pokemon;
import cucumber.api.java.mk_latn.No;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PokemonsResponse {
    private int count;
    private String next;
    private String previous;

    List<Pokemon> results;
}
