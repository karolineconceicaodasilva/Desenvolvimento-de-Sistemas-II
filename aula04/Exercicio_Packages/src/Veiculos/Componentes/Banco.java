package Veiculos.Componentes;

public class Banco {
    
    private String revestimento;

    public String getRevestimento() {
        return revestimento;
    }

    public void setRevestimento(String revestimento) {
        this.revestimento = revestimento;
    }

    public void ajuste(){
        System.out.println("Ajustando...");
    }
}
