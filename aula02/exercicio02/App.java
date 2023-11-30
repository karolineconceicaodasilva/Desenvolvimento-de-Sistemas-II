package exercicio02;

public class App {
    public static void main(String[] args) throws Exception {  
        
        System.out.println("Exercicio 2 de Herança!");

        Aluno aluno1 = new Aluno();
        System.out.println("Dados do Aluno: ");
        aluno1.setNome("Karoline");
        aluno1.setAltura(1.65);
        aluno1.setIdade(27);
        aluno1.setPeso(66);
        aluno1.setSexo('F');
        aluno1.codigoAluno();

        System.out.println("Nome: " + aluno1.getNome());
        System.out.println("Idade: " + aluno1.getIdade());
        System.out.println("Altura: " + aluno1.getAltura());
        System.out.println("Peso: " + aluno1.getPeso());
        System.out.println("Sexo: " + aluno1.getSexo());

        Funcionario funcionario1 = new Funcionario();
        System.out.println("Dados do Funcionario: ");
        funcionario1.setNome("Tiago");
        funcionario1.setAltura(1.75);
        funcionario1.setIdade(35);
        funcionario1.setPeso(75.5);
        funcionario1.setSexo('M');
        funcionario1.funcao();

        System.out.println("Nome: " + funcionario1.getNome());
        System.out.println("Idade: " + funcionario1.getIdade());
        System.out.println("Altura: " + funcionario1.getAltura());
        System.out.println("Peso: " + funcionario1.getPeso());
        System.out.println("Sexo:" + funcionario1.getSexo());

        Computador computador1 = new Computador();
        System.out.println("Dados do Computador: ");
        computador1.setFuncao(" Comptar!");
        computador1.setQuantiaTotalEscola(500);
        System.out.println("Abaixo quantia de Computadores, mouses e teclado que há nas salas: ");
        computador1.quantidadePorSala();
        computador1.quantidadeTeclado();
        computador1.quantidadeMouse();

        System.out.println("Função" + computador1.getFuncao());
        System.out.println("Quantidade total que tem na escola: " + computador1.getQuantiaTotalEscola());

        Impressora impressora1 = new Impressora();
        System.out.println("Dados do impressora: ");
        impressora1.setFuncao(" Imprimir!");
        impressora1.setQuantiaTotalEscola(500);
        System.out.println("Abaixo quantia de impressoras e cartuchos que há nas salas: ");
        impressora1.quantidadePorSala();
        impressora1.quantidadeCartuchoPorSala();

        System.out.println("Função" + impressora1.getFuncao());
        System.out.println("Quantidade total que tem na escola: " + impressora1.getQuantiaTotalEscola());



    
    
    
    
    
    }
}