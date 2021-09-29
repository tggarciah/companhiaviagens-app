package br.com.dtfoods.companhiaviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
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

      Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

      TextView local = findViewById(R.id.activity_resumo_pacote_local);
      local.setText(pacoteSaoPaulo.getLocal());

      ImageView imagem = findViewById(R.id.activity_resumo_pacote_banner);
      Drawable drawable = ResourceUtil.devolverDrawable(this, pacoteSaoPaulo.getImagem());
      imagem.setImageDrawable(drawable);

      TextView dias = findViewById(R.id.activity_resumo_pacote_dias);
      dias.setText(DiasUtil.formataEmTexto(pacoteSaoPaulo.getDias()));

      TextView preco = findViewById(R.id.activity_resumo_pacote_preco);
      preco.setText(MoedaUtil.formataMoedaBrasileira(pacoteSaoPaulo.getPreco()));

      TextView periodo = findViewById(R.id.activity_resumo_pacote_periodo);
      Calendar dataIda = Calendar.getInstance();
      Calendar dataVolta = Calendar.getInstance();
      dataVolta.add(Calendar.DATE, pacoteSaoPaulo.getDias());
      SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM");
      String dataFormatadaIda = formatoBrasileiro.format(dataIda.getTime());
      String dataFormatadaVolta = formatoBrasileiro.format(dataVolta.getTime());
      String dataFormatadaDaViagem = dataFormatadaIda + " - " + dataFormatadaVolta + " de " + dataVolta.get(Calendar.YEAR);
      periodo.setText(dataFormatadaDaViagem);
   }
}