package pollub.ism.lab03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText sentMessage     = null,
                     receivedMessage = null;

    public static String MESSAGE_KEY = "Przekazywana informacja";
    public static int REQUEST_CODE   = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sentMessage = (EditText) findViewById(R.id.sentMessageContent);
        receivedMessage = (EditText) findViewById(R.id.receivedMessageContent);

        receivedMessage.setEnabled(false);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == REQUEST_CODE){
            String message = data.getStringExtra(MESSAGE_KEY);
            receivedMessage.setText(message);
        }
    }

    public void launchSecondActivity(View view) {
        String message = sentMessage.getText().toString();

        Intent intention = new Intent(this, SecondActivity.class);
        intention.putExtra(MESSAGE_KEY, message);
        this.startActivityForResult(intention, REQUEST_CODE);
    }

    public void launchThirdActivity(View view) {
        Intent intention = new Intent(this, ThirdActivity.class);
        startActivity(intention);
    }
}