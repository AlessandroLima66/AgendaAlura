package br.com.alura.agendaalura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

    }

    /*
     * Alterar o menu da activity
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /*
         * Transforma um xml em um menu
         */
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);

        return super.onCreateOptionsMenu(menu);
    }

    /*
     * Método recebe por parâmetro, o item do menu foi selecionado
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_formulario_ok:
                Toast.makeText(FormularioActivity.this, "Aluno salvo com sucesso!", Toast.LENGTH_LONG).show();


                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
