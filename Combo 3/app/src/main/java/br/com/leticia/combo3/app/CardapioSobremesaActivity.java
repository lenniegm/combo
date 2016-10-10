package br.com.leticia.combo3.app;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.leticia.combo3.R;

public class CardapioSobremesaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardapiosobremesa);

        List<ListacardapiosobremesaActivity> listacardapiosobremesa = new ArrayList<ListacardapiosobremesaActivity>();
        listacardapiosobremesa.add(new ListacardapiosobremesaActivity(1, "Contato 1", "(11) 1111-1111"));
        //listacardapiosobremesa.add(new ListacardapiosobremesaActivity(2, "Contato 2", "(22) 2222-2222"));
        ListView listView = (ListView) findViewById(R.id.lista);
        CardapioSobremesaArrayAdapter adapter = new CardapioSobremesaArrayAdapter(this, listacardapiosobremesa);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int i, long l)
            {
                //Toast.makeText(getApplicationContext(), "Item = " + i, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getBaseContext(),ComplementossobremesaActivity.class); //chama a tela complemento sobremesa
                intent.putExtra("posicao", i);
                startActivity(intent);
            }
        });
    }

}
