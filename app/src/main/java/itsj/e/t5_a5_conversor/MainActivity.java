package itsj.e.t5_a5_conversor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ArrayAdapter adaptadorC, adaptadorF, adaptadorR, adaptadorK, adaptadorVacio;
    EditText numeroIngresado, numeroResultado;
    double n1 = 0;
    Spinner SpinnerTemperaturas, SpinnerTemperaturas2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpinnerTemperaturas=findViewById(R.id.spinner_Temperaturas);
        SpinnerTemperaturas2=findViewById(R.id.spinner_Segundo);


        SpinnerTemperaturas2.setOnItemSelectedListener(this);

        ArrayAdapter adaptador = ArrayAdapter.createFromResource(this,
                R.array.Temperaturas, android.R.layout.simple_spinner_item);

        adaptadorC = ArrayAdapter.createFromResource(this,
                R.array.Temp_C, android.R.layout.simple_spinner_item);

        adaptadorF = ArrayAdapter.createFromResource(this,
                R.array.Temp_F, android.R.layout.simple_spinner_item);

        adaptadorR = ArrayAdapter.createFromResource(this,
                R.array.Temp_R, android.R.layout.simple_spinner_item);

        adaptadorK = ArrayAdapter.createFromResource(this,
                R.array.Temp_K, android.R.layout.simple_spinner_item);

        adaptadorVacio = ArrayAdapter.createFromResource(this,
                R.array.Temp_Vacio, android.R.layout.simple_spinner_item);

        SpinnerTemperaturas.setAdapter(adaptador);
        numeroIngresado=findViewById(R.id.numero_ingresado);
        numeroResultado=findViewById(R.id.Resultado);

        SpinnerTemperaturas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String temperaturaa=parent.getSelectedItem().toString();



                if (temperaturaa.equals("Centigrados")){
                    SpinnerTemperaturas2.setAdapter(adaptadorC);
                    SpinnerTemperaturas2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parentC, View view, int position, long id) {
                            n1=Double.parseDouble(numeroIngresado.getText().toString());
                            String temp=parentC.getSelectedItem().toString();
                            if (String.valueOf(n1)==""){

                            }else{
                            if (temp.equals("Fahrenheit")){
                                numeroResultado.setText(((n1*1.8)+32)+"");
                            }
                            if (temp.equals("Rankine")){
                                numeroResultado.setText((n1+273.15)+"");
                            }
                            if (temp.equals("Kelvin")){
                                numeroResultado.setText((((n1*9)/5)+491.67)+"");
                            }

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                if (temperaturaa.equals("Fahrenheit")){
                    SpinnerTemperaturas2.setAdapter(adaptadorF);
                    SpinnerTemperaturas2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            n1=Double.parseDouble(numeroIngresado.getText().toString());
                            String temp=parent.getSelectedItem().toString();
                            if (String.valueOf(n1)==""){

                            }else{
                                if (temp.equals("Centigrados")){
                                    numeroResultado.setText(((5*(n1-32))/9)+"");
                                }
                                if (temp.equals("Rankine")){
                                    numeroResultado.setText((n1+459.67)+"");
                                }
                                if (temp.equals("Kelvin")){
                                    numeroResultado.setText((((9*(n1-273.15))/15)+32)+"");
                                }

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                if (temperaturaa.equals("Rankine")){
                    SpinnerTemperaturas2.setAdapter(adaptadorR);
                    SpinnerTemperaturas2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            n1=Double.parseDouble(numeroIngresado.getText().toString());
                            String temp=parent.getSelectedItem().toString();
                            if (String.valueOf(n1)==""){

                            }else{
                                if (temp.equals("Fahrenheit")){
                                    numeroResultado.setText((n1-459.67)+"");
                                }
                                if (temp.equals("Centigrados")){
                                    numeroResultado.setText( ((5*(n1-491.67 ))/9 )+"");
                                }
                                if (temp.equals("Kelvin")){
                                    numeroResultado.setText(((((n1-491.67)*5)/9)+273.15)+"");
                                }

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                if (temperaturaa.equals("Kelvin")){
                    SpinnerTemperaturas2.setAdapter(adaptadorK);
                    SpinnerTemperaturas2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            n1=Double.parseDouble(numeroIngresado.getText().toString());
                            String temp=parent.getSelectedItem().toString();
                            if (String.valueOf(n1)==""){

                            }else{
                                if (temp.equals("Fahrenheit")){
                                    numeroResultado.setText(((9*(n1-273.15)/5)+32)+"");
                                }
                                if (temp.equals("Rankine")){
                                    numeroResultado.setText(((9*(n1-273.15 )/5)+491.67)+"");
                                }
                                if (temp.equals("Centigrados")){
                                    numeroResultado.setText((n1-273.15)+"");
                                }

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                SpinnerTemperaturas2.setAdapter(adaptadorVacio);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getApplicationContext(),parent.getSelectedItem().toString(), Toast.LENGTH_LONG);

        if(parent.getSelectedItem().toString()=="Centigrados"){

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
