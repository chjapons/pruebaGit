
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculadora extends UnicastRemoteObject implements CalculadoraInterface {
    
    public Calculadora() throws RemoteException {
        //imp = new RegistryImpl(1099);
    }

    @Override
    public long sumar(long a, long b) throws RemoteException {
        return a + b;
    }

    @Override
    public long restar(long a, long b) throws RemoteException {
        return a - b;
    }

    @Override
    public long multiplicar(long a, long b) throws RemoteException {
        return a * b;
    }

    @Override
    public long dividir(long a, long b) throws RemoteException {
        return b > 0 ? a / b : 0;
    }
    
    public static void main(String[] args) {
        try {
            Calculadora c = new Calculadora();
            Naming.rebind("calculadora", c);
            System.out.println("Servidor registrado");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
}
