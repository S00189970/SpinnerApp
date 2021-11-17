package edu.psherlock.resistor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import static edu.psherlock.resistor.R.id.spinner;
import static edu.psherlock.resistor.R.id.spinner2;
import static edu.psherlock.resistor.R.id.spinner3;
import static edu.psherlock.resistor.R.id.spinner4;

public class MainActivity extends AppCompatActivity {

    Spinner spnColors1;
    Spinner spnColors2;
    Spinner spnColors3;
    Spinner spnColors4;

    double band1;
    double band2;
    int band3;
    int band4;
    double ans;
    double multiplier;
    String percent;

    TextView tvAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spnColors1 = (Spinner)findViewById(spinner);
        spnColors1.setAdapter(new SpinnerAdapter(this));

        spnColors2 = (Spinner)findViewById(spinner2);
        spnColors2.setAdapter(new SpinnerAdapter(this));

        spnColors3 = (Spinner)findViewById(spinner3);
        spnColors3.setAdapter(new SpinnerAdapter(this));

        spnColors4 = (Spinner)findViewById(spinner4);
        spnColors4.setAdapter(new SpinnerAdapter(this));

        tvAns = findViewById(R.id.tvAns);

        tvAns.setText("");


        spnColors1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                band1 = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spnColors2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                band2 = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spnColors3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                band3 = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spnColors4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                band4 = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    public void doCalculate(View view) {

        switch (band3){
            case 0:
                multiplier = 1;
                break;
            case 1:
                multiplier = 10;
                break;
            case 2:
                multiplier = 100;
                break;
            case 3:
                multiplier = 1000;
                break;
            case 4:
                multiplier = 10000;
                break;
            case 5:
                multiplier = 100000;
                break;
            case 6:
                multiplier = 1000000;
                break;
            case 7:
                multiplier = 10000000;
                break;
            case 8:
                multiplier = 100000000;
                break;
            case 9:
                multiplier = 1000000000;
                break;
            case 10:
                multiplier = 0.1;
                break;
            case 11:
                multiplier = 0.01;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + band3);
        }

        switch (band4){
            case 0:
                percent = "";
                break;
            case 1:
                percent = "+/-1%";
                break;
            case 2:
                percent = "+/-2%";
                break;
            case 3:
                percent = "";
                break;
            case 4:
                percent = "";
                break;
            case 5:
                percent = "+/-0.5%";
                break;
            case 6:
                percent = "+/-0.25%";
                break;
            case 7:
                percent = "+/-0.1%";
                break;
            case 8:
                percent = "+/-0.05%";
                break;
            case 9:
                percent = "";
                break;
            case 10:
                percent = "+/-5%";
                break;
            case 11:
                percent = "+/-10%";
                break;
            default:
                percent = "+/-20";
                break;
        }

        if(band1 == 10 || band1 == 11 || band2 == 10 || band2 == 11) {

            tvAns.setText("No gold or sliver in band 1 or 2");

        }else {
            ans = ((band1 * 10) + band2);
            ans = ans * multiplier;

            tvAns.setText(String.valueOf(ans + "Ω" + percent));
        }
        }

    public void doReset(View view) {
        tvAns.setText("");

        spnColors1.setSelection(0);
        spnColors2.setSelection(0);
        spnColors3.setSelection(0);
        spnColors4.setSelection(0);
    }
}