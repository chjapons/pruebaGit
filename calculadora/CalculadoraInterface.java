import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculadoraInterface extends Remote {
    
    public long sumar(long a, long b) throws RemoteException;
    public long restar(long a, long b) throws RemoteException;
    public long multiplicar(long a, long b) throws RemoteException;
    public long dividir(long a, long b) throws RemoteException;
    
}
