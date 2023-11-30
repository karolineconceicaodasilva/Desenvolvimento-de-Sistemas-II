package exercicio01;

public class Medico {
     
    private  boolean trabalharHospital;

    public void tratarPacientes(){
        System.out.println("Tratar!");
    }

    public boolean isTrabalharHospital() {
        return trabalharHospital;
    }

    public void setTrabalharHospital(boolean trabalharHospital) {
        this.trabalharHospital = trabalharHospital;
    }
}
