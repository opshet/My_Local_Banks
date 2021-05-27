package sg.edu.rp.c346.id20010021.my_local_banks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView DBS;
    TextView OCBC;
    TextView UOB;

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
            OCBC.setText("OCBC ");
            UOB.setText("UOB ");
            return true;
        } else if (id == R.id.ChineseSelection) {
            DBS.setText("dbs in chi");
            OCBC.setText("ocbc in chi ");
            UOB.setText("uob in chi ");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.dbs.com/default.page?gclid=CjwKCAjw47eFBhA9EiwAy8kzNFFqrlh5a_DSjHltj56pUQznXHwbzklGcCbcROCj47eTs__jVoKO0xoCfmYQAvD_BwE&gclsrc=aw.ds"));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(intentCall);
            }
        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intent1 = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.ocbc.com/group/gateway"));
                startActivity(intent1);
            } else if (item.getItemId() == 1) {
                Intent intentCall1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(intentCall1);
            }
        } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.uob.com.sg/personal/index.page"));
                startActivity(intent2);
            } else if (item.getItemId() == 1) {
                Intent intentCall2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(intentCall2);
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}