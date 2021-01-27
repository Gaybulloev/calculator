package uz.gaybulloev.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    AppCompatButton btnClear,btnQavs,btnPercent,btnDivide,btnSeven,btnEight,btnNine,btnMultiply,btnFour,btnFive;
    AppCompatButton btnSix,btnDivisor,btnOne,btnTwo,btnThree,btnAddition,btnChange,btnZero,btnNuqta,btnEquals;
    TextView inPuts,outPuts;

    boolean changeS = false;
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClear = findViewById(R.id.btnClear);
        btnQavs = findViewById(R.id.btnQavs);
        btnPercent = findViewById(R.id.btnPercent);
        btnDivide = findViewById(R.id.btnDivide);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnDivisor = findViewById(R.id.btnDivisor);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnAddition = findViewById(R.id.btnAddition);
        btnChange = findViewById(R.id.btnChange);
        btnZero = findViewById(R.id.btnZero);
        btnNuqta = findViewById(R.id.btnNuqta);
        btnEquals = findViewById(R.id.btnEquals);

        inPuts = findViewById(R.id.inPuts);
        outPuts = findViewById(R.id.outPuts);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inPuts.setText("");
                outPuts.setText("");
            }
        });


        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = inPuts.getText().toString();
                inPuts.setText(string+"0");
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = inPuts.getText().toString();
                inPuts.setText(string+"1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = inPuts.getText().toString();

                inPuts.setText(string+"2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = inPuts.getText().toString();

                inPuts.setText(string+"3");
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = inPuts.getText().toString();

                inPuts.setText(string+"4");
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = inPuts.getText().toString();

                inPuts.setText(string+"5");
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = inPuts.getText().toString();

                inPuts.setText(string+"6");
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = inPuts.getText().toString();

                inPuts.setText(string+"7");
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = inPuts.getText().toString();

                inPuts.setText(string+"8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = inPuts.getText().toString();

                inPuts.setText(string+"9");
            }
        });


        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = inPuts.getText().toString();

                inPuts.setText(string+"+");
            }
        });

        btnQavs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (changeS){
                    string = inPuts.getText().toString();
                    inPuts.setText(string+"(");
                } else {
                    string = inPuts.getText().toString();
                    inPuts.setText(string+")");
                }
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = inPuts.getText().toString();

                inPuts.setText(string+"%");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = inPuts.getText().toString();

                inPuts.setText(string+"÷");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = inPuts.getText().toString();

                inPuts.setText(string+"×");
            }
        });

        btnDivisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = inPuts.getText().toString();

                inPuts.setText(string+"-");
            }
        });


        btnNuqta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = inPuts.getText().toString();

                inPuts.setText(string+".");
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = inPuts.getText().toString();
                string = string.replaceAll("×", "*");
                string = string.replaceAll("%", "/100");
                string = string.replaceAll("÷", "/");


                Context context = Context.enter();
                context.setOptimizationLevel(-1);
                String finalResults = "";
                try {
                    Scriptable scriptable = context.initStandardObjects();
                    finalResults = context.evaluateString(scriptable,string,
                            "java", 1,null).toString();
                } catch (Exception exception){
                    finalResults = "0";
                }
                outPuts.setText(finalResults);
            }
        });



    }
}