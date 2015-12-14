package com.example.brendaminozzo.calculadora;


/**
 * Created by Brenda on 14/12/2015.
 */
public class Calculos{

    public String calculo(double ant, String operador, double prox){
        double result = 0.0;
        if (operador.equals("+")){
            result = ant+prox;
        }else if (operador.equals("-")){
            result = ant-prox;
        }else if (operador.equals("/")){
            result = ant/prox;
        }else if (operador.equals("*")){
            result = ant*prox;
        }

        return String.valueOf(result);
    }

}
