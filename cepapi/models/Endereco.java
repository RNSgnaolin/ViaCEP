package cepapi.models;

import java.util.Objects;

public class Endereco {

    public Endereco(Model model) {
        this.cep = model.cep();
        this.street = model.logradouro();
        this.neighborhood = model.bairro();
        this.city = model.localidade();
        this.state = model.uf();
    }
    public Endereco() {

    }

    private String cep;
    private String street;
    private String neighborhood;
    private String city;
    private String state;

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return street + "\n"
        + neighborhood + ", " + city + " - " + state; 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Endereco)) return false;

        Endereco outroEndereco = (Endereco) obj;
        return this.cep.equals(outroEndereco.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep);
    }

    
    
}
