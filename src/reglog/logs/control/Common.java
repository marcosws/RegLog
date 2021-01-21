package reglog.logs.control;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Common {
	
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
		for(StackTraceElement s: stackTraceElement){
			className =  s.getFileName();
		}
		return className;
	}

}
