package br.com.dtfoods.companhiaviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

   public static final String PORTUGUES = "pt";
   public static final String PAIS = "br";

   public static String formataMoedaBrasileira(BigDecimal valor) {
      NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale(PORTUGUES, PAIS));
      String precoEmTexto = formatoBrasileiro.format(valor);
      return precoEmTexto;
   }

}
