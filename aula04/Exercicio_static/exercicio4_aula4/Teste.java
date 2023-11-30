package aula04.Exercicio_static.exercicio4_aula4;

public class Teste {
    public static void main(String[] args) {
        
        System.out.println("Configurações iniciais:");
        System.out.println("Background: " + Configuracao.getBackground());
        System.out.println("Font Size: " + Configuracao.getFontSize());
        System.out.println("Language: " + Configuracao.getLanguage());

        Configuracao.setBackground("preto");
        Configuracao.setFontSize(14);
        Configuracao.setLanguage("inglês");

        System.out.println("Configurações alteradas:");
        System.out.println("Background: " + Configuracao.getBackground());
        System.out.println("Font Size: " + Configuracao.getFontSize());
        System.out.println("Language: " + Configuracao.getLanguage());
    }
} 

