package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.RegexValidator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.regex.*;

public class MainActivity extends AppCompatActivity {
    TextView inputText,outputText;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    Button btnPlus,btnMinus,btnDivide,btnMultiply,btnPercentage,btnPower,btnClear,btnPoint,btnEquals;
    private String input,output,newOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);

        btn0 = findViewById(R.id.btnZero);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMul);
        btnDivide = findViewById(R.id.btnDivide);
        btnPercentage = findViewById(R.id.btnPercentage);
        btnPoint = findViewById(R.id.btnPoint);
        btnPower = findViewById(R.id.btnPower);
        btnEquals = findViewById(R.id.btnEquals);


    }

    public void onButtonClicked(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){
            case"C":
                input=null;
                output=null;
                outputText.setText("");
                break;
            case"=":
                solve();
                break;
            case"^":
                input+="^";
                solve();
                break;
            case"%":
                input+="%";
                double d= Double.parseDouble(inputText.getText().toString())/100;
                outputText.setText(String.valueOf(d));
                break;
            case"/":
                input+="/";
                solve();
                break;
            case"*":
                input+="*";
                solve();
                break;
            case"-":
                input+="-";
                solve();
                break;
            case"+":
                input+="+";
                solve();
                break;
            default:
                if(input==null){
                    input="";
                }
                input+=data;
         }
         inputText.setText(input);
    }

    private void solve() {
        if(input.split("\\+").length==2){
            String numbers[]=input.split(("\\+"));
            try{
                double d = Double.parseDouble(numbers[0])+Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                outputText.setText(output);
                input=d+"";
            }catch(Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\/").length==2){
            String numbers[] = input.split("\\/");
            try{
                double d = Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]);
                output = Double.toString(d);

                outputText.setText(output);
                input=d+"";
            }catch (Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\*").length==2){
            String numbers[] = input.split("\\*");
            try{
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);

                outputText.setText(output);
                input=d+"";
            }catch (Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }if(input.split("\\-").length==2){
            String numbers[] = input.split("\\-");
            try{
                if(Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1])){
                    double d = Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[0]);
                    output = Double.toString(d);
                    outputText.setText("-"+output);
                    input=d+"";
                }
                else{
                double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                output = Double.toString(d);

                outputText.setText(output);
                input=d+"";}
            }catch (Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }if(input.split("\\^").length==2){
            String numbers[] = input.split("\\^");
            try{
                double d = Math.pow(Double.parseDouble(numbers[0]) , Double.parseDouble(numbers[1]));
                output = Double.toString(d);

                outputText.setText(output);
                input=d+"";
            }catch (Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }


    }


}