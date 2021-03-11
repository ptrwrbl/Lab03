package pollub.ism.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void openWebsite(View view) {
        Intent intention = new Intent(Intent.ACTION_VIEW);
        intention.setData(Uri.parse("https://tomasznowicki.gitbook.io/ism/"));

        try
        {
            startActivity(intention);
        }
        catch (ActivityNotFoundException e)
        {
            Toast.makeText(this,"Brak przeglądarki", Toast.LENGTH_LONG).show();
        }
    }

    public void makeACall(View view) {
        Intent intention = new Intent(Intent.ACTION_DIAL);

        intention.setData(Uri.parse("tel:" + 226952900));

        try
        {
            startActivity(intention);
        }
        catch (ActivityNotFoundException e)
        {
            Toast.makeText(this,"Brak możliwości dzwonienia", Toast.LENGTH_LONG).show();
        }
    }

    public void makeAPhoto(View view) {

    }

    public void returnToMainActivity(View view) {
        finish();
    }
}