package br.com.dtfoods.companhiaviagens.util;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.dtfoods.companhiaviagens.model.Pacote;

public class DiasUtil {

   public static final String PLURAL = " dias";
   public static final String SINGULAR = " dia";

   @NonNull
   public static String formataEmTexto(int quantidadeDeDias) {
      if (quantidadeDeDias > 1) {
         return quantidadeDeDias + PLURAL;
      }
      return quantidadeDeDias + SINGULAR;
   }

   public static String formataPeriodoEmTexto(Calendar dataInicial, Calendar dataFinal){
      SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM");
      String dataFormatadaIda = formatoBrasileiro.format(dataInicial.getTime());
      String dataFormatadaVolta = formatoBrasileiro.format(dataFinal.getTime());
      return dataFormatadaIda + " - " + dataFormatadaVolta + " de " + dataFinal.get(Calendar.YEAR);
   }
}
