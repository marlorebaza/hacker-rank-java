package com.marlo.java;

import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MyNumberFormatter {
	
	public static void main(String[] args) {

		// Usamos un Locale que use el separador decimal "." y lo indicamos al Scanne,
		// ya que por defecto hará uso del caracter "," como separador decimal
		// Fuente: https://stackoverflow.com/a/9081936
        Scanner sc= new Scanner(System.in).useLocale(Locale.ENGLISH);
        double payment = sc.nextDouble();
        DecimalFormatSymbols custom=new DecimalFormatSymbols();
        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        // Nota Indica no tiene incorporada un Locale, es por esto que debemos contruir uno. Lo hacemos con el lenguaje "en"
        // Sobre new Locale(...): https://docs.oracle.com/javase/8/docs/api/java/util/Locale.html#Locale-java.lang.String-java.lang.String-
        String india = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
        sc.close();
    }

}
