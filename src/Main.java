//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sea Bienvenido/a al Conversor de Moneda =)\n" +
                "\n" +
                "1) Dólar => Peso argentino\n" +
                "2) Peso argentino => Dólar\n" +
                "3) Dólar => Real brasileño\n" +
                "4) Real brasileño => Dólar\n" +
                "5) Dólar => Peso colombiano\n" +
                "6) Peso colombiano => Dólar\n" +
                "7) Dólar => Peso Mexicano\n" +
                "8) Peso Mexicano => Dólar\n" +
                "9) Salir");
        System.out.println("************************************************" );
        int opcion = scanner.nextInt();

        if (opcion == 9){
            System.out.println("Gracias por usar el ocnversor de moendas");
            return;
        }

        System.out.println("Ingrese la cantidad  a convertir");
        double cantidad = scanner.nextDouble();

// Llamar al servicio para obtener el tipo de cambio
        ExchaneRateService exchangeRateService = new ExchaneRateService();
        double tipoCambio = exchangeRateService.getExchangeRate(opcion);


        if (tipoCambio == 0){
            System.out.println("Opción no válida. Intente otra cantiddad.");
        }else {
            double resultado = cantidad * tipoCambio;
            System.out.println(" El monto convertido es: "+ resultado);
        }

    }
}


