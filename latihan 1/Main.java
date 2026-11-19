interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Mengirim Email: " + message);
    }
}

class SMSNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Mengirim SMS: " + message);
    }
}

class WhatsAppNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Mengirim WhatsApp: " + message);
    }
}


class TelegramNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Mengirim Telegram: " + message);
    }
}

class NotificationService {
    private Notifier notifier;

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void notify(String message) {
        notifier.send(message);
    }
}

public class Main {
    public static void main(String[] args) {
        new NotificationService(new EmailNotifier()).notify("Halo, ini email test!");
        new NotificationService(new SMSNotifier()).notify("Ini SMS test!");
        new NotificationService(new WhatsAppNotifier()).notify("Ini pesan WhatsApp test!");
    }
}