package exer_5;

public class Teste {
    public static void main(String[] args) {
        
        Notificavel whats = new Whatsapp();
        whats.notificar();

        Notificavel app = new NotificacaoApp();
        app.notificar();

        Notificavel email = new Email();
        email.notificar();

        Notificavel sms = new Sms();
        sms.notificar();
    }
}
