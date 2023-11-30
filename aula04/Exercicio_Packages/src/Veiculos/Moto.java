package Veiculos;

import Interfaces.Transporte;

public class Moto implements Transporte {

    protected String revestimentoBanco;
    private double kmPorLitros;

    // @Override
    // public String toString() {
    //     return "Moto [kmPorLitros=" + kmPorLitros + "]";
    // }

    public String getRevestimentoBanco() {
        return revestimentoBanco;
    }

    public void setRevestimentoBanco(String revestimentoBanco) {
        this.revestimentoBanco = revestimentoBanco;
    }

    public double getKmPorLitros() {
        return kmPorLitros;
    }

    public void setKmPorLitros(double kmPorLitros) {
        this.kmPorLitros = kmPorLitros;
    }

    public void empina() {
        System.out.println("Deu um grauuu....");
    }

    public void iniciar() {
        System.out.println("Solicitamos que inicie!");
    }

    public void parar() {
        System.out.println("Solicitação de parada!");
    }

    public void acelerar(int velocidade) {
       
        int limiteVelocidade = 80;
        
        if (velocidade > limiteVelocidade) {
            System.out.println("Preste atenção na multa! Diminua a velocidade o limite é de: " + limiteVelocidade);
        } else if (velocidade < limiteVelocidade) {
            System.out.println("Está dentro do limite de velocidade, não aumente ela. Limite é de;" + limiteVelocidade);
        } else {
            System.out.println("Está dentro do limite da velocidade Parabéns!");
        }
    }
}
