package com.example.android.restraunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class verify_payment extends AppCompatActivity {

    private Spinner spinner1, spinner2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_payment);
        addListenerOnButton();

        Button nextf = (Button) findViewById(R.id.button_next);
        nextf.setEnabled(false);
        addListenerOnSpinnerItemSelection();


        Button login = (Button) findViewById(R.id.button_login);
        if (login != null) {
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(getBaseContext(), "Validating information...Do not exit this page", Toast.LENGTH_LONG).show();
                    validate();
                }
            });

        }


    }


    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner2 = (Spinner) findViewById(R.id.spinner1);
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

    }

    public void validate() {
        EditText card_no = (EditText) findViewById(R.id.editText_card_number);
        EditText cvv = (EditText) findViewById(R.id.editText_cvv);

        try {
            Button nextf = (Button) findViewById(R.id.button_next);
            nextf.setEnabled(true);
            int number = Integer.parseInt(card_no.getText().toString());
            try {
                Button nextff = (Button) findViewById(R.id.button_next);
                nextff.setEnabled(true);
                int cvv_check = Integer.parseInt(cvv.getText().toString());
                Intent intent = new Intent(this, Redirect.class);
                startActivity(intent);
            } catch (Exception e) {
                Button nextfff = (Button) findViewById(R.id.button_next);
                nextfff.setEnabled(false);
                Toast.makeText(getBaseContext(), "Incorrect details.", Toast.LENGTH_SHORT).show();

            }

        } catch (Exception e) {
            Button nextf = (Button) findViewById(R.id.button_next);
            nextf.setEnabled(false);
            Toast.makeText(getBaseContext(), "Incorrect details.", Toast.LENGTH_SHORT).show();

        }


    }
}

