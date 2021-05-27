package sg.edu.rp.c346.id20002369.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvD, tvO, tvU;
    String bankClicked = "";
    boolean favDBS = false;
    boolean favOCBC = false;
    boolean favUOB = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvD = findViewById(R.id.textViewD);
        tvO = findViewById(R.id.textViewO);
        tvU = findViewById(R.id.textViewU);
        registerForContextMenu(tvD);
        registerForContextMenu(tvO);
        registerForContextMenu(tvU);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the Bank");
        menu.add(0,2,2, "Toggle Favourite");

        if (v == tvD) {
            bankClicked = "dbs";
        } else if (v == tvO) {
            bankClicked = "ocbc";
        }
        else{
            bankClicked = "uob";
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (bankClicked.equalsIgnoreCase("dbs")) {
            if (id == 0) { //check whether the selected menu item ID is 0
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.web1)));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (id == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.n1)));
                startActivity(intentCall);
                return true; //menu item successfully handled
            }
            else{
                if (!favDBS){
                    favDBS = true;
                    tvD.setTextColor(Color.RED);
                }
                else{
                    favDBS = false;
                    tvD.setTextColor(Color.BLACK);
                }
            }
        }
        else if (bankClicked.equalsIgnoreCase("ocbc")){
            if (id == 0) { //check whether the selected menu item ID is 0
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.web2)));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (id == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.n2)));
                startActivity(intentCall);
                return true; //menu item successfully handle
            }
            else{
                if (!favOCBC){
                    favOCBC = true;
                    tvO.setTextColor(Color.RED);
                }
                else{
                    favOCBC = false;
                    tvO.setTextColor(Color.BLACK);
                }
            }
        }
        else {
            if (id == 0) { //check whether the selected menu item ID is 0
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.web3)));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (id == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.n3)));
                startActivity(intentCall);
                return true; //menu item successfully handle
            }
            else{
                if (!favUOB){
                    favUOB = true;
                    tvU.setTextColor(Color.RED);
                }
                else{
                    favUOB = false;
                    tvU.setTextColor(Color.BLACK);
                }
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvD.setText(getString(R.string.a));
            tvO.setText(getString(R.string.b));
            tvU.setText(getString(R.string.c));
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvD.setText(getString(R.string.a2));
            tvO.setText(getString(R.string.b2));
            tvU.setText(getString(R.string.c2));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}