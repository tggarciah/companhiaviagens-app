package br.com.dtfoods.companhiaviagens.ui.activity;

import static br.com.dtfoods.companhiaviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.dtfoods.companhiaviagens.R;
import br.com.dtfoods.companhiaviagens.model.Pacote;
import br.com.dtfoods.companhiaviagens.util.DiasUtil;
import br.com.dtfoods.companhiaviagens.util.MoedaUtil;
import br.com.dtfoods.companhiaviagens.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

   public static final String TITULO_APPBAR = "Resumo do Pacote";

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_resumo_pacote);

      setTitle(TITULO_APPBAR);
      carregaPacoteRecebido();
   }

   private void carregaPacoteRecebido() {
      Intent intent = getIntent();
      if (intent.hasExtra(CHAVE_PACOTE)) {
         final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

         inicializaCampos(pacote);
         configuraBotao(pacote);
      }
   }

   private void configuraBotao(Pacote pacote) {
      Button botaoRealizaPagamento = findViewById(R.id.activity_resumo_pacote_botao_pagto);
      botaoRealizaPagamento.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            vaiParaPagamento(pacote);
         }
      });
   }

   private void vaiParaPagamento(Pacote pacote) {
      Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
      intent.putExtra(CHAVE_PACOTE, pacote);
      startActivity(intent);

      finish();
   }

   private void inicializaCampos(Pacote pacote) {
      mostraLocal(pacote);
      mostraImagem(pacote);
      mostraDias(pacote);
      mostraPreco(pacote);
      mostraPeriodo(pacote);
   }

   private void mostraPeriodo(Pacote pacote) {
      TextView periodo = findViewById(R.id.activity_resumo_pacote_periodo);
      String dataFormatadaDaViagem = DiasUtil.formataPeriodoEmTexto(pacote.getDataInicio(), pacote.getDataFinal());
      periodo.setText(dataFormatadaDaViagem);
   }

   private void mostraPreco(Pacote pacote) {
      TextView preco = findViewById(R.id.activity_resumo_pacote_preco);
      preco.setText(MoedaUtil.formataMoedaBrasileira(pacote.getPreco()));
   }

   private void mostraDias(Pacote pacote) {
      TextView dias = findViewById(R.id.activity_resumo_pacote_dias);
      dias.setText(DiasUtil.formataEmTexto(pacote.getDias()));
   }

   private void mostraImagem(Pacote pacote) {
      ImageView imagem = findViewById(R.id.activity_resumo_pacote_banner);
      Drawable drawable = ResourceUtil.devolverDrawable(this, pacote.getImagem());
      imagem.setImageDrawable(drawable);
   }

   private void mostraLocal(Pacote pacote) {
      TextView local = findViewById(R.id.activity_resumo_pacote_local);
      local.setText(pacote.getLocal());
   }
}