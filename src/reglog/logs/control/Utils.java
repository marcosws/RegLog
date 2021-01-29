package reglog.logs.control;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Utils {
	
	public static String getWorkstationName() {
		
		try {
			return InetAddress.getLocalHost().getHostName();
		} 
		catch(UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static String getCallClassName() {
		
        Throwable throwable = new Throwable();
        throwable.fillInStackTrace ();
        StackTraceElement[] stackTraceElement = throwable.getStackTrace();
        String className = "";
        int cont = 0;
		for(StackTraceElement s: stackTraceElement){
			className =  s.getFileName();
			cont++;
			if(cont == 3) break; // Common.java > Log.java > {classe origem}.java
		}
		return className;
	}

}
