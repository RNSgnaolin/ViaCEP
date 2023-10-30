package cepapi.models;

public record Model(String cep, String logradouro, String complemento, 
String bairro, String localidade, String uf, String ddd) {}
