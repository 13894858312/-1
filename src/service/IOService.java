//鏈嶅姟鍣↖OService鐨凷tub锛屽唴瀹圭浉鍚�
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IOService extends Remote{
	public boolean writeFile(String file, String userId, String fileName)throws RemoteException;
	
	public String readFile(String userId, String fileName)throws RemoteException;
	
	public ArrayList<String> readFileList(String userId)throws RemoteException;
}
