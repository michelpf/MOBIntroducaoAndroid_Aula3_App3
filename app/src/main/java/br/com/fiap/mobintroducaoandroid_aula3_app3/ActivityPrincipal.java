package br.com.fiap.mobintroducaoandroid_aula3_app3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

public class ActivityPrincipal extends AppCompatActivity implements View.OnClickListener{

    ImageView imgRosto = null;
    Button btnPiscar = null;


    private boolean piscou=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgRosto=(ImageView)findViewById(R.id.imgRosto);
        btnPiscar=(Button)findViewById(R.id.btnPiscar);
        btnPiscar.setOnClickListener(this);

        desenharNormal();


    }

    public void piscar(){
        if (piscou){
            desenharNormal();
        }
        else {
            desenharPiscar();
        }
        piscou=!piscou;
    }

    public void desenharNormal(){

        Bitmap bmp = Bitmap.createBitmap(100,100,Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmp);
        Paint p = new Paint();
        p.setColor(Color.YELLOW);
        Paint p2 = new Paint();
        p2.setColor(Color.BLACK);
        c.drawCircle(50, 50, 30, p);
        c.drawLine(40, 70, 60, 70, p2);

        c.drawCircle(40, 40, 5, p2);
        c.drawCircle(60, 40, 5, p2);
        imgRosto.setImageBitmap(bmp);

    }

    public void desenharPiscar(){

        Bitmap bmp = Bitmap.createBitmap(100,100,Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmp);
        Paint p = new Paint();
        p.setColor(Color.YELLOW);
        Paint p2 = new Paint();
        p2.setColor(Color.BLACK);
        c.drawCircle(50, 50, 30, p);
        c.drawLine(40, 70, 60, 70, p2);

        c.drawCircle(40, 40, 5, p2);
        c.drawLine(60, 40, 70, 40, p2);
        imgRosto.setImageBitmap(bmp);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        piscar();
    }
}
