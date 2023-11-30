package aula04.Exercicio_static.exercicio4_aula4;

public class Configuracao {

    private static String background = "rosa";
    private static int fontSize = 12;
    private static String language = "portugues";

    public static String getBackground() {
        return background;
    }

    public static void setBackground(String background) {
        Configuracao.background = background;
    }

    public static int getFontSize() {
        return fontSize;
    }

    public static void setFontSize(int fontSize) {
        Configuracao.fontSize = fontSize;
    }

    public static String getLanguage() {
        return language;
    }

    public static void setLanguage(String language) {
        Configuracao.language = language;
    }

}
