package com.example.android.restraunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class login extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static TextView attempt;
    private static Button login_button;
    int attempt_counter = 5;
    static private HashMap<String, String> data = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //  LoginButton();
        username = (EditText) findViewById(R.id.editText_user);
        password = (EditText) findViewById(R.id.editText_password);
        password.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        attempt = (TextView) findViewById(R.id.editText_attempt_count);
        login_button = (Button) findViewById(R.id.button_login1);
        attempt.setText(Integer.toString(attempt_counter));
        data.put("benita", "123");
        data.put("karuna", "456");
        data.put("shravani", "789");
        data.put("sana", "miniproject");

    }


    public void Login(View v) {
        username = (EditText) findViewById(R.id.editText_user);
        password = (EditText) findViewById(R.id.editText_password);
        if (data.containsKey(username.getText().toString()) && data.containsValue(password.getText().toString())) {
            Intent i = new Intent(this, TableBooking.class);
            startActivity(i);
        } else {
            Toast.makeText(login.this, "Incorrect Username or Password.",
                    Toast.LENGTH_SHORT).show();
            attempt_counter--;
            attempt.setText(Integer.toString(attempt_counter));
            if (attempt_counter == 0)
                login_button.setEnabled(false);
        }

    }


    public void signup(View v) {
        username = (EditText) findViewById(R.id.editText_user);
        password = (EditText) findViewById(R.id.editText_password);
        String newPassword = password.getText().toString();
        String newUser = username.getText().toString();
        if (data.containsKey(newUser)) {
            Toast.makeText(login.this, "Username already exists.",
                    Toast.LENGTH_SHORT).show();
        } else if (newUser.equals("") || newPassword.equals("")) {
            Toast.makeText(login.this, "Required details cannot be empty",
                    Toast.LENGTH_SHORT).show();
        } else {
            data.put(newUser, newPassword);
            Intent i = new Intent(this, TableBooking.class);
            startActivity(i);
        }
    }
}


class AsteriskPasswordTransformationMethod extends PasswordTransformationMethod {
    @Override
    public CharSequence getTransformation(CharSequence source, View view) {
        return new PasswordCharSequence(source);
    }

    private class PasswordCharSequence implements CharSequence {
        private CharSequence mSource;

        public PasswordCharSequence(CharSequence source) {
            mSource = source; // Store char sequence
        }

        public char charAt(int index) {
            return '*'; // This is the important part
        }

        public int length() {
            return mSource.length(); // Return default
        }

        public CharSequence subSequence(int start, int end) {
            return mSource.subSequence(start, end); // Return default
        }
    }
};

