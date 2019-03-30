package mahamat.abagana.kachallah.com.projet_iot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    //CompteurVitesse compteurVitesse;
    Boussole boussole;
    //MyView myViewCompteur;
    MyView myViewBoussole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress <= 270)
                {
                    //compteurVitesse.setVitesse((float) progress);
                    //myViewCompteur.invalidate();
                }
                boussole.setDirection((float)progress);
                myViewBoussole.invalidate();
                System.out.println("<Dessin> progress : " + progress);
            }
        });

        boussole = new Boussole(0);
        //compteurVitesse = new CompteurVitesse(0);
        //compteurVitesse.setTaille(600);

        LinearLayout myLayout1 = (LinearLayout)findViewById(R.id.myView);

        myViewBoussole = new MyView(this, boussole);
        myLayout1.addView(myViewBoussole);

        //myViewCompteur = new MyView(this, compteurVitesse);
        //myLayout1.addView(myViewCompteur);
    }
}
