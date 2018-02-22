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


public class mainCourseMenu extends Activity {

    MyCustomAdapter dataAdapter = null;
    static ArrayList<mainCourse_info> checkedInfom = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course_menu);

        //Generate list View from ArrayList
        displayListView();

        checkButtonClick();

    }

    @Override
    protected void onResume() {
        super.onResume();
        for (int i = 0; i < checkedInfom.size(); i++)
            checkedInfom.remove(i);
    }

    private void displayListView() {

        //Array list of countries
        ArrayList<mainCourse_info> mainCourseList = new ArrayList<>();
        mainCourse_info country = new mainCourse_info(R.drawable.main_1, false, 750, "Vegetable Poriyal");
        mainCourseList.add(country);
        country = new mainCourse_info(R.drawable.main_2, false, 800, "Vilayati Subz Handi");
        mainCourseList.add(country);
        country = new mainCourse_info(R.drawable.main_3, false, 500, "Margharita");
        mainCourseList.add(country);
        country = new mainCourse_info(R.drawable.main_4, false, 500, "Napolitan");
        mainCourseList.add(country);
        country = new mainCourse_info(R.drawable.main_5, false, 450, "Steamed Rice");
        mainCourseList.add(country);
        country = new mainCourse_info(R.drawable.main_6, false, 500, "Brown Rice");
        mainCourseList.add(country);
        country = new mainCourse_info(R.drawable.main_7, false, 180, "Naan/Roti Plain");
        mainCourseList.add(country);
        country = new mainCourse_info(R.drawable.main_8, false, 220, "Naan/Roti Butter, Garlic, Cheese");
        mainCourseList.add(country);


        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this,
                R.layout.maincourse_row, mainCourseList);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                mainCourse_info country = (mainCourse_info) parent.getItemAtPosition(position);

            }
        });

    }

    public class MyCustomAdapter extends ArrayAdapter<mainCourse_info> {

        private ArrayList<mainCourse_info> mainCourseList;


        public MyCustomAdapter(Context context, int imageViewResourceId,
                               ArrayList<mainCourse_info> mainCourseList) {
            super(context, imageViewResourceId, mainCourseList);
            this.mainCourseList = new ArrayList<>();
            this.mainCourseList.addAll(mainCourseList);
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
                convertView = vi.inflate(R.layout.maincourse_row, null);

                holder = new ViewHolder();
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                holder.img = (ImageView) convertView.findViewById(R.id.image);
                convertView.setTag(holder);

                holder.name.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v;
                        mainCourse_info country = (mainCourse_info) cb.getTag();

                        country.setSelected(cb.isChecked());
                    }
                });
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            mainCourse_info country = mainCourseList.get(position);
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


                ArrayList<mainCourse_info> mainCourseList = dataAdapter.mainCourseList;
                for (int i = 0; i < mainCourseList.size(); i++) {
                    mainCourse_info country = mainCourseList.get(i);
                    if (country.isSelected()) {

                        checkedInfom.add(mainCourseList.get(i));

                    }
                }


                for (int i = 0; i < checkedInfom.size(); i++)
                    Log.d("abc", checkedInfom.get(i).toString());
                Intent i = new Intent(mainCourseMenu.this, billprint_mainCourse.class);
                startActivity(i);


            }
        });

    }

}
