package pollub.ism.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if(savedInstanceState == null)
        {
            Intent intention = getIntent();
            String message = intention.getStringExtra(MainActivity.MESSAGE_KEY);

            EditText receivedMessage = (EditText) findViewById(R.id.receivedMessageContent1);
            receivedMessage.setText(message);
            receivedMessage.setEnabled(false);
        }
    }

    public void returnToMainActivity(View view) {
        EditText sentMessage = (EditText) findViewById(R.id.sentMessageContent1);
        String message = sentMessage.getText().toString();

        Intent intention = new Intent();
        intention.putExtra(MainActivity.MESSAGE_KEY, message);

        setResult(MainActivity.REQUEST_CODE, intention);

        finish();

    }
}