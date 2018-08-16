package br.com.alura.agendaalura;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import br.com.alura.agendaalura.converter.AlunoConverter;
import br.com.alura.agendaalura.dao.AlunoDAO;
import br.com.alura.agendaalura.modelo.Aluno;

public class EnviaDadosServidor  extends AsyncTask<Void, Void, String>{

    private Context context;
    private ProgressDialog alertDialog;

    public EnviaDadosServidor(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        alertDialog = ProgressDialog.show(context, "Aguarde", "Enviando para o servidor...", true, true);
        alertDialog.show();
    }

    @Override
    protected String doInBackground(Void... params) {

        WebClient client = new WebClient();
        AlunoConverter converter = new AlunoConverter();
        AlunoDAO dao = new AlunoDAO(context);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();

        String json = converter.toJson(alunos);
        String resposta = client.post(json);

        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {

        alertDialog.dismiss();
        Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();
    }

}
