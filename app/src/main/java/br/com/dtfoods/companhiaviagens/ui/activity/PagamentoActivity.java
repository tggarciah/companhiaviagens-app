package br.com.dtfoods.companhiaviagens.ui.activity;

import static br.com.dtfoods.companhiaviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

      carregaPacoteRecebido();
   }

   private void carregaPacoteRecebido() {
      Intent intent = getIntent();
      if (intent.hasExtra(CHAVE_PACOTE)) {
         final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

         mostraPreco(pacote);

         configuraBotao(pacote);
      }
   }

   private void configuraBotao(Pacote pacote) {
      Button botaoFinalizaCompra = findViewById(R.id.activity_pagamento_botao_finalizar_compra);
      botaoFinalizaCompra.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            vaiParaResumoCompra(pacote);

            finish();
         }
      });
   }

   private void vaiParaResumoCompra(Pacote pacote) {
      Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
      intent.putExtra(CHAVE_PACOTE, pacote);
      startActivity(intent);
   }

   private void mostraPreco(Pacote pacote) {
      TextView preco = findViewById(R.id.activity_pagamento_preco);
      preco.setText(MoedaUtil.formataMoedaBrasileira(pacote.getPreco()));
   }
}