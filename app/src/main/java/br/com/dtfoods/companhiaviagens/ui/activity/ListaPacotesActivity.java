package br.com.dtfoods.companhiaviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

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
      List<Pacote> pacotes = new PacoteDAO().lista();
      listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
   }
}