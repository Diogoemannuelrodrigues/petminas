package io.github.com.petminas.entidade.enums;

import lombok.Getter;

@Getter
public enum GeneroEnum {

    CACHORRO(1, "Cachorro"),
    GATO(2, "Gato");

    private int cod;
    private String descricao;

    private GeneroEnum(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static GeneroEnum toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (GeneroEnum x : GeneroEnum.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
