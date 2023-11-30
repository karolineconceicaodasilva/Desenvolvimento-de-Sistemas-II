package com.example.apputeis.util;

import java.text.DecimalFormat;

public abstract class FormatUtil {

    public static String formatarDoubleDuasCasasDecimais(double valor){
        DecimalFormat formatar = new DecimalFormat("###.00");
        return formatar.format(valor);
    }
    public static String formatarVirgulas(String valor){

        return valor.replace("," , ".");
    }
}
