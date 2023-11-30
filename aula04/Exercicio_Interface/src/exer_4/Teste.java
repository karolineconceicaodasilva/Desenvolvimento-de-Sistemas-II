package exer_4;

public class Teste {
    public static void main(String[] args) {
        
        Transporte carro = new Carro();
        carro.custoPorKM();

        Transporte moto = new Moto();
        moto.custoPorKM();

        Transporte onibus = new Onibus();
        onibus.custoPorKM();

        Transporte trem = new Trem();
        trem.custoPorKM();
    }
}
