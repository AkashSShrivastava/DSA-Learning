package DC_Assignment_2025MT12007.ByzantineAgreementProtocolPkg;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GeneralRPC extends Remote {
    void receiveOrder(Message message) throws RemoteException;
    void relayOrder(Message message, int fromNode) throws RemoteException;
    String getFinalDecision() throws RemoteException;
    boolean isByzantine() throws RemoteException;
    int getNodeId() throws RemoteException;
}

