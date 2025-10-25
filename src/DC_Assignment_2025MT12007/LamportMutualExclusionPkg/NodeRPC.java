package DC_Assignment_2025MT12007.LamportMutualExclusionPkg;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NodeRPC extends Remote {
    void requestCS(int timestamp, int nodeId) throws RemoteException;
    void replyToRequest(int timestamp, int nodeId) throws RemoteException;
    void releaseCS(int timestamp, int nodeId) throws RemoteException;
}

