package br.com.dtfoods.companhiaviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.dtfoods.companhiaviagens.R;
import br.com.dtfoods.companhiaviagens.model.Pacote;
import br.com.dtfoods.companhiaviagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

   public static final String TITULO_APPBAR = "Pagamento";

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_pagamento);
      setTitle(TITULO_APPBAR);

      Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"), Calendar.getInstance());

      mostraPreco(pacoteSaoPaulo);

      Intent intent = new Intent(this, ResumoCompraActivity.class);
      startActivity(intent);
   }

   private void mostraPreco(Pacote pacote) {
      TextView preco = findViewById(R.id.activity_pagamento_preco);
      preco.setText(MoedaUtil.formataMoedaBrasileira(pacote.getPreco()));
   }
}