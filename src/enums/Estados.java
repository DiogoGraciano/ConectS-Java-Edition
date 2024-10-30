
package enums;

public enum Estados {
    RS("Rio Grande do Sul"),
    SC("Santa Catarina"),
    PR("Paraná"),
    SP("São Paulo"),
    RJ("Rio de Janeiro"),
    ES("Espírito Santo"),
    MG("Minas Gerais"),
    MT("Mato Grosso"),
    MS("Mato Grosso do Sul"),
    GO("Goiás"),
    TO("Tocantins"),
    DF("Distrito Federal"),
    BA("Bahia"),
    CE("Ceará"),
    SE("Sergipe"),
    AL("Alagoas"),
    RN("Rio Grande do Norte"),
    PE("Pernambuco"),
    MA("Maranhão"),
    AM("Amazonas"),
    AC("Acre"),
    RR("Roraima"),
    RO("Rondônia"),
    PA("Pará"),
    PI("Piauí");
    //
    private String descricao;
    //
    private Estados(String descricao) {
        this.descricao = descricao;
    }
    //
    @Override
    public String toString() {
        return this.descricao;
    }
}
