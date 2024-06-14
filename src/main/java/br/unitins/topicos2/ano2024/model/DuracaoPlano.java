package br.unitins.topicos2.ano2024.model;

public enum DuracaoPlano {
    PLANO_DIARIA(1, "Plano Diaria"),
    PLANO_MENSAL(2, "Plano Mensal"),
    PLANO_ANUAL(3, "Plano Anual");

    private final Integer id;
    private final String label;

    DuracaoPlano(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public static DuracaoPlano valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;

        for (DuracaoPlano duracaoPlano : DuracaoPlano.values()) {
            if (duracaoPlano.getId().equals(id))
                return duracaoPlano;
        }

        throw new IllegalArgumentException("id Invalido" + id);
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
}
