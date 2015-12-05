package com.example.brendaminozzo.lanchonete;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    List<Lanches> lanches = new ArrayList<Lanches>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lista = (ListView) findViewById(R.id.minha_lista);

        List<Lanches> lanches = gerarLanches();
        //ArrayAdapter<Lanches> lanchesAdapter = new ArrayAdapter<Lanches>(this, android.R.layout.simple_list_item_1, lanches);
        //lista.setAdapter(lanchesAdapter);

        final ListaLanches_Adapter lanchesAdapter = new ListaLanches_Adapter(this,  lanches);
        lista.setAdapter(lanchesAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Lanches lanche = lanchesAdapter.getItem(position);
                //Lanches l = buscar(lanche.getNome());
                Intent i = new Intent(MainActivity.this, Listagem_detalhesLanche.class);
                i.putExtra("lanchinho",lanche);
                startActivity(i);
                //finish();
            }
        });
    }

    private List<Lanches> gerarLanches() {
        lanches.add(criarLanche("X-Salada", "pão, alface, tomate, hamburguer, mussarela", 9.00, R.drawable.x_salada));
        lanches.add(criarLanche("X-Bacon", "pão, hamburguer, bacon, queijo, maionese", 12.50, R.drawable.x_bacon));
        lanches.add(criarLanche("Cachorro-quente prensado", "pão, salsicha, queijo, batata palha, maionese, mostarda, milho", 6.00, R.drawable.cachorro_quente));
        lanches.add(criarLanche("Misto-quente", "presunto, queijo, maionese e catchup", 6.00, R.drawable.misto_quente));
        lanches.add(criarLanche("X-Egg", "pão, hambúrguer, ovo, presunto, queijo, alface, tomate, milho e ervilha", 13.00, R.drawable.x_egg));
        lanches.add(criarLanche("Bauru", "pão, maionese, presunto, queijo, tomate, milho e ervilha", 4.00, R.drawable.bauru));
        lanches.add(criarLanche("X-Calabresa", "pão, maionese, hambúrguer, presunto, mussarela, calabresa, tomate, alface, milho e ervilha", 11.60, R.drawable.x_calabresa));
        lanches.add(criarLanche("X-Americano", "pão, maionese, hambúrguer, presunto, mussarela, calabresa, bacon, milho e ervilha", 13.00, R.drawable.x_americano));
        lanches.add(criarLanche("X-Tudo", "pão, maionese, hambúrguer, 2 salsichas, presunto, mussarela, bacon, ovo, frango, calabresa, tomate, catupiry, milho e ervilha", 23.00, R.drawable.x_tudo));
        lanches.add(criarLanche("Cachorro-quente", "pão, maionese, salsicha, milho, ervilha, molho, batata palha, catchup", 5.00, R.drawable.cachorro_q));

        return lanches;
    }

    private Lanches criarLanche(String nome, String ingredientes, double valor, int imagem) {
        Lanches lanche = new Lanches(nome, ingredientes, valor, imagem);
        return lanche;
    }

    private Lanches buscar(String nome){
        for(int i=0; i<lanches.size();i++){
            if (nome.equals(lanches.get(i).getNome())){
                return lanches.get(i);
            }
        }
        return null;
    }

}
