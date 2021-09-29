package br.com.dtfoods.companhiaviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

      Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"), Calendar.getInstance());

      mostraLocal(pacoteSaoPaulo);
      mostraImagem(pacoteSaoPaulo);
      mostraDias(pacoteSaoPaulo);
      mostraPreco(pacoteSaoPaulo);
      mostraPeriodo(pacoteSaoPaulo);

      Intent intent = new Intent(this, PagamentoActivity.class);
      startActivity(intent);
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