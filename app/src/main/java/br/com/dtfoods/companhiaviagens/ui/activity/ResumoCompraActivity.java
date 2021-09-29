package br.com.dtfoods.companhiaviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.dtfoods.companhiaviagens.R;
import br.com.dtfoods.companhiaviagens.model.Pacote;
import br.com.dtfoods.companhiaviagens.util.DiasUtil;
import br.com.dtfoods.companhiaviagens.util.MoedaUtil;
import br.com.dtfoods.companhiaviagens.util.ResourceUtil;

public class ResumoCompraActivity extends AppCompatActivity {

   public static final String TITULO_APPBAR = "Resumo da compra";

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_resumo_compra);

      setTitle(TITULO_APPBAR);

      Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"), Calendar.getInstance());

      mostraImagem(pacoteSaoPaulo);
      mostraLocal(pacoteSaoPaulo);
      mostraPeriodo(pacoteSaoPaulo);
      mostraPreco(pacoteSaoPaulo);
   }

   private void mostraPreco(Pacote pacote) {
      TextView preco = findViewById(R.id.activity_resumo_compra_preco_pacote);
      preco.setText(MoedaUtil.formataMoedaBrasileira(pacote.getPreco()));
   }

   private void mostraPeriodo(Pacote pacote) {
      TextView periodo = findViewById(R.id.activity_resumo_compra_periodo);
      periodo.setText(DiasUtil.formataPeriodoEmTexto(pacote.getDataInicio(), pacote.getDataFinal()));
   }

   private void mostraLocal(Pacote pacote) {
      TextView local = findViewById(R.id.activity_resumo_compra_local_pacote);
      local.setText(pacote.getLocal());
   }

   private void mostraImagem(Pacote pacote) {
      ImageView imagem = findViewById(R.id.activity_resumo_compra_imagem_pacote);
      Drawable drawable = ResourceUtil.devolverDrawable(this, pacote.getImagem());
      imagem.setImageDrawable(drawable);
   }
}