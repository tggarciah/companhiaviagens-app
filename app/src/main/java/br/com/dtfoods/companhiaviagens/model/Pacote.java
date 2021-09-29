package br.com.dtfoods.companhiaviagens.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

public class Pacote implements Serializable {

   private final String local;
   private final String imagem;
   private final int dias;
   private final BigDecimal preco;
   private final Calendar dataInicio;
   private Calendar dataFinal;

   public Pacote(String local, String imagem, int dias, BigDecimal preco, Calendar dataInicio) {
      this.local = local;
      this.imagem = imagem;
      this.dias = dias;
      this.preco = preco;
      this.dataInicio = dataInicio;
      dataFinal = Calendar.getInstance();
      dataFinal.add(Calendar.DATE, this.dias);
   }

   public String getLocal() {
      return local;
   }

   public String getImagem() {
      return imagem;
   }

   public int getDias() {
      return dias;
   }

   public BigDecimal getPreco() {
      return preco;
   }

   public Calendar getDataInicio() {
      return dataInicio;
   }

   public Calendar getDataFinal() {
      return dataFinal;
   }
}
