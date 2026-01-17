package hariomsoni.codecloner.bmiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFT, edtHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout main;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFT = findViewById(R.id.edtHeightFT);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        main =findViewById(R.id.main);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int wt = Integer.parseInt(edtWeight.getText().toString());
                int htft = Integer.parseInt(edtHeightFT.getText().toString());
                int htin = Integer.parseInt(edtHeightIn.getText().toString());


                int totalInches = (htft * 12) + htin;

                double heightInMeters = totalInches * 0.0254;

                double bmi = wt / (heightInMeters * heightInMeters);

                String category;

                if (bmi < 18.5) {
                    category = "Underweight";
                   main.setBackgroundColor(getResources().getColor(R.color.bg_uw));
                } else if (bmi >= 18.5 && bmi < 24.9) {
                    category = "Healthy";
                    main.setBackgroundColor(getResources().getColor(R.color.bg_healthy));
                } else if (bmi >= 25 && bmi < 29.9) {
                    category = "Overweight";
                    main.setBackgroundColor(getResources().getColor(R.color.bg_ow));
                } else {
                    category = "Obese";
                }

                txtResult.setText("Your BMI is: " + String.format("%.2f", bmi) + "\nStatus: " + category);
            }
        });

    }
}
