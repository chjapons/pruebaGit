
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.rmi.Naming;

public class Cliente implements Serializable {
    static class Expresion {
        public long a;
        public long b;
        public String op;
    }

    public static void main(String args[]) {
        while (true) {
            try {
                CalculadoraInterface c = (CalculadoraInterface) Naming.lookup("calculadora");
                while (true) {
                    System.out.println("Ingrese la operacion(a + b):  ");
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    Expresion e = getExpresion(br.readLine());
                    if (e != null) {
                        if (e.op.equals("+")) {
                            System.out.println(c.sumar(e.a, e.b));
                        } else if (e.op.equals("-")) {
                            System.out.println(c.restar(e.a, e.b));
                        } else if (e.op.equals("*")) {
                            System.out.println(c.multiplicar(e.a, e.b));
                        } else if (e.op.equals("/")) {
                            System.out.println(c.dividir(e.a, e.b));
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    private static Expresion getExpresion(String exp) {
        try {
            Expresion e = new Expresion();
            if (exp.contains("+")) {
                e.a = Long.parseLong(exp.split("\\+")[0].trim());
                e.b = Long.parseLong(exp.split("\\+")[1].trim());
                e.op = "+";
                return e;
            } else if (exp.contains("-")) {
                e.a = Long.parseLong(exp.split("\\-")[0].trim());
                e.b = Long.parseLong(exp.split("\\-")[1].trim());
                e.op = "-";
                return e;
            } else if (exp.contains("*")) {
                e.a = Long.parseLong(exp.split("\\*")[0].trim());
                e.b = Long.parseLong(exp.split("\\*")[1].trim());
                e.op = "*";
                return e;
            } else if (exp.contains("/")) {
                e.a = Long.parseLong(exp.split("\\/")[0].trim());
                e.b = Long.parseLong(exp.split("\\/")[1].trim());
                e.op = "/";
                return e;
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }
    
}

