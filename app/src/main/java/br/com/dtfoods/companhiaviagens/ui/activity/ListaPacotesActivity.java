package br.com.dtfoods.companhiaviagens.ui.activity;

import static br.com.dtfoods.companhiaviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.dtfoods.companhiaviagens.R;
import br.com.dtfoods.companhiaviagens.dao.PacoteDAO;
import br.com.dtfoods.companhiaviagens.model.Pacote;
import br.com.dtfoods.companhiaviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

   public static final String TITULO_APPBAR = "Pacotes";

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_lista_pacotes);

      setTitle(TITULO_APPBAR);
      configuraLista();
   }

   private void configuraLista() {
      ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
      final List<Pacote> pacotes = new PacoteDAO().lista();
      listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
      listaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long l) {
            Pacote pacote = pacotes.get(posicao);
            vaiParaResumoPacote(pacote);
         }
      });
   }

   private void vaiParaResumoPacote(Pacote pacote) {
      Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
      intent.putExtra(CHAVE_PACOTE, pacote);
      startActivity(intent);
   }
}