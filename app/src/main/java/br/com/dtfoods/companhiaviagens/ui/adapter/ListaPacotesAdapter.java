package br.com.dtfoods.companhiaviagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.dtfoods.companhiaviagens.R;
import br.com.dtfoods.companhiaviagens.model.Pacote;
import br.com.dtfoods.companhiaviagens.util.DiasUtil;
import br.com.dtfoods.companhiaviagens.util.MoedaUtil;
import br.com.dtfoods.companhiaviagens.util.ResourceUtil;

public class ListaPacotesAdapter extends BaseAdapter {

   private final List<Pacote> pacotes;
   private final Context context;

   public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
      this.pacotes = pacotes;
      this.context = context;
   }

   @Override
   public int getCount() {
      return pacotes.size();
   }

   @Override
   public Pacote getItem(int posicao) {
      return pacotes.get(posicao);
   }

   @Override
   public long getItemId(int i) {
      return 0;
   }

   @Override
   public View getView(int posicao, View view, ViewGroup parent) {
      View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

      Pacote pacote = pacotes.get(posicao);

      mostraLocal(viewCriada, pacote);
      mostraImagem(viewCriada, pacote);
      mostraDias(viewCriada, pacote);
      mostraPreco(viewCriada, pacote);

      return viewCriada;
   }

   private void mostraPreco(View viewCriada, Pacote pacote) {
      TextView campoPreco = viewCriada.findViewById(R.id.item_pacote_preco);
      String precoEmTexto = MoedaUtil.formataMoedaBrasileira(pacote.getPreco());
      campoPreco.setText(precoEmTexto);
   }

   private void mostraDias(View viewCriada, Pacote pacote) {
      TextView campoDias = viewCriada.findViewById(R.id.item_pacote_dias);
      String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
      campoDias.setText(diasEmTexto);
   }

   private void mostraImagem(View viewCriada, Pacote pacote) {
      ImageView campoImagem = viewCriada.findViewById(R.id.item_pacote_imagem);
      Drawable drawableImagemPacote = ResourceUtil.devolverDrawable(context, pacote.getImagem());
      campoImagem.setImageDrawable(drawableImagemPacote);
   }

   private void mostraLocal(View viewCriada, Pacote pacote) {
      TextView campoLocal = viewCriada.findViewById(R.id.item_pacote_local);
      campoLocal.setText(pacote.getLocal());
   }
}
