package seawright.carringtondemo;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    public void toActivity(Class name) {
        Intent intent = new Intent(this, name);
        startActivity(intent);
    }

    public void toastLong(String content) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    public void toastShort(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }
}
