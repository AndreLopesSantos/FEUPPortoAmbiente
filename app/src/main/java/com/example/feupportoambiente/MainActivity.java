package com.example.feupportoambiente;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private static final String LOG_TAG = "Teste";
    //Para a Base de Dados SQLite
    DatabaseHelper mDatabaseHelper;

    //Ruas, Residuos, Areas
    private EditText mRuas;
    private EditText mResiduos;
    private EditText mAreas;

    //Variáveis para realizar as contagens
    private int pea_pequeno1 = 0;
    private int pea_medio1 = 0;
    private int pea_grande1 = 0;

    //Para ver os counters
    private TextView count_pea_pequeno1;
    private TextView count_pea_medio1;
    private TextView count_pea_grande1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabaseHelper = new DatabaseHelper(this);
        TabHost tabs = (TabHost) findViewById(R.id.tabhost);
        tabs.setup();

        count_pea_pequeno1 = (TextView) findViewById(R.id.pea_pequeno_count);
        count_pea_medio1 = (TextView) findViewById(R.id.pea_medio_count);
        count_pea_grande1 = (TextView) findViewById(R.id.pea_grande_count);


        mRuas = findViewById(R.id.editText_rua);
        mResiduos = findViewById(R.id.editText_amostra);
        mAreas = findViewById(R.id.editText_area);


        TabHost.TabSpec spec = tabs.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Dados");
        tabs.addTab(spec);
        spec = tabs.newTabSpec("tag2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Rua");
        tabs.addTab(spec);
        spec = tabs.newTabSpec("tag2");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Guardar");
        tabs.addTab(spec);
    }

    // PEA PEQUENO PLUS & MINUS
    public void minus_pea_pequeno(View view) {
        pea_pequeno1--;
        if (count_pea_pequeno1 != null)
            count_pea_pequeno1.setText(Integer.toString(pea_pequeno1));

    }


    public void plus_pea_pequeno(View view) {
        pea_pequeno1++;
        if (count_pea_pequeno1 != null)
            count_pea_pequeno1.setText(Integer.toString(pea_pequeno1));
    }

    // PEA MEDIO PLUS & MINUS
    public void minus_pea_medio(View view) {
        pea_medio1--;
        if (count_pea_medio1 != null)
            count_pea_medio1.setText(Integer.toString(pea_medio1));

    }

    public void plus_pea_medio(View view) {
        pea_medio1++;
        if (count_pea_medio1 != null)
            count_pea_medio1.setText(Integer.toString(pea_medio1));
    }

    // PEA GRANDE PLUS & MINUS
    public void minus_pea_grande(View view) {
        pea_grande1--;
        if (count_pea_grande1 != null)
            count_pea_grande1.setText(Integer.toString(pea_grande1));

    }


    public void plus_pea_grande(View view) {
        pea_grande1++;
        if (count_pea_grande1 != null)
            count_pea_grande1.setText(Integer.toString(pea_grande1));
    }


    // Função para TOASTmessages
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    //Inserir dados na base de dados
    public void AddData(String rua, String residuos, String area, int add_peapeq1, int add_peamed1, int add_peagran1){
        boolean insertData = mDatabaseHelper.addData(rua,residuos,area,add_peapeq1,add_peamed1,add_peagran1);

        if(insertData){
            toastMessage("Foi adicionado com sucesso!");
        }else {
            toastMessage("Algo correu mal");
        }
    }




    // Ir buscar dados aos inputs e chamar a função AddData para Gravar na base de dados
    public void gravar(View view) {
        String rua = mRuas.getText().toString();
        String residuos = mResiduos.getText().toString();
        String area = mAreas.getText().toString();
        AddData(rua,residuos,area,pea_pequeno1,pea_medio1,pea_grande1);
        pea_pequeno1 = 0;
        pea_medio1 = 0;
        pea_grande1 = 0;
        count_pea_pequeno1.setText(Integer.toString(pea_pequeno1));
        count_pea_medio1.setText(Integer.toString(pea_medio1));
        count_pea_grande1.setText(Integer.toString(pea_grande1));

    }

    //Verifica se é possível escrever na memória externa
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    // Verifica se a app tem permissões para escrever na memória
    public boolean checkPermission (String permission){
        int check = ContextCompat.checkSelfPermission(this,permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }


    //Faz Reset à base de dados
    public void reset (View view){
        mDatabaseHelper.deleteData();
        toastMessage("Base de Dados Limpa!");
    }



    public void gravarcsv(View view) {

        final Cursor cursor = mDatabaseHelper.getData();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US);
        Date now = new Date();
        String fileName = "residuos_" + formatter.format(now) + ".csv";
        StringBuilder bld = new StringBuilder();

        if(isExternalStorageWritable() && checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            if (cursor.moveToFirst()) {
                do {
                    String Rua = cursor.getString(cursor.getColumnIndex("rua"));
                    String Residuos = cursor.getString(cursor.getColumnIndex("residuos"));
                    String Area = cursor.getString(cursor.getColumnIndex("area"));
                    String PeaPequeno1 = Integer.toString(cursor.getInt(cursor.getColumnIndex("pea_pequeno_1")));
                    String PeaMedio1 = Integer.toString(cursor.getInt(cursor.getColumnIndex("pea_medio_1")));
                    String PeaGrande1 = Integer.toString(cursor.getInt(cursor.getColumnIndex("pea_grande_1")));

                    bld.append(Rua + "," + Residuos + "," + Area + "," + PeaPequeno1 + "," + PeaMedio1 + "," + PeaGrande1 + "\n");


                } while (cursor.moveToNext());
            }

            String dados = bld.toString();

            //closing cursor
            cursor.close();


            File textFile = new File (Environment.getExternalStorageDirectory(),fileName);
            FileOutputStream fos = null;

            try {
                fos = new FileOutputStream(textFile);
                fos.write(dados.getBytes());

                Toast.makeText(this, "Saved to " + textFile,
                        Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else{
            Toast.makeText(this, "Não consegue escrever no Armazenamento externo",
                    Toast.LENGTH_LONG).show();
        }





    }
}