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
import android.widget.CheckBox;
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

    //Bool para checkboxes
    boolean pa = false;
    boolean cf = false;
    boolean bl = false;
    
    int pan = 0;
    int cfn = 0;
    int bln = 0;

    //Variáveis para realizar as contagens - RUA
    private int pea_pequeno_rua = 0;
    private int pea_medio_rua = 0;
    private int pea_grande_rua = 0;
    private int pena_pequeno_rua = 0;
    private int pena_medio_rua = 0;
    private int pena_grande_rua = 0;
    private int pedacos_vidro_rua = 0;
    private int garrafapeq_vidro_rua = 0;
    private int garrafagra_vidro_rua = 0;
    private int cigarros_rua = 0;
    private int dejetos_rua = 0;
    private int indiferenciados_rua = 0;
    private int folhas_rua = 0;
    private int rampequenas_rua = 0;
    private int ramgrandes_rua = 0;
    private int pastilhas_rua = 0;
    private int past_ate500_rua = 0;
    private int past_maior500_rua = 0;
    private int ra_pequeno_rua = 0;
    private int ra_medio_rua = 0;
    private int ra_grande_rua = 0;
    private int oro_pequeno_rua = 0;
    private int oro_medio_rua = 0;
    private int oro_grande_rua = 0;
    private int latas_metais_rua = 0;
    private int outros_metais_rua = 0;


    //Variáveis para realizar as contagens - Placas Ajardinadas PA
    private int pea_pequeno_pa = 0;
    private int pea_medio_pa = 0;
    private int pea_grande_pa = 0;
    private int pena_pequeno_pa = 0;
    private int pena_medio_pa = 0;
    private int pena_grande_pa = 0;
    private int pedacos_vidro_pa = 0;
    private int garrafapeq_vidro_pa = 0;
    private int garrafagra_vidro_pa = 0;
    private int cigarros_pa = 0;
    private int dejetos_pa = 0;
    private int indiferenciados_pa = 0;
    private int folhas_pa = 0;
    private int rampequenas_pa = 0;
    private int ramgrandes_pa = 0;
    private int pastilhas_pa = 0;
    private int past_ate500_pa = 0;
    private int past_maior500_pa = 0;
    private int ra_pequeno_pa = 0;
    private int ra_medio_pa = 0;
    private int ra_grande_pa = 0;
    private int oro_pequeno_pa = 0;
    private int oro_medio_pa = 0;
    private int oro_grande_pa = 0;
    private int latas_metais_pa = 0;
    private int outros_metais_pa = 0;


    //Variáveis para realizar as contagens - Caldeiras Floreiras CF
    private int pea_pequeno_cf = 0;
    private int pea_medio_cf = 0;
    private int pea_grande_cf = 0;
    private int pena_pequeno_cf = 0;
    private int pena_medio_cf = 0;
    private int pena_grande_cf = 0;
    private int pedacos_vidro_cf = 0;
    private int garrafapeq_vidro_cf = 0;
    private int garrafagra_vidro_cf = 0;
    private int cigarros_cf = 0;
    private int dejetos_cf = 0;
    private int indiferenciados_cf = 0;
    private int folhas_cf = 0;
    private int rampequenas_cf = 0;
    private int ramgrandes_cf = 0;
    private int pastilhas_cf = 0;
    private int past_ate500_cf = 0;
    private int past_maior500_cf = 0;
    private int ra_pequeno_cf = 0;
    private int ra_medio_cf = 0;
    private int ra_grande_cf = 0;
    private int oro_pequeno_cf = 0;
    private int oro_medio_cf = 0;
    private int oro_grande_cf = 0;
    private int latas_metais_cf = 0;
    private int outros_metais_cf = 0;

    //Para ver os counters - RUA
    private TextView count_pea_pequeno_rua;
    private TextView count_pea_medio_rua;
    private TextView count_pea_grande_rua;
    private TextView count_pena_pequeno_rua;
    private TextView count_pena_medio_rua;
    private TextView count_pena_grande_rua;
    private TextView count_pedacos_vidro_rua;
    private TextView count_garrafapeq_vidro_rua;
    private TextView count_garrafagra_vidro_rua;
    private TextView count_cigarros_rua;
    private TextView count_dejetos_rua;
    private TextView count_indiferenciados_rua;
    private TextView count_folhas_rua;
    private TextView count_rampequenas_rua;
    private TextView count_ramgrandes_rua;
    private TextView count_pastilhas_rua;
    private TextView count_past_ate500_rua;
    private TextView count_past_maior500_rua;
    private TextView count_ra_pequeno_rua;
    private TextView count_ra_medio_rua;
    private TextView count_ra_grande_rua;
    private TextView count_oro_pequeno_rua;
    private TextView count_oro_medio_rua;
    private TextView count_oro_grande_rua;
    private TextView count_latas_metais_rua;
    private TextView count_outros_metais_rua;


    //Para ver os counters - Placas ajardinadas PA
    private TextView count_pea_pequeno_pa;
    private TextView count_pea_medio_pa;
    private TextView count_pea_grande_pa;
    private TextView count_pena_pequeno_pa;
    private TextView count_pena_medio_pa;
    private TextView count_pena_grande_pa;
    private TextView count_pedacos_vidro_pa;
    private TextView count_garrafapeq_vidro_pa;
    private TextView count_garrafagra_vidro_pa;
    private TextView count_cigarros_pa;
    private TextView count_dejetos_pa;
    private TextView count_indiferenciados_pa;
    private TextView count_folhas_pa;
    private TextView count_rampequenas_pa;
    private TextView count_ramgrandes_pa;
    private TextView count_pastilhas_pa;
    private TextView count_past_ate500_pa;
    private TextView count_past_maior500_pa;
    private TextView count_ra_pequeno_pa;
    private TextView count_ra_medio_pa;
    private TextView count_ra_grande_pa;
    private TextView count_oro_pequeno_pa;
    private TextView count_oro_medio_pa;
    private TextView count_oro_grande_pa;
    private TextView count_latas_metais_pa;
    private TextView count_outros_metais_pa;


    //Para ver os counters - Caldeiras Floreiras - CF
    private TextView count_pea_pequeno_cf;
    private TextView count_pea_medio_cf;
    private TextView count_pea_grande_cf;
    private TextView count_pena_pequeno_cf;
    private TextView count_pena_medio_cf;
    private TextView count_pena_grande_cf;
    private TextView count_pedacos_vidro_cf;
    private TextView count_garrafapeq_vidro_cf;
    private TextView count_garrafagra_vidro_cf;
    private TextView count_cigarros_cf;
    private TextView count_dejetos_cf;
    private TextView count_indiferenciados_cf;
    private TextView count_folhas_cf;
    private TextView count_rampequenas_cf;
    private TextView count_ramgrandes_cf;
    private TextView count_pastilhas_cf;
    private TextView count_past_ate500_cf;
    private TextView count_past_maior500_cf;
    private TextView count_ra_pequeno_cf;
    private TextView count_ra_medio_cf;
    private TextView count_ra_grande_cf;
    private TextView count_oro_pequeno_cf;
    private TextView count_oro_medio_cf;
    private TextView count_oro_grande_cf;
    private TextView count_latas_metais_cf;
    private TextView count_outros_metais_cf;









    //Bocas de Lobo e Papeleiras
    private int bocalobolimpa_bl = 0;
    private int bocalobosuja_bl = 0;
    private int bocalobototal_bl = 0;
    private int papeleirasvazia_bl = 0;
    private int papeleirascheias_bl = 0;
    private int papeleirastotal_bl = 0;




    private TextView count_bocalobolimpa_bl;
    private TextView count_bocalobosuja_bl;
    private TextView count_bocalobototal_bl;
    private TextView count_papeleirasvazia_bl;
    private TextView count_papeleirascheias_bl;
    private TextView count_papeleirastotal_bl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabaseHelper = new DatabaseHelper(this);
        TabHost tabs = (TabHost) findViewById(R.id.tabhost);
        tabs.setup();


        //RUA//
        count_pea_pequeno_rua = (TextView) findViewById(R.id.pea_pequeno_count_rua);
        count_pea_medio_rua = (TextView) findViewById(R.id.pea_medio_count_rua);
        count_pea_grande_rua = (TextView) findViewById(R.id.pea_grande_count_rua);

        count_pena_pequeno_rua = (TextView) findViewById(R.id.pena_pequeno_count_rua);
        count_pena_medio_rua = (TextView) findViewById(R.id.pena_medio_count_rua);
        count_pena_grande_rua = (TextView) findViewById(R.id.pena_grande_count_rua);

        count_pedacos_vidro_rua = (TextView) findViewById(R.id.pedacos_vidro_rua);
        count_garrafapeq_vidro_rua = (TextView) findViewById(R.id.garrafapeq_vidro_rua);
        count_garrafagra_vidro_rua = (TextView) findViewById(R.id.garrafagra_vidro_rua);

        count_cigarros_rua = (TextView) findViewById(R.id.cigarros_rua);
        count_dejetos_rua = (TextView) findViewById(R.id.dejetos_rua);
        count_indiferenciados_rua = (TextView) findViewById(R.id.indiferenciados_rua);

        count_folhas_rua = (TextView) findViewById(R.id.folhas_rua);
        count_rampequenas_rua = (TextView) findViewById(R.id.rampequenas_rua);
        count_ramgrandes_rua = (TextView) findViewById(R.id.ramgrandes_rua);

        count_pastilhas_rua = (TextView) findViewById(R.id.pastilhas_rua);
        count_past_ate500_rua = (TextView) findViewById(R.id.past_ate500_rua);
        count_past_maior500_rua = (TextView) findViewById(R.id.past_maior500_rua);

        count_ra_pequeno_rua = (TextView) findViewById(R.id.ra_pequeno_rua);
        count_ra_medio_rua = (TextView) findViewById(R.id.ra_medio_rua);
        count_ra_grande_rua = (TextView) findViewById(R.id.ra_grande_rua);

        count_oro_pequeno_rua = (TextView) findViewById(R.id.oro_pequeno_rua);
        count_oro_medio_rua = (TextView) findViewById(R.id.oro_medio_rua);
        count_oro_grande_rua = (TextView) findViewById(R.id.oro_grande_rua);

        count_latas_metais_rua = (TextView) findViewById(R.id.latas_metais_rua);
        count_outros_metais_rua = (TextView) findViewById(R.id.outros_metais_rua);

        //PLACAS AJARDINADAS//
        count_pea_pequeno_pa = (TextView) findViewById(R.id.pea_pequeno_count_pa);
        count_pea_medio_pa = (TextView) findViewById(R.id.pea_medio_count_pa);
        count_pea_grande_pa = (TextView) findViewById(R.id.pea_grande_count_pa);

        count_pena_pequeno_pa = (TextView) findViewById(R.id.pena_pequeno_count_pa);
        count_pena_medio_pa = (TextView) findViewById(R.id.pena_medio_count_pa);
        count_pena_grande_pa = (TextView) findViewById(R.id.pena_grande_count_pa);

        count_pedacos_vidro_pa = (TextView) findViewById(R.id.pedacos_vidro_pa);
        count_garrafapeq_vidro_pa = (TextView) findViewById(R.id.garrafapeq_vidro_pa);
        count_garrafagra_vidro_pa = (TextView) findViewById(R.id.garrafagra_vidro_pa);

        count_cigarros_pa = (TextView) findViewById(R.id.cigarros_pa);
        count_dejetos_pa = (TextView) findViewById(R.id.dejetos_pa);
        count_indiferenciados_pa = (TextView) findViewById(R.id.indiferenciados_pa);

        count_folhas_pa = (TextView) findViewById(R.id.folhas_pa);
        count_rampequenas_pa = (TextView) findViewById(R.id.rampequenas_pa);
        count_ramgrandes_pa = (TextView) findViewById(R.id.ramgrandes_pa);

        count_pastilhas_pa = (TextView) findViewById(R.id.pastilhas_pa);
        count_past_ate500_pa = (TextView) findViewById(R.id.past_ate500_pa);
        count_past_maior500_pa = (TextView) findViewById(R.id.past_maior500_pa);

        count_ra_pequeno_pa = (TextView) findViewById(R.id.ra_pequeno_pa);
        count_ra_medio_pa = (TextView) findViewById(R.id.ra_medio_pa);
        count_ra_grande_pa = (TextView) findViewById(R.id.ra_grande_pa);

        count_oro_pequeno_pa = (TextView) findViewById(R.id.oro_pequeno_pa);
        count_oro_medio_pa = (TextView) findViewById(R.id.oro_medio_pa);
        count_oro_grande_pa = (TextView) findViewById(R.id.oro_grande_pa);

        count_latas_metais_pa = (TextView) findViewById(R.id.latas_metais_pa);
        count_outros_metais_pa = (TextView) findViewById(R.id.outros_metais_pa);


        //CALDEIRAS FLOREIRAS//
        count_pea_pequeno_cf = (TextView) findViewById(R.id.pea_pequeno_count_cf);
        count_pea_medio_cf = (TextView) findViewById(R.id.pea_medio_count_cf);
        count_pea_grande_cf = (TextView) findViewById(R.id.pea_grande_count_cf);

        count_pena_pequeno_cf = (TextView) findViewById(R.id.pena_pequeno_count_cf);
        count_pena_medio_cf = (TextView) findViewById(R.id.pena_medio_count_cf);
        count_pena_grande_cf = (TextView) findViewById(R.id.pena_grande_count_cf);

        count_pedacos_vidro_cf = (TextView) findViewById(R.id.pedacos_vidro_cf);
        count_garrafapeq_vidro_cf = (TextView) findViewById(R.id.garrafapeq_vidro_cf);
        count_garrafagra_vidro_cf = (TextView) findViewById(R.id.garrafagra_vidro_cf);

        count_cigarros_cf = (TextView) findViewById(R.id.cigarros_cf);
        count_dejetos_cf = (TextView) findViewById(R.id.dejetos_cf);
        count_indiferenciados_cf = (TextView) findViewById(R.id.indiferenciados_cf);

        count_folhas_cf = (TextView) findViewById(R.id.folhas_cf);
        count_rampequenas_cf = (TextView) findViewById(R.id.rampequenas_cf);
        count_ramgrandes_cf = (TextView) findViewById(R.id.ramgrandes_cf);

        count_pastilhas_cf = (TextView) findViewById(R.id.pastilhas_cf);
        count_past_ate500_cf = (TextView) findViewById(R.id.past_ate500_cf);
        count_past_maior500_cf = (TextView) findViewById(R.id.past_maior500_cf);

        count_ra_pequeno_cf = (TextView) findViewById(R.id.ra_pequeno_cf);
        count_ra_medio_cf = (TextView) findViewById(R.id.ra_medio_cf);
        count_ra_grande_cf = (TextView) findViewById(R.id.ra_grande_cf);

        count_oro_pequeno_cf = (TextView) findViewById(R.id.oro_pequeno_cf);
        count_oro_medio_cf = (TextView) findViewById(R.id.oro_medio_cf);
        count_oro_grande_cf = (TextView) findViewById(R.id.oro_grande_cf);

        count_latas_metais_cf = (TextView) findViewById(R.id.latas_metais_cf);
        count_outros_metais_cf = (TextView) findViewById(R.id.outros_metais_cf);



        //Bocas de Lobo e papeleiras

        count_bocalobolimpa_bl = (TextView) findViewById(R.id.bocalobolimpa_bl);
        count_bocalobosuja_bl = (TextView) findViewById(R.id.bocalobosuja_bl);
        count_bocalobototal_bl = (TextView) findViewById(R.id.bocalobototal_bl);
        count_papeleirasvazia_bl = (TextView) findViewById(R.id.papeleirasvazia_bl);
        count_papeleirascheias_bl = (TextView) findViewById(R.id.papeleirascheias_bl);
        count_papeleirastotal_bl = (TextView) findViewById(R.id.papeleirastotal_bl);


        mRuas = findViewById(R.id.editText_rua);
        mResiduos = findViewById(R.id.editText_amostra);
        mAreas = findViewById(R.id.editText_area);


        TabHost.TabSpec spec = tabs.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Dados");
        tabs.addTab(spec);
        spec = tabs.newTabSpec("tag2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("PG");
        tabs.addTab(spec);
        spec = tabs.newTabSpec("tag3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("PA");
        tabs.addTab(spec);
        spec = tabs.newTabSpec("tag4");
        spec.setContent(R.id.tab4);
        spec.setIndicator("CF");
        tabs.addTab(spec);
        spec = tabs.newTabSpec("tag5");
        spec.setContent(R.id.tab5);
        spec.setIndicator("BL/Ppl");
        tabs.addTab(spec);

    }


    ////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////FUNCOES RUA/////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////


    // PEA PEQUENO PLUS & MINUS
    public void minus_pea_pequeno_rua(View view) {
        if (pea_pequeno_rua > 0) {
            pea_pequeno_rua--;
            if (count_pea_pequeno_rua != null)
                count_pea_pequeno_rua.setText(Integer.toString(pea_pequeno_rua));
        }

    }

    public void plus_pea_pequeno_rua(View view) {
        pea_pequeno_rua++;
        if (count_pea_pequeno_rua != null)
            count_pea_pequeno_rua.setText(Integer.toString(pea_pequeno_rua));
    }

    // PEA MEDIO PLUS & MINUS
    public void minus_pea_medio_rua(View view) {
        if (pea_medio_rua > 0) {
            pea_medio_rua--;
            if (count_pea_medio_rua != null)
                count_pea_medio_rua.setText(Integer.toString(pea_medio_rua));
        }

    }

    public void plus_pea_medio_rua(View view) {
        pea_medio_rua++;
        if (count_pea_medio_rua != null)
            count_pea_medio_rua.setText(Integer.toString(pea_medio_rua));
    }

    // PEA GRANDE PLUS & MINUS
    public void minus_pea_grande_rua(View view) {
        if (pea_grande_rua > 0) {
            pea_grande_rua--;
            if (count_pea_grande_rua != null)
                count_pea_grande_rua.setText(Integer.toString(pea_grande_rua));
        }

    }

    public void plus_pea_grande_rua(View view) {
        pea_grande_rua++;
        if (count_pea_grande_rua != null)
            count_pea_grande_rua.setText(Integer.toString(pea_grande_rua));
    }

    public void minus_pena_pequeno_rua(View view) {
        if (pena_pequeno_rua > 0) {
            pena_pequeno_rua--;
            if (count_pena_pequeno_rua != null)
                count_pena_pequeno_rua.setText(Integer.toString(pena_pequeno_rua));
        }
    }

    public void plus_pena_pequeno_rua(View view) {
        pena_pequeno_rua++;
        if (count_pena_pequeno_rua != null)
            count_pena_pequeno_rua.setText(Integer.toString(pena_pequeno_rua));
    }

    public void minus_pena_medio_rua(View view) {
        if (pena_medio_rua > 0) {
            pena_medio_rua--;
            if (count_pena_medio_rua != null)
                count_pena_medio_rua.setText(Integer.toString(pena_medio_rua));
        }
    }

    public void plus_pena_medio_rua(View view) {
        pena_medio_rua++;
        if (count_pena_medio_rua != null)
            count_pena_medio_rua.setText(Integer.toString(pena_medio_rua));
    }

    public void minus_pena_grande_rua(View view) {
        if (pena_grande_rua > 0) {
            pena_grande_rua--;
            if (count_pena_grande_rua != null)
                count_pena_grande_rua.setText(Integer.toString(pena_grande_rua));
        }
    }

    public void plus_pena_grande_rua(View view) {
        pena_grande_rua++;
        if (count_pena_grande_rua != null)
            count_pena_grande_rua.setText(Integer.toString(pena_grande_rua));
    }

    public void minus_pedacos_vidro_rua(View view) {
        if (pedacos_vidro_rua > 0) {
            pedacos_vidro_rua--;
            if (count_pedacos_vidro_rua != null)
                count_pedacos_vidro_rua.setText(Integer.toString(pedacos_vidro_rua));
        }
    }

    public void plus_pedacos_vidro_rua(View view) {
        pedacos_vidro_rua++;
        if (count_pedacos_vidro_rua != null)
            count_pedacos_vidro_rua.setText(Integer.toString(pedacos_vidro_rua));
    }

    public void minus_garrafapeq_vidro_rua(View view) {
        if (garrafapeq_vidro_rua > 0) {
            garrafapeq_vidro_rua--;
            if (count_garrafapeq_vidro_rua != null)
                count_garrafapeq_vidro_rua.setText(Integer.toString(garrafapeq_vidro_rua));
        }
    }

    public void plus_garrafapeq_vidro_rua(View view) {
        garrafapeq_vidro_rua++;
        if (count_garrafapeq_vidro_rua != null)
            count_garrafapeq_vidro_rua.setText(Integer.toString(garrafapeq_vidro_rua));
    }

    public void minus_garrafagra_vidro_rua(View view) {
        if (garrafagra_vidro_rua > 0) {
            garrafagra_vidro_rua--;
            if (count_garrafagra_vidro_rua != null)
                count_garrafagra_vidro_rua.setText(Integer.toString(garrafagra_vidro_rua));
        }
    }

    public void plus_garrafagra_vidro_rua(View view) {
        garrafagra_vidro_rua++;
        if (count_garrafagra_vidro_rua != null)
            count_garrafagra_vidro_rua.setText(Integer.toString(garrafagra_vidro_rua));
    }


    public void minus_cigarros_rua(View view) {
        if (cigarros_rua > 0) {
            cigarros_rua--;
            if (count_cigarros_rua != null)
                count_cigarros_rua.setText(Integer.toString(cigarros_rua));
        }
    }

    public void plus_cigarros_rua(View view) {
        cigarros_rua++;
        if (count_cigarros_rua != null)
            count_cigarros_rua.setText(Integer.toString(cigarros_rua));
    }

    public void minus_dejetos_rua(View view) {
        if (dejetos_rua > 0) {
            dejetos_rua--;
            if (count_dejetos_rua != null)
                count_dejetos_rua.setText(Integer.toString(dejetos_rua));
        }
    }

    public void plus_dejetos_rua(View view) {
        dejetos_rua++;
        if (count_dejetos_rua != null)
            count_dejetos_rua.setText(Integer.toString(dejetos_rua));
    }

    public void minus_indiferenciados_rua(View view) {
        if (indiferenciados_rua > 0) {
            indiferenciados_rua--;
            if (count_indiferenciados_rua != null)
                count_indiferenciados_rua.setText(Integer.toString(indiferenciados_rua));
        }
    }

    public void plus_indiferenciados_rua(View view) {
        indiferenciados_rua++;
        if (count_indiferenciados_rua != null)
            count_indiferenciados_rua.setText(Integer.toString(indiferenciados_rua));
    }

    public void minus_folhas_rua(View view) {
        if (folhas_rua > 0) {
            folhas_rua--;
            if (count_folhas_rua != null)
                count_folhas_rua.setText(Integer.toString(folhas_rua));
        }
    }

    public void plus_folhas_rua(View view) {
        folhas_rua++;
        if (count_folhas_rua != null)
            count_folhas_rua.setText(Integer.toString(folhas_rua));
    }

    public void minus_rampequenas_rua(View view) {
        if (rampequenas_rua > 0) {
            rampequenas_rua--;
            if (count_rampequenas_rua != null)
                count_rampequenas_rua.setText(Integer.toString(rampequenas_rua));
        }
    }

    public void plus_rampequenas_rua(View view) {
        rampequenas_rua++;
        if (count_rampequenas_rua != null)
            count_rampequenas_rua.setText(Integer.toString(rampequenas_rua));
    }

    public void minus_ramgrandes_rua(View view) {
        if (ramgrandes_rua > 0) {
            ramgrandes_rua--;
            if (count_ramgrandes_rua != null)
                count_ramgrandes_rua.setText(Integer.toString(ramgrandes_rua));
        }
    }

    public void plus_ramgrandes_rua(View view) {
        ramgrandes_rua++;
        if (count_ramgrandes_rua != null)
            count_ramgrandes_rua.setText(Integer.toString(ramgrandes_rua));
    }

    public void minus_pastilhas_rua(View view) {
        if (pastilhas_rua > 0) {
            pastilhas_rua--;
            if (count_pastilhas_rua != null)
                count_pastilhas_rua.setText(Integer.toString(pastilhas_rua));
        }
    }

    public void plus_pastilhas_rua(View view) {
        pastilhas_rua++;
        if (count_pastilhas_rua != null)
            count_pastilhas_rua.setText(Integer.toString(pastilhas_rua));
    }

    public void minus_past_ate500_rua(View view) {
        if (past_ate500_rua > 0) {
            past_ate500_rua--;
            if (count_past_ate500_rua != null)
                count_past_ate500_rua.setText(Integer.toString(past_ate500_rua));
        }
    }

    public void plus_past_ate500_rua(View view) {
        past_ate500_rua++;
        if (count_past_ate500_rua != null)
            count_past_ate500_rua.setText(Integer.toString(past_ate500_rua));

    }

    public void minus_past_maior500_rua(View view) {
        if (past_maior500_rua > 0) {
            past_maior500_rua--;
            if (count_past_maior500_rua != null)
                count_past_maior500_rua.setText(Integer.toString(past_maior500_rua));
        }
    }

    public void plus_past_maior500_rua(View view) {
        past_maior500_rua++;
        if (count_past_maior500_rua != null)
            count_past_maior500_rua.setText(Integer.toString(past_maior500_rua));
    }

    public void minus_ra_pequeno_rua(View view) {
        if (ra_pequeno_rua > 0) {
            ra_pequeno_rua--;
            if (count_ra_pequeno_rua != null)
                count_ra_pequeno_rua.setText(Integer.toString(ra_pequeno_rua));
        }
    }

    public void plus_ra_pequeno_rua(View view) {
        ra_pequeno_rua++;
        if (count_ra_pequeno_rua != null)
            count_ra_pequeno_rua.setText(Integer.toString(ra_pequeno_rua));
    }

    public void minus_ra_medio_rua(View view) {
        if (ra_medio_rua > 0) {
            ra_medio_rua--;
            if (count_ra_medio_rua != null)
                count_ra_medio_rua.setText(Integer.toString(ra_medio_rua));
        }
    }

    public void plus_ra_medio_rua(View view) {
        ra_medio_rua++;
        if (count_ra_medio_rua != null)
            count_ra_medio_rua.setText(Integer.toString(ra_medio_rua));
    }

    public void minus_ra_grande_rua(View view) {
        if (ra_grande_rua > 0) {
            ra_grande_rua--;
            if (count_ra_grande_rua != null)
                count_ra_grande_rua.setText(Integer.toString(ra_grande_rua));
        }
    }

    public void plus_ra_grande_rua(View view) {
        ra_grande_rua++;
        if (count_ra_grande_rua != null)
            count_ra_grande_rua.setText(Integer.toString(ra_grande_rua));
    }

    public void minus_oro_pequeno_rua(View view) {
        if (oro_pequeno_rua > 0) {
            oro_pequeno_rua--;
            if (count_oro_pequeno_rua != null)
                count_oro_pequeno_rua.setText(Integer.toString(oro_pequeno_rua));
        }
    }

    public void plus_oro_pequeno_rua(View view) {
        oro_pequeno_rua++;
        if (count_oro_pequeno_rua != null)
            count_oro_pequeno_rua.setText(Integer.toString(oro_pequeno_rua));
    }

    public void minus_oro_medio_rua(View view) {
        if (oro_medio_rua > 0) {
            oro_medio_rua--;
            if (count_oro_medio_rua != null)
                count_oro_medio_rua.setText(Integer.toString(oro_medio_rua));
        }
    }

    public void plus_oro_medio_rua(View view) {
        oro_medio_rua++;
        if (count_oro_medio_rua != null)
            count_oro_medio_rua.setText(Integer.toString(oro_medio_rua));
    }

    public void minus_oro_grande_rua(View view) {
        if (oro_grande_rua > 0) {
            oro_grande_rua--;
            if (count_oro_grande_rua != null)
                count_oro_grande_rua.setText(Integer.toString(oro_grande_rua));
        }
    }

    public void plus_oro_grande_rua(View view) {
        oro_grande_rua++;
        if (count_oro_grande_rua != null)
            count_oro_grande_rua.setText(Integer.toString(oro_grande_rua));
    }

    public void minus_latas_metais_rua(View view) {
        if (latas_metais_rua > 0) {
            latas_metais_rua--;
            if (count_latas_metais_rua != null)
                count_latas_metais_rua.setText(Integer.toString(latas_metais_rua));
        }
    }

    public void plus_latas_metais_rua(View view) {
        latas_metais_rua++;
        if (count_latas_metais_rua != null)
            count_latas_metais_rua.setText(Integer.toString(latas_metais_rua));
    }

    public void minus_outros_metais_rua(View view) {
        if (outros_metais_rua > 0) {
            outros_metais_rua--;
            if (count_outros_metais_rua != null)
                count_outros_metais_rua.setText(Integer.toString(outros_metais_rua));
        }
    }

    public void plus_outros_metais_rua(View view) {
        outros_metais_rua++;
        if (count_outros_metais_rua != null)
            count_outros_metais_rua.setText(Integer.toString(outros_metais_rua));
    }


    ////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////FUNCOES PLACAS AJARDINADAS//////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////


    // PEA PEQUENO PLUS & MINUS
    public void minus_pea_pequeno_pa(View view) {
        if (pea_pequeno_pa > 0) {
            pea_pequeno_pa--;
            if (count_pea_pequeno_pa != null)
                count_pea_pequeno_pa.setText(Integer.toString(pea_pequeno_pa));
        }

    }

    public void plus_pea_pequeno_pa(View view) {
        pea_pequeno_pa++;
        if (count_pea_pequeno_pa != null)
            count_pea_pequeno_pa.setText(Integer.toString(pea_pequeno_pa));
    }

    // PEA MEDIO PLUS & MINUS
    public void minus_pea_medio_pa(View view) {
        if (pea_medio_pa > 0) {
            pea_medio_pa--;
            if (count_pea_medio_pa != null)
                count_pea_medio_pa.setText(Integer.toString(pea_medio_pa));
        }

    }

    public void plus_pea_medio_pa(View view) {
        pea_medio_pa++;
        if (count_pea_medio_pa != null)
            count_pea_medio_pa.setText(Integer.toString(pea_medio_pa));
    }

    // PEA GRANDE PLUS & MINUS
    public void minus_pea_grande_pa(View view) {
        if (pea_grande_pa > 0) {
            pea_grande_pa--;
            if (count_pea_grande_pa != null)
                count_pea_grande_pa.setText(Integer.toString(pea_grande_pa));
        }

    }

    public void plus_pea_grande_pa(View view) {
        pea_grande_pa++;
        if (count_pea_grande_pa != null)
            count_pea_grande_pa.setText(Integer.toString(pea_grande_pa));
    }

    public void minus_pena_pequeno_pa(View view) {
        if (pena_pequeno_pa > 0) {
            pena_pequeno_pa--;
            if (count_pena_pequeno_pa != null)
                count_pena_pequeno_pa.setText(Integer.toString(pena_pequeno_pa));
        }
    }

    public void plus_pena_pequeno_pa(View view) {
        pena_pequeno_pa++;
        if (count_pena_pequeno_pa != null)
            count_pena_pequeno_pa.setText(Integer.toString(pena_pequeno_pa));
    }

    public void minus_pena_medio_pa(View view) {
        if (pena_medio_pa > 0) {
            pena_medio_pa--;
            if (count_pena_medio_pa != null)
                count_pena_medio_pa.setText(Integer.toString(pena_medio_pa));
        }
    }

    public void plus_pena_medio_pa(View view) {
        pena_medio_pa++;
        if (count_pena_medio_pa != null)
            count_pena_medio_pa.setText(Integer.toString(pena_medio_pa));
    }

    public void minus_pena_grande_pa(View view) {
        if (pena_grande_pa > 0) {
            pena_grande_pa--;
            if (count_pena_grande_pa != null)
                count_pena_grande_pa.setText(Integer.toString(pena_grande_pa));
        }
    }

    public void plus_pena_grande_pa(View view) {
        pena_grande_pa++;
        if (count_pena_grande_pa != null)
            count_pena_grande_pa.setText(Integer.toString(pena_grande_pa));
    }

    public void minus_pedacos_vidro_pa(View view) {
        if (pedacos_vidro_pa > 0) {
            pedacos_vidro_pa--;
            if (count_pedacos_vidro_pa != null)
                count_pedacos_vidro_pa.setText(Integer.toString(pedacos_vidro_pa));
        }
    }

    public void plus_pedacos_vidro_pa(View view) {
        pedacos_vidro_pa++;
        if (count_pedacos_vidro_pa != null)
            count_pedacos_vidro_pa.setText(Integer.toString(pedacos_vidro_pa));
    }

    public void minus_garrafapeq_vidro_pa(View view) {
        if (garrafapeq_vidro_pa > 0) {
            garrafapeq_vidro_pa--;
            if (count_garrafapeq_vidro_pa != null)
                count_garrafapeq_vidro_pa.setText(Integer.toString(garrafapeq_vidro_pa));
        }
    }

    public void plus_garrafapeq_vidro_pa(View view) {
        garrafapeq_vidro_pa++;
        if (count_garrafapeq_vidro_pa != null)
            count_garrafapeq_vidro_pa.setText(Integer.toString(garrafapeq_vidro_pa));
    }

    public void minus_garrafagra_vidro_pa(View view) {
        if (garrafagra_vidro_pa > 0) {
            garrafagra_vidro_pa--;
            if (count_garrafagra_vidro_pa != null)
                count_garrafagra_vidro_pa.setText(Integer.toString(garrafagra_vidro_pa));
        }
    }

    public void plus_garrafagra_vidro_pa(View view) {
        garrafagra_vidro_pa++;
        if (count_garrafagra_vidro_pa != null)
            count_garrafagra_vidro_pa.setText(Integer.toString(garrafagra_vidro_pa));
    }


    public void minus_cigarros_pa(View view) {
        if (cigarros_pa > 0) {
            cigarros_pa--;
            if (count_cigarros_pa != null)
                count_cigarros_pa.setText(Integer.toString(cigarros_pa));
        }
    }

    public void plus_cigarros_pa(View view) {
        cigarros_pa++;
        if (count_cigarros_pa != null)
            count_cigarros_pa.setText(Integer.toString(cigarros_pa));
    }

    public void minus_dejetos_pa(View view) {
        if (dejetos_pa > 0) {
            dejetos_pa--;
            if (count_dejetos_pa != null)
                count_dejetos_pa.setText(Integer.toString(dejetos_pa));
        }
    }

    public void plus_dejetos_pa(View view) {
        dejetos_pa++;
        if (count_dejetos_pa != null)
            count_dejetos_pa.setText(Integer.toString(dejetos_pa));
    }

    public void minus_indiferenciados_pa(View view) {
        if (indiferenciados_pa > 0) {
            indiferenciados_pa--;
            if (count_indiferenciados_pa != null)
                count_indiferenciados_pa.setText(Integer.toString(indiferenciados_pa));
        }
    }

    public void plus_indiferenciados_pa(View view) {
        indiferenciados_pa++;
        if (count_indiferenciados_pa != null)
            count_indiferenciados_pa.setText(Integer.toString(indiferenciados_pa));
    }

    public void minus_folhas_pa(View view) {
        if (folhas_pa > 0) {
            folhas_pa--;
            if (count_folhas_pa != null)
                count_folhas_pa.setText(Integer.toString(folhas_pa));
        }
    }

    public void plus_folhas_pa(View view) {
        folhas_pa++;
        if (count_folhas_pa != null)
            count_folhas_pa.setText(Integer.toString(folhas_pa));
    }

    public void minus_rampequenas_pa(View view) {
        if (rampequenas_pa > 0) {
            rampequenas_pa--;
            if (count_rampequenas_pa != null)
                count_rampequenas_pa.setText(Integer.toString(rampequenas_pa));
        }
    }

    public void plus_rampequenas_pa(View view) {
        rampequenas_pa++;
        if (count_rampequenas_pa != null)
            count_rampequenas_pa.setText(Integer.toString(rampequenas_pa));
    }

    public void minus_ramgrandes_pa(View view) {
        if (ramgrandes_pa > 0) {
            ramgrandes_pa--;
            if (count_ramgrandes_pa != null)
                count_ramgrandes_pa.setText(Integer.toString(ramgrandes_pa));
        }
    }

    public void plus_ramgrandes_pa(View view) {
        ramgrandes_pa++;
        if (count_ramgrandes_pa != null)
            count_ramgrandes_pa.setText(Integer.toString(ramgrandes_pa));
    }

    public void minus_pastilhas_pa(View view) {
        if (pastilhas_pa > 0) {
            pastilhas_pa--;
            if (count_pastilhas_pa != null)
                count_pastilhas_pa.setText(Integer.toString(pastilhas_pa));
        }
    }

    public void plus_pastilhas_pa(View view) {
        pastilhas_pa++;
        if (count_pastilhas_pa != null)
            count_pastilhas_pa.setText(Integer.toString(pastilhas_pa));
    }

    public void minus_past_ate500_pa(View view) {
        if (past_ate500_pa > 0) {
            past_ate500_pa--;
            if (count_past_ate500_pa != null)
                count_past_ate500_pa.setText(Integer.toString(past_ate500_pa));
        }
    }

    public void plus_past_ate500_pa(View view) {
        past_ate500_pa++;
        if (count_past_ate500_pa != null)
            count_past_ate500_pa.setText(Integer.toString(past_ate500_pa));

    }

    public void minus_past_maior500_pa(View view) {
        if (past_maior500_pa > 0) {
            past_maior500_pa--;
            if (count_past_maior500_pa != null)
                count_past_maior500_pa.setText(Integer.toString(past_maior500_pa));
        }
    }

    public void plus_past_maior500_pa(View view) {
        past_maior500_pa++;
        if (count_past_maior500_pa != null)
            count_past_maior500_pa.setText(Integer.toString(past_maior500_pa));
    }

    public void minus_ra_pequeno_pa(View view) {
        if (ra_pequeno_pa > 0) {
            ra_pequeno_pa--;
            if (count_ra_pequeno_pa != null)
                count_ra_pequeno_pa.setText(Integer.toString(ra_pequeno_pa));
        }
    }

    public void plus_ra_pequeno_pa(View view) {
        ra_pequeno_pa++;
        if (count_ra_pequeno_pa != null)
            count_ra_pequeno_pa.setText(Integer.toString(ra_pequeno_pa));
    }

    public void minus_ra_medio_pa(View view) {
        if (ra_medio_pa > 0) {
            ra_medio_pa--;
            if (count_ra_medio_pa != null)
                count_ra_medio_pa.setText(Integer.toString(ra_medio_pa));
        }
    }

    public void plus_ra_medio_pa(View view) {
        ra_medio_pa++;
        if (count_ra_medio_pa != null)
            count_ra_medio_pa.setText(Integer.toString(ra_medio_pa));
    }

    public void minus_ra_grande_pa(View view) {
        if (ra_grande_pa > 0) {
            ra_grande_pa--;
            if (count_ra_grande_pa != null)
                count_ra_grande_pa.setText(Integer.toString(ra_grande_pa));
        }
    }

    public void plus_ra_grande_pa(View view) {
        ra_grande_pa++;
        if (count_ra_grande_pa != null)
            count_ra_grande_pa.setText(Integer.toString(ra_grande_pa));
    }

    public void minus_oro_pequeno_pa(View view) {
        if (oro_pequeno_pa > 0) {
            oro_pequeno_pa--;
            if (count_oro_pequeno_pa != null)
                count_oro_pequeno_pa.setText(Integer.toString(oro_pequeno_pa));
        }
    }

    public void plus_oro_pequeno_pa(View view) {
        oro_pequeno_pa++;
        if (count_oro_pequeno_pa != null)
            count_oro_pequeno_pa.setText(Integer.toString(oro_pequeno_pa));
    }

    public void minus_oro_medio_pa(View view) {
        if (oro_medio_pa > 0) {
            oro_medio_pa--;
            if (count_oro_medio_pa != null)
                count_oro_medio_pa.setText(Integer.toString(oro_medio_pa));
        }
    }

    public void plus_oro_medio_pa(View view) {
        oro_medio_pa++;
        if (count_oro_medio_pa != null)
            count_oro_medio_pa.setText(Integer.toString(oro_medio_pa));
    }

    public void minus_oro_grande_pa(View view) {
        if (oro_grande_pa > 0) {
            oro_grande_pa--;
            if (count_oro_grande_pa != null)
                count_oro_grande_pa.setText(Integer.toString(oro_grande_pa));
        }
    }

    public void plus_oro_grande_pa(View view) {
        oro_grande_pa++;
        if (count_oro_grande_pa != null)
            count_oro_grande_pa.setText(Integer.toString(oro_grande_pa));
    }

    public void minus_latas_metais_pa(View view) {
        if (latas_metais_pa > 0) {
            latas_metais_pa--;
            if (count_latas_metais_pa != null)
                count_latas_metais_pa.setText(Integer.toString(latas_metais_pa));
        }
    }

    public void plus_latas_metais_pa(View view) {
        latas_metais_pa++;
        if (count_latas_metais_pa != null)
            count_latas_metais_pa.setText(Integer.toString(latas_metais_pa));
    }

    public void minus_outros_metais_pa(View view) {
        if (outros_metais_pa > 0) {
            outros_metais_pa--;
            if (count_outros_metais_pa != null)
                count_outros_metais_pa.setText(Integer.toString(outros_metais_pa));
        }
    }

    public void plus_outros_metais_pa(View view) {
        outros_metais_pa++;
        if (count_outros_metais_pa != null)
            count_outros_metais_pa.setText(Integer.toString(outros_metais_pa));
    }


    ////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////FUNCOES CALDEIRAS FLOREIRAS/////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////


    // PEA PEQUENO PLUS & MINUS
    public void minus_pea_pequeno_cf(View view) {
        if (pea_pequeno_cf > 0) {
            pea_pequeno_cf--;
            if (count_pea_pequeno_cf != null)
                count_pea_pequeno_cf.setText(Integer.toString(pea_pequeno_cf));
        }

    }

    public void plus_pea_pequeno_cf(View view) {
        pea_pequeno_cf++;
        if (count_pea_pequeno_cf != null)
            count_pea_pequeno_cf.setText(Integer.toString(pea_pequeno_cf));
    }

    // PEA MEDIO PLUS & MINUS
    public void minus_pea_medio_cf(View view) {
        if (pea_medio_cf > 0) {
            pea_medio_cf--;
            if (count_pea_medio_cf != null)
                count_pea_medio_cf.setText(Integer.toString(pea_medio_cf));
        }

    }

    public void plus_pea_medio_cf(View view) {
        pea_medio_cf++;
        if (count_pea_medio_cf != null)
            count_pea_medio_cf.setText(Integer.toString(pea_medio_cf));
    }

    // PEA GRANDE PLUS & MINUS
    public void minus_pea_grande_cf(View view) {
        if (pea_grande_cf > 0) {
            pea_grande_cf--;
            if (count_pea_grande_cf != null)
                count_pea_grande_cf.setText(Integer.toString(pea_grande_cf));
        }

    }

    public void plus_pea_grande_cf(View view) {
        pea_grande_cf++;
        if (count_pea_grande_cf != null)
            count_pea_grande_cf.setText(Integer.toString(pea_grande_cf));
    }

    public void minus_pena_pequeno_cf(View view) {
        if (pena_pequeno_cf > 0) {
            pena_pequeno_cf--;
            if (count_pena_pequeno_cf != null)
                count_pena_pequeno_cf.setText(Integer.toString(pena_pequeno_cf));
        }
    }

    public void plus_pena_pequeno_cf(View view) {
        pena_pequeno_cf++;
        if (count_pena_pequeno_cf != null)
            count_pena_pequeno_cf.setText(Integer.toString(pena_pequeno_cf));
    }

    public void minus_pena_medio_cf(View view) {
        if (pena_medio_cf > 0) {
            pena_medio_cf--;
            if (count_pena_medio_cf != null)
                count_pena_medio_cf.setText(Integer.toString(pena_medio_cf));
        }
    }

    public void plus_pena_medio_cf(View view) {
        pena_medio_cf++;
        if (count_pena_medio_cf != null)
            count_pena_medio_cf.setText(Integer.toString(pena_medio_cf));
    }

    public void minus_pena_grande_cf(View view) {
        if (pena_grande_cf > 0) {
            pena_grande_cf--;
            if (count_pena_grande_cf != null)
                count_pena_grande_cf.setText(Integer.toString(pena_grande_cf));
        }
    }

    public void plus_pena_grande_cf(View view) {
        pena_grande_cf++;
        if (count_pena_grande_cf != null)
            count_pena_grande_cf.setText(Integer.toString(pena_grande_cf));
    }

    public void minus_pedacos_vidro_cf(View view) {
        if (pedacos_vidro_cf > 0) {
            pedacos_vidro_cf--;
            if (count_pedacos_vidro_cf != null)
                count_pedacos_vidro_cf.setText(Integer.toString(pedacos_vidro_cf));
        }
    }

    public void plus_pedacos_vidro_cf(View view) {
        pedacos_vidro_cf++;
        if (count_pedacos_vidro_cf != null)
            count_pedacos_vidro_cf.setText(Integer.toString(pedacos_vidro_cf));
    }

    public void minus_garrafapeq_vidro_cf(View view) {
        if (garrafapeq_vidro_cf > 0) {
            garrafapeq_vidro_cf--;
            if (count_garrafapeq_vidro_cf != null)
                count_garrafapeq_vidro_cf.setText(Integer.toString(garrafapeq_vidro_cf));
        }
    }

    public void plus_garrafapeq_vidro_cf(View view) {
        garrafapeq_vidro_cf++;
        if (count_garrafapeq_vidro_cf != null)
            count_garrafapeq_vidro_cf.setText(Integer.toString(garrafapeq_vidro_cf));
    }

    public void minus_garrafagra_vidro_cf(View view) {
        if (garrafagra_vidro_cf > 0) {
            garrafagra_vidro_cf--;
            if (count_garrafagra_vidro_cf != null)
                count_garrafagra_vidro_cf.setText(Integer.toString(garrafagra_vidro_cf));
        }
    }

    public void plus_garrafagra_vidro_cf(View view) {
        garrafagra_vidro_cf++;
        if (count_garrafagra_vidro_cf != null)
            count_garrafagra_vidro_cf.setText(Integer.toString(garrafagra_vidro_cf));
    }


    public void minus_cigarros_cf(View view) {
        if (cigarros_cf > 0) {
            cigarros_cf--;
            if (count_cigarros_cf != null)
                count_cigarros_cf.setText(Integer.toString(cigarros_cf));
        }
    }

    public void plus_cigarros_cf(View view) {
        cigarros_cf++;
        if (count_cigarros_cf != null)
            count_cigarros_cf.setText(Integer.toString(cigarros_cf));
    }

    public void minus_dejetos_cf(View view) {
        if (dejetos_cf > 0) {
            dejetos_cf--;
            if (count_dejetos_cf != null)
                count_dejetos_cf.setText(Integer.toString(dejetos_cf));
        }
    }

    public void plus_dejetos_cf(View view) {
        dejetos_cf++;
        if (count_dejetos_cf != null)
            count_dejetos_cf.setText(Integer.toString(dejetos_cf));
    }

    public void minus_indiferenciados_cf(View view) {
        if (indiferenciados_cf > 0) {
            indiferenciados_cf--;
            if (count_indiferenciados_cf != null)
                count_indiferenciados_cf.setText(Integer.toString(indiferenciados_cf));
        }
    }

    public void plus_indiferenciados_cf(View view) {
        indiferenciados_cf++;
        if (count_indiferenciados_cf != null)
            count_indiferenciados_cf.setText(Integer.toString(indiferenciados_cf));
    }

    public void minus_folhas_cf(View view) {
        if (folhas_cf > 0) {
            folhas_cf--;
            if (count_folhas_cf != null)
                count_folhas_cf.setText(Integer.toString(folhas_cf));
        }
    }

    public void plus_folhas_cf(View view) {
        folhas_cf++;
        if (count_folhas_cf != null)
            count_folhas_cf.setText(Integer.toString(folhas_cf));
    }

    public void minus_rampequenas_cf(View view) {
        if ( rampequenas_cf > 0) {
            rampequenas_cf--;
            if (count_rampequenas_cf != null)
                count_rampequenas_cf.setText(Integer.toString(rampequenas_cf));
        }
    }

    public void plus_rampequenas_cf(View view) {
        rampequenas_cf++;
        if (count_rampequenas_cf != null)
            count_rampequenas_cf.setText(Integer.toString(rampequenas_cf));
    }

    public void minus_ramgrandes_cf(View view) {
        if (ramgrandes_cf > 0) {
            ramgrandes_cf--;
            if (count_ramgrandes_cf != null)
                count_ramgrandes_cf.setText(Integer.toString(ramgrandes_cf));
        }
    }

    public void plus_ramgrandes_cf(View view) {
        ramgrandes_cf++;
        if (count_ramgrandes_cf != null)
            count_ramgrandes_cf.setText(Integer.toString(ramgrandes_cf));
    }

    public void minus_pastilhas_cf(View view) {
        if (pastilhas_cf > 0) {
            pastilhas_cf--;
            if (count_pastilhas_cf != null)
                count_pastilhas_cf.setText(Integer.toString(pastilhas_cf));
        }
    }

    public void plus_pastilhas_cf(View view) {
        pastilhas_cf++;
        if (count_pastilhas_cf != null)
            count_pastilhas_cf.setText(Integer.toString(pastilhas_cf));
    }

    public void minus_past_ate500_cf(View view) {
        if (past_ate500_cf > 0) {
            past_ate500_cf--;
            if (count_past_ate500_cf != null)
                count_past_ate500_cf.setText(Integer.toString(past_ate500_cf));
        }
    }

    public void plus_past_ate500_cf(View view) {
        past_ate500_cf++;
        if (count_past_ate500_cf != null)
            count_past_ate500_cf.setText(Integer.toString(past_ate500_cf));

    }

    public void minus_past_maior500_cf(View view) {
        if (past_maior500_cf > 0) {
            past_maior500_cf--;
            if (count_past_maior500_cf != null)
                count_past_maior500_cf.setText(Integer.toString(past_maior500_cf));
        }
    }

    public void plus_past_maior500_cf(View view) {
        past_maior500_cf++;
        if (count_past_maior500_cf != null)
            count_past_maior500_cf.setText(Integer.toString(past_maior500_cf));
    }

    public void minus_ra_pequeno_cf(View view) {
        if (ra_pequeno_cf > 0) {
            ra_pequeno_cf--;
            if (count_ra_pequeno_cf != null)
                count_ra_pequeno_cf.setText(Integer.toString(ra_pequeno_cf));
        }
    }

    public void plus_ra_pequeno_cf(View view) {
        ra_pequeno_cf++;
        if (count_ra_pequeno_cf != null)
            count_ra_pequeno_cf.setText(Integer.toString(ra_pequeno_cf));
    }

    public void minus_ra_medio_cf(View view) {
        if (ra_medio_cf > 0) {
            ra_medio_cf--;
            if (count_ra_medio_cf != null)
                count_ra_medio_cf.setText(Integer.toString(ra_medio_cf));
        }
    }

    public void plus_ra_medio_cf(View view) {
        ra_medio_cf++;
        if (count_ra_medio_cf != null)
            count_ra_medio_cf.setText(Integer.toString(ra_medio_cf));
    }

    public void minus_ra_grande_cf(View view) {
        if (ra_grande_cf > 0) {
            ra_grande_cf--;
            if (count_ra_grande_cf != null)
                count_ra_grande_cf.setText(Integer.toString(ra_grande_cf));
        }
    }

    public void plus_ra_grande_cf(View view) {
        ra_grande_cf++;
        if (count_ra_grande_cf != null)
            count_ra_grande_cf.setText(Integer.toString(ra_grande_cf));
    }

    public void minus_oro_pequeno_cf(View view) {
        if (oro_pequeno_cf > 0) {
            oro_pequeno_cf--;
            if (count_oro_pequeno_cf != null)
                count_oro_pequeno_cf.setText(Integer.toString(oro_pequeno_cf));
        }
    }

    public void plus_oro_pequeno_cf(View view) {
        oro_pequeno_cf++;
        if (count_oro_pequeno_cf != null)
            count_oro_pequeno_cf.setText(Integer.toString(oro_pequeno_cf));
    }

    public void minus_oro_medio_cf(View view) {
        if (oro_medio_cf > 0) {
            oro_medio_cf--;
            if (count_oro_medio_cf != null)
                count_oro_medio_cf.setText(Integer.toString(oro_medio_cf));
        }
    }

    public void plus_oro_medio_cf(View view) {
        oro_medio_cf++;
        if (count_oro_medio_cf != null)
            count_oro_medio_cf.setText(Integer.toString(oro_medio_cf));
    }

    public void minus_oro_grande_cf(View view) {
        if (oro_grande_cf > 0) {
            oro_grande_cf--;
            if (count_oro_grande_cf != null)
                count_oro_grande_cf.setText(Integer.toString(oro_grande_cf));
        }
    }

    public void plus_oro_grande_cf(View view) {
        oro_grande_cf++;
        if (count_oro_grande_cf != null)
            count_oro_grande_cf.setText(Integer.toString(oro_grande_cf));
    }

    public void minus_latas_metais_cf(View view) {
        if (latas_metais_cf > 0) {
            latas_metais_cf--;
            if (count_latas_metais_cf != null)
                count_latas_metais_cf.setText(Integer.toString(latas_metais_cf));
        }
    }

    public void plus_latas_metais_cf(View view) {
        latas_metais_cf++;
        if (count_latas_metais_cf != null)
            count_latas_metais_cf.setText(Integer.toString(latas_metais_cf));
    }

    public void minus_outros_metais_cf(View view) {
        if (outros_metais_cf > 0) {
            outros_metais_cf--;
            if (count_outros_metais_cf != null)
                count_outros_metais_cf.setText(Integer.toString(outros_metais_cf));
        }
    }

    public void plus_outros_metais_cf(View view) {
        outros_metais_cf++;
        if (count_outros_metais_cf != null)
            count_outros_metais_cf.setText(Integer.toString(outros_metais_cf));
    }


    /////////////////////////////////////////////////////////////////
    ///////////////BOCAS DE LOBO E PAPELEIRAS///////////////////////
    ///////////////////////////////////////////////////////////////

    public void minus_bocalobolimpa_bl(View view) {
        if (bocalobototal_bl > 0 && bocalobolimpa_bl > 0) {
            bocalobototal_bl--;
            bocalobolimpa_bl--;
            if (count_bocalobototal_bl != null)
                count_bocalobototal_bl.setText(Integer.toString(bocalobototal_bl));
            if (count_bocalobolimpa_bl != null)
                count_bocalobolimpa_bl.setText(Integer.toString(bocalobolimpa_bl));
        }
    }

    public void plus_bocalobolimpa_bl(View view) {
        bocalobototal_bl++;
        bocalobolimpa_bl++;
        if (count_bocalobototal_bl != null)
            count_bocalobototal_bl.setText(Integer.toString(bocalobototal_bl));
        if (count_bocalobolimpa_bl != null)
            count_bocalobolimpa_bl.setText(Integer.toString(bocalobolimpa_bl));
    }

    public void minus_bocalobosuja_bl(View view) {
        if (bocalobototal_bl > 0 && bocalobosuja_bl > 0) {
            bocalobototal_bl--;
            bocalobosuja_bl--;
            if (count_bocalobototal_bl != null)
                count_bocalobototal_bl.setText(Integer.toString(bocalobototal_bl));
            if (count_bocalobosuja_bl != null)
                count_bocalobosuja_bl.setText(Integer.toString(bocalobosuja_bl));
        }
    }

    public void plus_bocalobosuja_bl(View view) {
        bocalobototal_bl++;
        bocalobosuja_bl++;
        if (count_bocalobototal_bl != null)
            count_bocalobototal_bl.setText(Integer.toString(bocalobototal_bl));
        if (count_bocalobosuja_bl != null)
            count_bocalobosuja_bl.setText(Integer.toString(bocalobosuja_bl));
    }

    public void minus_papeleirasvazia_bl(View view) {
        if (papeleirastotal_bl > 0 && papeleirasvazia_bl > 0) {
            papeleirastotal_bl--;
            papeleirasvazia_bl--;
            if (count_papeleirastotal_bl != null)
                count_papeleirastotal_bl.setText(Integer.toString(papeleirastotal_bl));
            if (count_papeleirasvazia_bl != null)
                count_papeleirasvazia_bl.setText(Integer.toString(papeleirasvazia_bl));
        }
    }

    public void plus_papeleirasvazia_bl(View view) {
        papeleirastotal_bl++;
        papeleirasvazia_bl++;
        if (count_papeleirastotal_bl != null)
            count_papeleirastotal_bl.setText(Integer.toString(papeleirastotal_bl));
        if (count_papeleirasvazia_bl != null)
            count_papeleirasvazia_bl.setText(Integer.toString(papeleirasvazia_bl));
    }

    public void minus_papeleirascheias_bl(View view) {
        if (papeleirastotal_bl > 0 && papeleirascheias_bl > 0) {
            papeleirastotal_bl--;
            papeleirascheias_bl--;
            if (count_papeleirastotal_bl != null)
                count_papeleirastotal_bl.setText(Integer.toString(papeleirastotal_bl));
            if (count_papeleirascheias_bl != null)
                count_papeleirascheias_bl.setText(Integer.toString(papeleirascheias_bl));
        }
    }

    public void plus_papeleirascheias_bl(View view) {
            papeleirastotal_bl++;
            papeleirascheias_bl++;
            if (count_papeleirastotal_bl != null)
                count_papeleirastotal_bl.setText(Integer.toString(papeleirastotal_bl));
            if (count_papeleirascheias_bl != null)
                count_papeleirascheias_bl.setText(Integer.toString(papeleirascheias_bl));

    }


    // Função para TOASTmessages
    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    //Inserir dados na base de dados
    public void AddData(String rua, String residuos, String area, int pea_pequeno_rua,int pea_medio_rua, int pea_grande_rua,int pena_pequeno_rua,int pena_medio_rua,int pena_grande_rua,int pedacos_vidro_rua,
                        int garrafapeq_vidro_rua,int garrafagra_vidro_rua, int cigarros_rua, int dejetos_rua, int indiferenciados_rua, int folhas_rua, int rampequenas_rua, int ramgrandes_rua,
                        int pastilhas_rua, int past_ate500_rua, int past_maior500_rua, int ra_pequeno_rua, int ra_medio_rua, int ra_grande_rua, int oro_pequeno_rua, int oro_medio_rua, int oro_grande_rua,
                        int latas_metais_rua, int outros_metais_rua, int pea_pequeno_pa, int pea_medio_pa, int pea_grande_pa, int pena_pequeno_pa, int pena_medio_pa, int pena_grande_pa,int pedacos_vidro_pa,
                        int garrafapeq_vidro_pa,int garrafagra_vidro_pa, int cigarros_pa,int dejetos_pa, int indiferenciados_pa, int folhas_pa, int rampequenas_pa, int ramgrandes_pa, int pastilhas_pa,
                        int past_ate500_pa, int past_maior500_pa, int ra_pequeno_pa,int ra_medio_pa, int ra_grande_pa, int oro_pequeno_pa, int oro_medio_pa, int oro_grande_pa, int latas_metais_pa,
                        int outros_metais_pa, int pea_pequeno_cf, int pea_medio_cf,int pea_grande_cf, int pena_pequeno_cf, int pena_medio_cf, int pena_grande_cf, int pedacos_vidro_cf, int garrafapeq_vidro_cf,
                        int garrafagra_vidro_cf, int cigarros_cf, int dejetos_cf,int indiferenciados_cf,int folhas_cf, int rampequenas_cf, int ramgrandes_cf, int pastilhas_cf, int past_ate500_cf,
                        int past_maior500_cf, int ra_pequeno_cf, int ra_medio_cf,int ra_grande_cf, int oro_pequeno_cf, int oro_medio_cf, int oro_grande_cf, int latas_metais_cf, int outros_metais_cf,
                        int bocalobolimpa_bl, int bocalobosuja_bl, int bocalobototal_bl, int papeleirasvazia_bl, int papeleirascheias_bl, int papeleirastotal_bl, int pan, int cfn, int bln, String datahora) {
        boolean insertData = mDatabaseHelper.addData(rua, residuos, area, pea_pequeno_rua, pea_medio_rua,  pea_grande_rua, pena_pequeno_rua, pena_medio_rua, pena_grande_rua, pedacos_vidro_rua,
         garrafapeq_vidro_rua, garrafagra_vidro_rua,  cigarros_rua,  dejetos_rua,  indiferenciados_rua,  folhas_rua,  rampequenas_rua,  ramgrandes_rua,
         pastilhas_rua,  past_ate500_rua,  past_maior500_rua,  ra_pequeno_rua,  ra_medio_rua,  ra_grande_rua,  oro_pequeno_rua,  oro_medio_rua,  oro_grande_rua,
         latas_metais_rua,  outros_metais_rua,  pea_pequeno_pa,  pea_medio_pa,  pea_grande_pa,  pena_pequeno_pa,  pena_medio_pa,  pena_grande_pa, pedacos_vidro_pa,
         garrafapeq_vidro_pa, garrafagra_vidro_pa,  cigarros_pa, dejetos_pa,  indiferenciados_pa,  folhas_pa,  rampequenas_pa,  ramgrandes_pa,  pastilhas_pa,
         past_ate500_pa,  past_maior500_pa,  ra_pequeno_pa, ra_medio_pa,  ra_grande_pa,  oro_pequeno_pa,  oro_medio_pa,  oro_grande_pa,  latas_metais_pa,
         outros_metais_pa,  pea_pequeno_cf,  pea_medio_cf, pea_grande_cf,  pena_pequeno_cf,  pena_medio_cf,  pena_grande_cf,  pedacos_vidro_cf,  garrafapeq_vidro_cf,
         garrafagra_vidro_cf,  cigarros_cf,  dejetos_cf, indiferenciados_cf, folhas_cf,  rampequenas_cf,  ramgrandes_cf,  pastilhas_cf,  past_ate500_cf,
         past_maior500_cf,  ra_pequeno_cf,  ra_medio_cf, ra_grande_cf,  oro_pequeno_cf,  oro_medio_cf,  oro_grande_cf,  latas_metais_cf,  outros_metais_cf,
         bocalobolimpa_bl,  bocalobosuja_bl,  bocalobototal_bl,  papeleirasvazia_bl,  papeleirascheias_bl,  papeleirastotal_bl, pan, cfn, bln, datahora);

        if (insertData) {
            toastMessage("Foi adicionado com sucesso!");
        } else {
            toastMessage("Algo correu mal");
        }
    }


    // Ir buscar dados aos inputs e chamar a função AddData para Gravar na base de dados
    public void gravar(View view) {
        int verificapa = pea_pequeno_pa + pea_medio_pa + pea_grande_pa + pena_pequeno_pa + pena_medio_pa + pena_grande_pa + pedacos_vidro_pa + garrafapeq_vidro_pa + garrafagra_vidro_pa + cigarros_pa + dejetos_pa
                + indiferenciados_pa + folhas_pa + rampequenas_pa + ramgrandes_pa + pastilhas_pa + past_ate500_pa + past_maior500_pa + ra_pequeno_pa + ra_medio_pa + ra_grande_pa + oro_pequeno_pa + oro_medio_pa
                + oro_grande_pa + latas_metais_pa + outros_metais_pa;
        int verificacf = pea_pequeno_cf + pea_medio_cf + pea_grande_cf + pena_pequeno_cf + pena_medio_cf + pena_grande_cf + pedacos_vidro_cf + garrafapeq_vidro_cf + garrafagra_vidro_cf + cigarros_cf + dejetos_cf
                + indiferenciados_cf + folhas_cf + rampequenas_cf + ramgrandes_cf + pastilhas_cf + past_ate500_cf + past_maior500_cf + ra_pequeno_cf + ra_medio_cf + ra_grande_cf + oro_pequeno_cf + oro_medio_cf
                + oro_grande_cf + latas_metais_cf + outros_metais_cf;

        String trua = mRuas.getText().toString();
        String tresiduos = mResiduos.getText().toString();
        String tarea = mAreas.getText().toString();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US);
        Date now = new Date();
        String datahora = formatter.format(now);

        if(trua.isEmpty() || tresiduos.isEmpty() || tarea.isEmpty()){
            toastMessage("Tem valores em falta no primeiro tab : Ruas, Amostra ou Area");
        } else if (pa == false && verificapa >0){
            toastMessage("Tem valores nas Placas Ajardinadas mas o checkbox não esta ativo");
            
        }else if (cf == false && verificacf >0){
            toastMessage("Tem valores nas Caldeiras Floreiras mas o checkbox não esta ativo");
        }else if (bl == false && bocalobototal_bl>0){
            toastMessage("Tem valores nas Bocas de Lobo mas o checkbox não esta ativo");
        }else if (bl == false && papeleirastotal_bl>0){
            toastMessage("Tem valores nas Papeleiras mas o checkbox não esta ativo");
        }else {
            
            if (pa){
                pan = 1;
            }else{
                pan = 0;
            }
            if (cf){
                cfn = 1;
            }else{
                cfn = 0;
            }

            if (bl){
                bln = 1;
            }else{
                bln = 0;
            }


            String rua = mRuas.getText().toString();
            String residuos = mResiduos.getText().toString();
            String area = mAreas.getText().toString();


            AddData(rua, residuos, area, pea_pequeno_rua, pea_medio_rua, pea_grande_rua, pena_pequeno_rua, pena_medio_rua, pena_grande_rua, pedacos_vidro_rua,
                    garrafapeq_vidro_rua, garrafagra_vidro_rua, cigarros_rua, dejetos_rua, indiferenciados_rua, folhas_rua, rampequenas_rua, ramgrandes_rua,
                    pastilhas_rua, past_ate500_rua, past_maior500_rua, ra_pequeno_rua, ra_medio_rua, ra_grande_rua, oro_pequeno_rua, oro_medio_rua, oro_grande_rua,
                    latas_metais_rua, outros_metais_rua, pea_pequeno_pa, pea_medio_pa, pea_grande_pa, pena_pequeno_pa, pena_medio_pa, pena_grande_pa, pedacos_vidro_pa,
                    garrafapeq_vidro_pa, garrafagra_vidro_pa, cigarros_pa, dejetos_pa, indiferenciados_pa, folhas_pa, rampequenas_pa, ramgrandes_pa, pastilhas_pa,
                    past_ate500_pa, past_maior500_pa, ra_pequeno_pa, ra_medio_pa, ra_grande_pa, oro_pequeno_pa, oro_medio_pa, oro_grande_pa, latas_metais_pa,
                    outros_metais_pa, pea_pequeno_cf, pea_medio_cf, pea_grande_cf, pena_pequeno_cf, pena_medio_cf, pena_grande_cf, pedacos_vidro_cf, garrafapeq_vidro_cf,
                    garrafagra_vidro_cf, cigarros_cf, dejetos_cf, indiferenciados_cf, folhas_cf, rampequenas_cf, ramgrandes_cf, pastilhas_cf, past_ate500_cf,
                    past_maior500_cf, ra_pequeno_cf, ra_medio_cf, ra_grande_cf, oro_pequeno_cf, oro_medio_cf, oro_grande_cf, latas_metais_cf, outros_metais_cf,
                    bocalobolimpa_bl, bocalobosuja_bl, bocalobototal_bl, papeleirasvazia_bl, papeleirascheias_bl, papeleirastotal_bl, pan, cfn, bln, datahora);


            pea_pequeno_rua = 0;
            pea_medio_rua = 0;
            pea_grande_rua = 0;

             pena_pequeno_rua = 0;
             pena_medio_rua = 0;
             pena_grande_rua = 0;
             pedacos_vidro_rua = 0;
             garrafapeq_vidro_rua = 0;
             garrafagra_vidro_rua = 0;
             cigarros_rua = 0;
             dejetos_rua = 0;
             indiferenciados_rua = 0;
             folhas_rua = 0;
             rampequenas_rua = 0;
             ramgrandes_rua = 0;
             pastilhas_rua = 0;
             past_ate500_rua = 0;
             past_maior500_rua = 0;
             ra_pequeno_rua = 0;
             ra_medio_rua = 0;
             ra_grande_rua = 0;
             oro_pequeno_rua = 0;
             oro_medio_rua = 0;
             oro_grande_rua = 0;
             latas_metais_rua = 0;
             outros_metais_rua = 0;


           
             pea_pequeno_pa = 0;
             pea_medio_pa = 0;
             pea_grande_pa = 0;
             pena_pequeno_pa = 0;
             pena_medio_pa = 0;
             pena_grande_pa = 0;
             pedacos_vidro_pa = 0;
             garrafapeq_vidro_pa = 0;
             garrafagra_vidro_pa = 0;
             cigarros_pa = 0;
             dejetos_pa = 0;
             indiferenciados_pa = 0;
             folhas_pa = 0;
             rampequenas_pa = 0;
             ramgrandes_pa = 0;
             pastilhas_pa = 0;
             past_ate500_pa = 0;
             past_maior500_pa = 0;
             ra_pequeno_pa = 0;
             ra_medio_pa = 0;
             ra_grande_pa = 0;
             oro_pequeno_pa = 0;
             oro_medio_pa = 0;
             oro_grande_pa = 0;
             latas_metais_pa = 0;
             outros_metais_pa = 0;


            
             pea_pequeno_cf = 0;
             pea_medio_cf = 0;
             pea_grande_cf = 0;
             pena_pequeno_cf = 0;
             pena_medio_cf = 0;
             pena_grande_cf = 0;
             pedacos_vidro_cf = 0;
             garrafapeq_vidro_cf = 0;
             garrafagra_vidro_cf = 0;
             cigarros_cf = 0;
             dejetos_cf = 0;
             indiferenciados_cf = 0;
             folhas_cf = 0;
             rampequenas_cf = 0;
             ramgrandes_cf = 0;
             pastilhas_cf = 0;
             past_ate500_cf = 0;
             past_maior500_cf = 0;
             ra_pequeno_cf = 0;
             ra_medio_cf = 0;
             ra_grande_cf = 0;
             oro_pequeno_cf = 0;
             oro_medio_cf = 0;
             oro_grande_cf = 0;
             latas_metais_cf = 0;
             outros_metais_cf = 0;

           bocalobolimpa_bl = 0;
           bocalobosuja_bl = 0;
           bocalobototal_bl = 0;
           papeleirasvazia_bl = 0;
           papeleirascheias_bl = 0;
           papeleirastotal_bl = 0;
           


            count_pea_pequeno_rua.setText(Integer.toString(pea_pequeno_rua));
            count_pea_medio_rua.setText(Integer.toString(pea_medio_rua));
            count_pea_grande_rua.setText(Integer.toString(pea_grande_rua));
            count_pena_pequeno_rua.setText(Integer.toString(pena_pequeno_rua));
            count_pena_medio_rua.setText(Integer.toString(pena_medio_rua));
            count_pena_grande_rua.setText(Integer.toString(pena_grande_rua));
            count_pedacos_vidro_rua.setText(Integer.toString(pedacos_vidro_rua));
            count_garrafapeq_vidro_rua.setText(Integer.toString(garrafapeq_vidro_rua));
            count_garrafagra_vidro_rua.setText(Integer.toString(garrafagra_vidro_rua));
            count_cigarros_rua.setText(Integer.toString(cigarros_rua));
            count_dejetos_rua.setText(Integer.toString(dejetos_rua));
            count_indiferenciados_rua.setText(Integer.toString(indiferenciados_rua));
            count_folhas_rua.setText(Integer.toString(folhas_rua));
            count_rampequenas_rua.setText(Integer.toString(rampequenas_rua));
            count_ramgrandes_rua.setText(Integer.toString(ramgrandes_rua));
            count_pastilhas_rua.setText(Integer.toString(pastilhas_rua));
            count_past_ate500_rua.setText(Integer.toString(past_ate500_rua));
            count_past_maior500_rua.setText(Integer.toString(past_maior500_rua));
            count_ra_pequeno_rua.setText(Integer.toString(ra_pequeno_rua));
            count_ra_medio_rua.setText(Integer.toString(ra_medio_rua));
            count_ra_grande_rua.setText(Integer.toString(ra_grande_rua));
            count_oro_pequeno_rua.setText(Integer.toString(oro_pequeno_rua));
            count_oro_medio_rua.setText(Integer.toString(oro_medio_rua));
            count_oro_grande_rua.setText(Integer.toString(oro_grande_rua));
            count_latas_metais_rua.setText(Integer.toString(latas_metais_rua));
            count_outros_metais_rua.setText(Integer.toString(outros_metais_rua));



            count_pea_pequeno_pa.setText(Integer.toString(pea_pequeno_pa));
            count_pea_medio_pa.setText(Integer.toString(pea_medio_pa));
            count_pea_grande_pa.setText(Integer.toString(pea_grande_pa));
            count_pena_pequeno_pa.setText(Integer.toString(pena_pequeno_pa));
            count_pena_medio_pa.setText(Integer.toString(pena_medio_pa));
            count_pena_grande_pa.setText(Integer.toString(pena_grande_pa));
            count_pedacos_vidro_pa.setText(Integer.toString(pedacos_vidro_pa));
            count_garrafapeq_vidro_pa.setText(Integer.toString(garrafapeq_vidro_pa));
            count_garrafagra_vidro_pa.setText(Integer.toString(garrafagra_vidro_pa));
            count_cigarros_pa.setText(Integer.toString(cigarros_pa));
            count_dejetos_pa.setText(Integer.toString(dejetos_pa));
            count_indiferenciados_pa.setText(Integer.toString(indiferenciados_pa));
            count_folhas_pa.setText(Integer.toString(folhas_pa));
            count_rampequenas_pa.setText(Integer.toString(rampequenas_pa));
            count_ramgrandes_pa.setText(Integer.toString(ramgrandes_pa));
            count_pastilhas_pa.setText(Integer.toString(pastilhas_pa));
            count_past_ate500_pa.setText(Integer.toString(past_ate500_pa));
            count_past_maior500_pa.setText(Integer.toString(past_maior500_pa));
            count_ra_pequeno_pa.setText(Integer.toString(ra_pequeno_pa));
            count_ra_medio_pa.setText(Integer.toString(ra_medio_pa));
            count_ra_grande_pa.setText(Integer.toString(ra_grande_pa));
            count_oro_pequeno_pa.setText(Integer.toString(oro_pequeno_pa));
            count_oro_medio_pa.setText(Integer.toString(oro_medio_pa));
            count_oro_grande_pa.setText(Integer.toString(oro_grande_pa));
            count_latas_metais_pa.setText(Integer.toString(latas_metais_pa));
            count_outros_metais_pa.setText(Integer.toString(outros_metais_pa));



            count_pea_pequeno_cf.setText(Integer.toString(pea_pequeno_cf));
            count_pea_medio_cf.setText(Integer.toString(pea_medio_cf));
            count_pea_grande_cf.setText(Integer.toString(pea_grande_cf));
            count_pena_pequeno_cf.setText(Integer.toString(pena_pequeno_cf));
            count_pena_medio_cf.setText(Integer.toString(pena_medio_cf));
            count_pena_grande_cf.setText(Integer.toString(pena_grande_cf));
            count_pedacos_vidro_cf.setText(Integer.toString(pedacos_vidro_cf));
            count_garrafapeq_vidro_cf.setText(Integer.toString(garrafapeq_vidro_cf));
            count_garrafagra_vidro_cf.setText(Integer.toString(garrafagra_vidro_cf));
            count_cigarros_cf.setText(Integer.toString(cigarros_cf));
            count_dejetos_cf.setText(Integer.toString(dejetos_cf));
            count_indiferenciados_cf.setText(Integer.toString(indiferenciados_cf));
            count_folhas_cf.setText(Integer.toString(folhas_cf));
            count_rampequenas_cf.setText(Integer.toString(rampequenas_cf));
            count_ramgrandes_cf.setText(Integer.toString(ramgrandes_cf));
            count_pastilhas_cf.setText(Integer.toString(pastilhas_cf));
            count_past_ate500_cf.setText(Integer.toString(past_ate500_cf));
            count_past_maior500_cf.setText(Integer.toString(past_maior500_cf));
            count_ra_pequeno_cf.setText(Integer.toString(ra_pequeno_cf));
            count_ra_medio_cf.setText(Integer.toString(ra_medio_cf));
            count_ra_grande_cf.setText(Integer.toString(ra_grande_cf));
            count_oro_pequeno_cf.setText(Integer.toString(oro_pequeno_cf));
            count_oro_medio_cf.setText(Integer.toString(oro_medio_cf));
            count_oro_grande_cf.setText(Integer.toString(oro_grande_cf));
            count_latas_metais_cf.setText(Integer.toString(latas_metais_cf));
            count_outros_metais_cf.setText(Integer.toString(outros_metais_cf));

            count_bocalobolimpa_bl.setText(Integer.toString(bocalobolimpa_bl));
            count_bocalobosuja_bl.setText(Integer.toString(bocalobosuja_bl));
            count_bocalobototal_bl.setText(Integer.toString(bocalobototal_bl));
            count_papeleirasvazia_bl.setText(Integer.toString(papeleirasvazia_bl));
            count_papeleirascheias_bl.setText(Integer.toString(papeleirascheias_bl));
            count_papeleirastotal_bl.setText(Integer.toString(papeleirastotal_bl));

            mResiduos.setText("");

        }

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
    public boolean checkPermission(String permission) {
        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }


    //Faz Reset à base de dados
    public void reset(View view) {
        mDatabaseHelper.deleteData();
        toastMessage("Base de Dados Limpa!");
    }


    public void gravarcsv(View view) {

        final Cursor cursor = mDatabaseHelper.getData();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US);
        Date now = new Date();
        String fileName = "residuos_" + formatter.format(now) + ".csv";
        StringBuilder bld = new StringBuilder();

        String header = "Data e Hora" + "," + "Rua" + "," + "Residuos" + "," + "Area (m2)" + "," + "PEA pequeno" + "," + "PEA medio" + "," + "PEA grande" + "," + "PENA pequeno" + "," + "PENA medio" + "," + "PENA grande" + ","+
                "Pedacos vidro"+ "," + "Garrafas de 25 a 33 cL"+ "," +"Garrafas de 75 cL a 1 L"+ "," +"Pontas de cigarro" + "," +"Dejetos caninos" + "," +"Sacos de indiferenciados" + "," +"Folhas"+ "," +"Ramagens pequenas"
                + "," +"Ramagens grandes"+ "," +"Pastilhas elasticas"+ "," +"Ate 500 cm2" + "," +"Maior que 500 cm2" + "," +"RA pequeno" + "," +"RA medio" + "," + "RA grande" + "," +"ORO pequeno" + "," +"ORO medio"+ "," +
                "ORO grande" + "," +"Latas refrigerantes"+ "," +"Outros metais" + "," +"PEA pequeno" + "," + "PEA medio" + "," + "PEA grande" + "," + "PENA pequeno" + "," + "PENA medio" + "," + "PENA grande" + ","+
                "Pedacos vidro"+ "," + "Garrafas de 25 a 33 cL"+ "," +"Garrafas de 75 cL a 1 L"+ "," +"Pontas de cigarro" + "," +"Dejetos caninos" + "," +"Sacos de indiferenciados" + "," +"Folhas"+ "," +"Ramagens pequenas"
                + "," +"Ramagens grandes"+ "," +"Pastilhas elasticas"+ "," +"Ate 500 cm2" + "," +"Maior que 500 cm2" + "," +"RA pequeno" + "," +"RA medio" + "," + "RA grande" + "," +"ORO pequeno" + "," +"ORO medio"+ "," +
                "ORO grande" + "," +"Latas refrigerantes"+ "," +"Outros metais" + "," +"PEA pequeno" + "," + "PEA medio" + "," + "PEA grande" + "," + "PENA pequeno" + "," + "PENA medio" + "," + "PENA grande" + ","+
                "Pedacos vidro"+ "," + "Garrafas de 25 a 33 cL"+ "," +"Garrafas de 75 cL a 1 L"+ "," +"Pontas de cigarro" + "," +"Dejetos caninos" + "," +"Sacos de indiferenciados" + "," +"Folhas"+ "," +"Ramagens pequenas"
                + "," +"Ramagens grandes"+ "," +"Pastilhas elasticas"+ "," +"Ate 500 cm2" + "," +"Maior que 500 cm2" + "," +"RA pequeno" + "," +"RA medio" + "," + "RA grande" + "," +"ORO pequeno" + "," +"ORO medio"+ "," +
                "ORO grande" + "," +"Latas refrigerantes"+ "," +"Outros metais" + "," + "Bocas de lobo totais" + "," +"Bocas de lobo limpas" + "," +"Papeleiras" + "," +"Papeleiras vazias" + "\n";

        bld.append(header);

        if (isExternalStorageWritable() && checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            if (cursor.moveToFirst()) {
                do {
                    String dataHora = cursor.getString(cursor.getColumnIndex("data"));
                    String Rua = cursor.getString(cursor.getColumnIndex("rua"));
                    String Residuos = cursor.getString(cursor.getColumnIndex("residuos"));
                    String Area = cursor.getString(cursor.getColumnIndex("area"));
                    String PeaPequenoRua = Integer.toString(cursor.getInt(cursor.getColumnIndex("pea_pequeno_rua")));
                    String PeaMedioRua = Integer.toString(cursor.getInt(cursor.getColumnIndex("pea_medio_rua")));
                    String PeaGrandeRua = Integer.toString(cursor.getInt(cursor.getColumnIndex("pea_grande_rua")));
                    String spena_pequeno_rua = Integer.toString(cursor.getInt(cursor.getColumnIndex( "pena_pequeno_rua")));
                    String spena_medio_rua = Integer.toString(cursor.getInt(cursor.getColumnIndex("pena_medio_rua")));
                    String spena_grande_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("pena_grande_rua")));
                    String spedacos_vidro_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("pedacos_vidro_rua")));
                    String sgarrafapeq_vidro_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("garrafapeq_vidro_rua")));
                    String sgarrafagra_vidro_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("garrafagra_vidro_rua")));
                    String scigarros_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("cigarros_rua")));
                    String sdejetos_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("dejetos_rua")));
                    String sindiferenciados_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("indiferenciados_rua")));
                    String sfolhas_rua = Integer.toString(cursor.getInt(cursor.getColumnIndex("folhas_rua")));
                    String srampequenas_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("rampequenas_rua")));
                    String sramgrandes_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("ramgrandes_rua")));
                    String spastilhas_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("pastilhas_rua")));
                    String spast_ate500_rua = Integer.toString(cursor.getInt(cursor.getColumnIndex("past_ate500_rua")));
                    String spast_maior500_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("past_maior500_rua")));
                    String sra_pequeno_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("ra_pequeno_rua")));
                    String sra_medio_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("ra_medio_rua")));
                    String sra_grande_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("ra_grande_rua")));
                    String soro_pequeno_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("oro_pequeno_rua")));
                    String soro_medio_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("oro_medio_rua")));
                    String soro_grande_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("oro_grande_rua")));
                    String slatas_metais_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("latas_metais_rua")));
                    String soutros_metais_rua= Integer.toString(cursor.getInt(cursor.getColumnIndex("outros_metais_rua")));

                    String spea_pequeno_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("pea_pequeno_pa")));
                    String spea_medio_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("pea_medio_pa")));
                    String spea_grande_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("pea_grande_pa")));
                    String spena_pequeno_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("pena_pequeno_pa")));
                    String spena_medio_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("pena_medio_pa")));
                    String spena_grande_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("pena_grande_pa")));
                    String spedacos_vidro_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("pedacos_vidro_pa")));
                    String sgarrafapeq_vidro_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("garrafapeq_vidro_pa")));
                    String sgarrafagra_vidro_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("garrafagra_vidro_pa")));
                    String scigarros_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("cigarros_pa")));
                    String sdejetos_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("dejetos_pa")));
                    String sindiferenciados_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("indiferenciados_pa")));
                    String sfolhas_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("folhas_pa")));
                    String srampequenas_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("rampequenas_pa")));
                    String sramgrandes_pa = Integer.toString(cursor.getInt(cursor.getColumnIndex("ramgrandes_pa")));
                    String spastilhas_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("pastilhas_pa")));
                    String spast_ate500_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("past_ate500_pa")));
                    String spast_maior500_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("past_maior500_pa")));
                    String sra_pequeno_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("ra_pequeno_pa")));
                    String sra_medio_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("ra_medio_pa")));
                    String sra_grande_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("ra_grande_pa")));
                    String soro_pequeno_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("oro_pequeno_pa")));
                    String soro_medio_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("oro_medio_pa")));
                    String soro_grande_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex( "oro_grande_pa")));
                    String slatas_metais_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex("latas_metais_pa")));
                    String soutros_metais_pa= Integer.toString(cursor.getInt(cursor.getColumnIndex( "outros_metais_pa")));

                    String spea_pequeno_cf = Integer.toString(cursor.getInt(cursor.getColumnIndex( "pea_pequeno_cf")));
                    String spea_medio_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex("pea_medio_cf")));
                    String spea_grande_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex("pea_grande_cf")));
                    String spena_pequeno_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex("pena_pequeno_cf")));
                    String spena_medio_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex("pena_medio_cf")));
                    String spena_grande_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex("pena_grande_cf")));
                    String spedacos_vidro_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex("pedacos_vidro_cf")));
                    String sgarrafapeq_vidro_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex("garrafapeq_vidro_cf")));
                    String sgarrafagra_vidro_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex("garrafagra_vidro_cf")));
                    String scigarros_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex("cigarros_cf")));
                    String sdejetos_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex("dejetos_cf")));
                    String sindiferenciados_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex("indiferenciados_cf")));
                    String sfolhas_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex("folhas_cf")));
                    String srampequenas_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex("rampequenas_cf")));
                    String sramgrandes_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex("ramgrandes_cf")));
                    String spastilhas_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex( "pastilhas_cf")));
                    String spast_ate500_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex("past_ate500_cf")));
                    String spast_maior500_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex("past_maior500_cf")));
                    String sra_pequeno_cf = Integer.toString(cursor.getInt(cursor.getColumnIndex("ra_pequeno_cf")));
                    String sra_medio_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex( "ra_medio_cf")));
                    String sra_grande_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex("ra_grande_cf")));
                    String soro_pequeno_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex( "oro_pequeno_cf")));
                    String soro_medio_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex( "oro_medio_cf")));
                    String soro_grande_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex( "oro_grande_cf")));
                    String slatas_metais_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex( "latas_metais_cf")));
                    String soutros_metais_cf= Integer.toString(cursor.getInt(cursor.getColumnIndex( "outros_metais_cf")));

                    String sbocalobolimpa_bl= Integer.toString(cursor.getInt(cursor.getColumnIndex( "bocalobolimpa_bl")));
                    String sbocalobosuja_bl= Integer.toString(cursor.getInt(cursor.getColumnIndex( "bocalobosuja_bl")));
                    String sbocalobototal_bl= Integer.toString(cursor.getInt(cursor.getColumnIndex( "bocalobototal_bl")));
                    String spapeleirasvazia_bl= Integer.toString(cursor.getInt(cursor.getColumnIndex( "papeleirasvazia_bl")));
                    String spapeleirascheias_bl= Integer.toString(cursor.getInt(cursor.getColumnIndex( "papeleirascheias_bl")));
                    String spapeleirastotal_bl= Integer.toString(cursor.getInt(cursor.getColumnIndex( "papeleirastotal_bl")));
                    int spa= cursor.getInt(cursor.getColumnIndex( "pa"));
                    int scf= cursor.getInt(cursor.getColumnIndex( "cf"));
                    int sbl= cursor.getInt(cursor.getColumnIndex( "bl"));
                    
                    
                    if (spa == 0){
                        spea_pequeno_pa= "";
                        spea_medio_pa= "";
                        spea_grande_pa= "";
                        spena_pequeno_pa= "";
                        spena_medio_pa= "";
                        spena_grande_pa= "";
                        spedacos_vidro_pa= "";
                        sgarrafapeq_vidro_pa= "";
                        sgarrafagra_vidro_pa= "";
                        scigarros_pa= "";
                        sdejetos_pa= "";
                        sindiferenciados_pa= "";
                        sfolhas_pa= "";
                        srampequenas_pa= "";
                        sramgrandes_pa = "";
                        spastilhas_pa= "";
                        spast_ate500_pa= "";
                        spast_maior500_pa= "";
                        sra_pequeno_pa= "";
                        sra_medio_pa= "";
                        sra_grande_pa= "";
                        soro_pequeno_pa= "";
                        soro_medio_pa= "";
                        soro_grande_pa= "";
                        slatas_metais_pa= "";
                        soutros_metais_pa= "";
                    }
                    
                    if (scf == 0){
                        spea_pequeno_cf = "";
                        spea_medio_cf= "";
                        spea_grande_cf= "";
                        spena_pequeno_cf= "";
                        spena_medio_cf= "";
                        spena_grande_cf= "";
                        spedacos_vidro_cf= "";
                        sgarrafapeq_vidro_cf= "";
                        sgarrafagra_vidro_cf= "";
                        scigarros_cf= "";
                        sdejetos_cf= "";
                        sindiferenciados_cf= "";
                        sfolhas_cf= "";
                        srampequenas_cf= "";
                        sramgrandes_cf= "";
                        spastilhas_cf= "";
                        spast_ate500_cf= "";
                        spast_maior500_cf= "";
                        sra_pequeno_cf = "";
                        sra_medio_cf= "";
                        sra_grande_cf= "";
                        soro_pequeno_cf= "";
                        soro_medio_cf= "";
                        soro_grande_cf= "";
                        slatas_metais_cf= "";
                        soutros_metais_cf= "";
                    }
                    
                    if (sbl == 0){
                        sbocalobolimpa_bl= "";
                        sbocalobosuja_bl= "";
                        sbocalobototal_bl= "";
                        spapeleirasvazia_bl= "";
                        spapeleirascheias_bl= "";
                        spapeleirastotal_bl= "";    
                    }



                    
                    

                    bld.append(dataHora + "," + Rua + "," + Residuos + "," + Area + "," + PeaPequenoRua + "," + PeaMedioRua + "," + PeaGrandeRua + "," + spena_pequeno_rua + "," + spena_medio_rua + "," +
                                    spena_grande_rua+ "," + spedacos_vidro_rua+ "," +  sgarrafapeq_vidro_rua+ "," +  sgarrafagra_vidro_rua+ "," + scigarros_rua+ "," + sdejetos_rua+ "," +
                                    sindiferenciados_rua+ "," + sfolhas_rua + "," + srampequenas_rua+ "," + sramgrandes_rua+ "," + spastilhas_rua+ "," + spast_ate500_rua+ "," +
                                    spast_maior500_rua+ "," + sra_pequeno_rua+ "," + sra_medio_rua+ "," + sra_grande_rua+ "," + soro_pequeno_rua+ "," + soro_medio_rua+ "," +
                                    soro_grande_rua+ "," + slatas_metais_rua+ "," + soutros_metais_rua+ "," + spea_pequeno_pa+ "," + spea_medio_pa+ "," + spea_grande_pa+ "," +
                                    spena_pequeno_pa+ "," +spena_medio_pa+ "," + spena_grande_pa+ "," +  spedacos_vidro_pa+ "," + sgarrafapeq_vidro_pa+ "," + sgarrafagra_vidro_pa+ "," +
                                    scigarros_pa+ "," +  sdejetos_pa+ "," + sindiferenciados_pa+ "," + sfolhas_pa+ "," + srampequenas_pa+ "," + sramgrandes_pa+ "," + spastilhas_pa+ "," +
                            spast_ate500_pa+ "," + spast_maior500_pa+ "," + sra_pequeno_pa+ "," + sra_medio_pa+ "," + sra_grande_pa+ "," + soro_pequeno_pa+ "," + soro_medio_pa+ "," +
                            soro_grande_pa+ "," +  slatas_metais_pa+ "," + soutros_metais_pa+ "," + spea_pequeno_cf+ "," + spea_medio_cf+ "," +   spea_grande_cf+ "," + spena_pequeno_cf+ "," +
                            spena_medio_cf+ "," +  spena_grande_cf+ "," + spedacos_vidro_cf+ "," + sgarrafapeq_vidro_cf+ "," +  sgarrafagra_vidro_cf+ "," + scigarros_cf+ "," + sdejetos_cf+ "," +
                            sindiferenciados_cf+ "," + sfolhas_cf+ "," + srampequenas_cf+ "," + sramgrandes_cf+ "," + spastilhas_cf+ "," + spast_ate500_cf+ "," + spast_maior500_cf+ "," +
                            sra_pequeno_cf + "," + sra_medio_cf+ "," + sra_grande_cf+ "," + soro_pequeno_cf+ "," +  soro_medio_cf+ "," +  soro_grande_cf+ "," + slatas_metais_cf+ "," + soutros_metais_cf+ "," +
                            sbocalobototal_bl+ "," + sbocalobolimpa_bl + "," +spapeleirastotal_bl + "," + spapeleirasvazia_bl + "\n");


                } while (cursor.moveToNext());
            }

            String dados = bld.toString();

            //closing cursor
            cursor.close();


            File textFile = new File(Environment.getExternalStorageDirectory(), fileName);
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
        } else {
            Toast.makeText(this, "Não consegue escrever no Armazenamento externo",
                    Toast.LENGTH_LONG).show();
        }


    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {

            case R.id.checkBox:
                if (checked)
                pa = true;
            else
                pa = false;
                break;
            case R.id.checkBox2:
                if (checked)
               cf = true;
            else
                cf = false;
                break;
            case R.id.checkBox3:
                if (checked)
                bl = true;
            else
                bl = false;
                break;

        }

    }
}



