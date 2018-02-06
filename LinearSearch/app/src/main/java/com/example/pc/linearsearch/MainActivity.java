package com.example.pc.linearsearch;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private EditText edtxt,searchedtxt;
    private Button addbtn,searchbtn;
    private Context context = this;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtxt = findViewById(R.id.edtxt);
        searchedtxt = findViewById(R.id.searchedtxt);
        addbtn = findViewById(R.id.addbtn);
        searchbtn = findViewById(R.id.searchbtn);

        listView = findViewById(R.id.listView);
        final ArrayList<String> arrList = new ArrayList<>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.txtitem, arrList);
        listView.setAdapter(adapter);

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                for (int i = 0; i < arrList.size(); i++) {
                    if (Objects.equals(arrList.get(i), searchedtxt.getText().toString())){
                        String search = searchedtxt.getText().toString();
                        int indexElement = arrList.indexOf(search);
                        int indexElementList = indexElement + 1;

                        AlertDialog.Builder builder;
                        builder = new AlertDialog.Builder(context, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
                        builder.setTitle("Search Found")
                                .setMessage("Found Name List Index : " + indexElementList).show();

                    }
                }
            }
        });

        addbtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                String itemadd =edtxt.getText().toString();
                arrList.add(itemadd);
                edtxt.setText("");
                adapter.notifyDataSetChanged();
            }
        });

    }
}