package br.com.eh.buscaCep.models;

public class Address {
      private String cep;
      private String logradouro;
      private String complemento;
      private String bairro;
      private String localidade;
      private String uf;

    public Address(String cep, String logradouro,
                   String complemento, String bairro,
                   String localidade, String uf)
    {
        System.out.println("logra" + logradouro);
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    @Override
    public String toString() {
        return """
                Cep: %s;
                Logradouro: %s;
                Complemento: %s;
                Bairro: %s;
                Cidade: %s;
                UF: %s;
                """.formatted(cep, logradouro, complemento, bairro, localidade, uf);
    }

    public String getCep() {
        return cep;
    }
}
