package mn_unidad2_mb;

import java.util.Scanner;

public class MN_Unidad2_MB {

    public static void main(String[] args) {
        double Li, Lm;
        double intervalo[] = new double[2];/**/
        System.out.println("Introducir un punto inferior y un punto superior para calcular el intervalo");
        System.out.println("valor inferior ");
        Li = new Scanner(System.in).nextDouble();
        System.out.println("Valor superior");
        Lm = new Scanner(System.in).nextDouble();
        //
        intervalo = intervalos(Li, Lm);
        //
        System.out.println("intervalo: \na = " + intervalo[0]
                + "\nb = " + intervalo[1]);
        System.out.println("Ingrese el numero de iteraciones que desee hacer");
        int i = new Scanner(System.in).nextInt();
        System.out.println("Tabulacion");
        biseccion(intervalo, i);
    }

    public static double funcion(double x) {
        return (Math.pow(Math.E, (x - 1)) - (1.5 * x));
    }

    public static double[] intervalos(double Li, double Lm) {
        double i, intervalo[] = new double[2];
        double x = 0, y = 0, f;
        if (funcion(Li) < 0) {
            System.out.println("caso 1");
            intervalo[0] = 1;//a
            intervalo[1] = -1;//b
            for (i = Li; i <= Lm; i++) {
                f = funcion(i);
                if (f < 0) {
                    intervalo[0] = i;
                    x = f;
                }
                if (f > 0) {
                    intervalo[1] = i;
                    y = f;
                }
                System.out.println("[i = " + i + "] funcion = " + f);
                if (x < 0 && y > 0) {
                    System.out.println("a = " + intervalo[0] + " b = " + intervalo[1]);
                    break;
                }
            }
        } else {
            System.out.println("caso 2");
            intervalo[0] = -1;//a
            intervalo[1] = 1;//b
            for (i = Li; i <= Lm; i++) {
                f = funcion(i);
                if (f > 0) {
                    intervalo[0] = i;
                    x = f;
                }
                if (f < 0) {
                    intervalo[1] = i;
                    y = f;
                }
                System.out.println("[i = " + i + "] funcion = " + f);
                if (x > 0 && y < 0) {
                    break;
                }
            }
        }
        return intervalo;
    }

    public static void biseccion(double[] intervalos, int iteraciones) {
        double a = intervalos[0];
        double b = intervalos[1];
        double xr = 0, xrA = 0, erp = 0;
        double fa, fb, fxr, fax;
        //
        for (int i = 1; i <= iteraciones; i++) {
            xr = (a + b) / 2;
            fa = funcion(a);
            fxr = funcion(xr);
            fax = fa * fxr;
            System.out.print("iteracion = " + i
                    + "|a = " + a
                    + " |b = " + b
                    + " |xr = " + xr
                    + " |fa = " + fa
                    + " |fx = " + fxr
                    + " |fa*fx = " + fax);
            if (i != 1) {
                erp = ERP(xr, xrA);
                System.out.println("|error = " + erp);
            } else {
                System.out.println("|error = ---- ");
            }
            xrA = xr;
            if (fax > 0) {
                a = xr;
            }
            if (fax < 0) {
                b = xr;
            }
        }
    }

    public static double ERP(double Vv, double Va) {
        double ERP = Vv - Va;
        ERP /= Vv;
        ERP *= 100;
        if (ERP < 0) {
            ERP = (ERP * -1);
        }
        return ERP;
    }
}
