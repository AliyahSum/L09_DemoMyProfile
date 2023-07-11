package sg.edu.rp.c346.id22015529.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName ;
    EditText etGPA ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName) ;
        etGPA = findViewById(R.id.editTextGPA) ;
    }

    @Override
    protected void onPause() {
        super.onPause() ;
        String strName = etName.getText().toString() ;
        float fltGPA = etGPA.getText().length();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE) ;
        SharedPreferences.Editor prefEdit = prefs.edit() ;
        prefEdit.putString("name", "Hello, " + strName + "!") ;
        prefEdit.putFloat("gpa", Float.parseFloat("Your GPA is " + fltGPA + "!")) ;
        prefEdit.commit() ;
    }

    @Override
    protected void onResume() {
        super.onResume() ;
        SharedPreferences prefs = getPreferences(MODE_PRIVATE) ;
        String msg = prefs.getString("name", "No name :(") ;
        msg += prefs.getFloat("gpa", Float.parseFloat("No gpa :(")) ;
        Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG) ;
        toast.show() ;
    }
}