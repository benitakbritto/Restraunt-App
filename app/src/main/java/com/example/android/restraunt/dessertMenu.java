package com.example.android.restraunt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class dessertMenu extends Activity {

    MyCustomAdapter dataAdapter = null;
    static ArrayList<dessert_info> checkedInfod = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert_menu);

        //Generate list View from ArrayList
        displayListView();

        checkButtonClick();

    }

    @Override
    protected void onResume() {
        super.onResume();
        for (int i = 0; i < checkedInfod.size(); i++)
            checkedInfod.remove(i);
    }

    private void displayListView() {

        //Array list of countries
        ArrayList<dessert_info> dessertList = new ArrayList<>();
        dessert_info country = new dessert_info(R.drawable.des_1, false, 350, "Vanilla Creme Brulee");
        dessertList.add(country);
        country = new dessert_info(R.drawable.des_2, false, 400, "Icecream Selection");
        dessertList.add(country);
        country = new dessert_info(R.drawable.des_3, false, 550, "Gulab Jamun");
        dessertList.add(country);
        country = new dessert_info(R.drawable.des_4, false, 600, "Chocolate Fudge");
        dessertList.add(country);
        country = new dessert_info(R.drawable.des_5, false, 550, "Banoffee Pie");
        dessertList.add(country);
        country = new dessert_info(R.drawable.des_6, false, 550, "Red Velvet Cake");
        dessertList.add(country);
        country = new dessert_info(R.drawable.des_7, false, 550, "Classic Baked Cheesecake");
        dessertList.add(country);


        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this,
                R.layout.dessert_row, dessertList);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                dessert_info country = (dessert_info) parent.getItemAtPosition(position);
                /*Toast.makeText(getApplicationContext(),
                        "Clicked on Row: " + country.getName(),
                        Toast.LENGTH_LONG).show();*/
            }
        });

    }

    public class MyCustomAdapter extends ArrayAdapter<dessert_info> {

        private ArrayList<dessert_info> dessertList;


        public MyCustomAdapter(Context context, int imageViewResourceId,
                               ArrayList<dessert_info> dessertList) {
            super(context, imageViewResourceId, dessertList);
            this.dessertList = new ArrayList<>();
            this.dessertList.addAll(dessertList);
        }

        private class ViewHolder {

            CheckBox name;
            ImageView img;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.dessert_row, null);

                holder = new ViewHolder();
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                holder.img = (ImageView) convertView.findViewById(R.id.image);
                convertView.setTag(holder);

                holder.name.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v;
                        dessert_info country = (dessert_info) cb.getTag();
                        /*Toast.makeText(getApplicationContext(),
                                "Clicked on Checkbox: " + cb.getText() +
                                        " is " + cb.isChecked(),
                                Toast.LENGTH_LONG).show();*/
                        country.setSelected(cb.isChecked());
                    }
                });
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            dessert_info country = dessertList.get(position);
            holder.name.setText(country.getName());
            holder.img.setImageResource(country.getImgid());
            holder.name.setChecked(country.isSelected());
            holder.name.setTag(country);


            return convertView;

        }

    }

    private void checkButtonClick() {


        Button myButton = (Button) findViewById(R.id.findSelected);
        myButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                // StringBuffer responseText = new StringBuffer();
                //responseText.append("The following were selected...\n");

                ArrayList<dessert_info> dessertList = dataAdapter.dessertList;
                for (int i = 0; i < dessertList.size(); i++) {
                    dessert_info country = dessertList.get(i);
                    if (country.isSelected()) {
                        //responseText.append("\n" + country.getName());
                        checkedInfod.add(dessertList.get(i));

                    }
                }

              /*  Toast.makeText(getApplicationContext(),
                        responseText, Toast.LENGTH_LONG).show();*/
                for (int i = 0; i < checkedInfod.size(); i++)
                    Log.d("abc", checkedInfod.get(i).toString());
                Intent i = new Intent(dessertMenu.this, billprint_dessert.class);
                startActivity(i);


            }
        });

    }

}
