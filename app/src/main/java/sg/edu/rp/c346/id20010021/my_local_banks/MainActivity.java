package sg.edu.rp.c346.id20010021.my_local_banks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView DBS;
    TextView OCBC;
    TextView UOB;

    Boolean FavouriteDBS;
    Boolean FavouriteOCBC;
    Boolean FavouriteUOB;

    String wordClicked = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.DBS);
        OCBC = findViewById(R.id.OCBC);
        UOB = findViewById(R.id.UOB);

        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        menu.add(0, 2, 2, "Favourite");

        if (v == DBS) {
            wordClicked = "DBS";
        } else if (v == OCBC) {
            wordClicked = "OCBC";
        } else if (v == UOB) {
            wordClicked = "UOB";
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            DBS.setText("DBS");
            OCBC.setText("OCBC");
            UOB.setText("UOB ");
            return true;
        } else if (id == R.id.ChineseSelection) {
            DBS.setText("DBSchi");
            OCBC.setText("OCBCchi");
            UOB.setText("UOBchi");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("@string/DBSlink"));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "@string/DBSnum"));
                startActivity(intentCall);
            } else if (item.getItemId() == 2) {
                if (!FavouriteDBS) {
                    FavouriteDBS = true;
                    DBS.setTextColor(Color.RED);
                } else {
                    FavouriteDBS = false;
                    DBS.setTextColor(Color.BLACK);
                }

            } else if (wordClicked.equalsIgnoreCase("OCBC")) {
                if (item.getItemId() == 0) {
                    Intent intent1 = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("@string/OCBClink"));
                    startActivity(intent1);
                } else if (item.getItemId() == 1) {
                    Intent intentCall1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "@string/OCBCnum"));
                    startActivity(intentCall1);
                } else if (item.getItemId() == 2) {
                    if (!FavouriteOCBC) {
                        FavouriteOCBC = true;
                        OCBC.setTextColor(Color.RED);
                    } else {
                        FavouriteOCBC = false;
                        OCBC.setTextColor(Color.BLACK);
                    }
                } else if (wordClicked.equalsIgnoreCase("UOB")) {
                    if (item.getItemId() == 0) {
                        Intent intent2 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("@string/UOBlink"));
                        startActivity(intent2);
                    } else if (item.getItemId() == 1) {
                        Intent intentCall2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "@string/UOBnum"));
                        startActivity(intentCall2);
                    } else if (item.getItemId() == 2) {
                        if (!FavouriteUOB) {
                            FavouriteUOB = true;
                            UOB.setTextColor(Color.RED);
                        } else {
                            FavouriteUOB = false;
                            UOB.setTextColor(Color.BLACK);
                        }
                    }

                }
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}