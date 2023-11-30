package exercicio01;

public class App {
    public static void main(String[] args) throws Exception {  
   
        Medico medico1 = new Medico();
        System.out.println("Função do Médico: ");
        medico1.tratarPacientes();
    
        
        ClinicoGeral clinicoGeral1 = new ClinicoGeral();
         System.out.println("Função do Clinico Geral: ");
        clinicoGeral1.receitar();
        clinicoGeral1.tratarPacientes();
        
        Cirurgiao cirurgiao1 = new Cirurgiao();
         System.out.println("Função do Cirurgião: ");
        cirurgiao1.fazerIncisão();
        cirurgiao1.tratarPacientes();
    }
}