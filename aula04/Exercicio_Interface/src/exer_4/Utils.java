package exer_4;

import java.text.NumberFormat;
import java.util.Locale;

public class Utils {

    public static String formatCurrency(double valor) {
        return NumberFormat.getCurrencyInstance(Locale.getDefault()).format(valor);
    }

}
