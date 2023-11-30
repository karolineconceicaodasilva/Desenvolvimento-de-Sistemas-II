package exercicio01;

public class ClinicoGeral extends Medico {
    
    private  boolean atendeEmCasa;

    public void receitar(){
        System.out.println("Receitar em casa!");
    }

    public boolean isAtendeEmCasa() {
        return atendeEmCasa;
    }

    public void setAtendeEmCasa(boolean atendeEmCasa) {
        this.atendeEmCasa = atendeEmCasa;
    }

}
