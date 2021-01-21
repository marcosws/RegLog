package reglog.logs.execution;


import reglog.logs.control.Common;
import reglog.logs.control.RegLog;
import reglog.logs.control.RegLog.EStatus;

public class Log {
	

	public static void fail(String log){
		RegLog regLog = new RegLog ();
		regLog.logRegister(log, Common.getWorkstationName() , System.getProperty("user.name"), Common.getCallClassName(), EStatus.FAIL);
		System.err.println("[FAIL]:[" + log + "]:[" + Common.getCallClassName() + "]");
	}
	public static void pass(String log) {
		RegLog regLog = new RegLog();
		regLog.logRegister(log, Common.getWorkstationName() , System.getProperty("user.name"), Common.getCallClassName(), EStatus.PASS);
		System.out.println("[PASS]:[" + log + "]:[" + Common.getCallClassName() + "]");
	}
	public static void info(String log) {
		RegLog regLog = new RegLog();
		regLog.logRegister(log, Common.getWorkstationName() , System.getProperty("user.name"), Common.getCallClassName(), EStatus.INFO);
		System.out.println("[INFO]:[" + log + "]:[" + Common.getCallClassName() + "]");
	}
	public static void title(String log) {
		RegLog regLog = new RegLog();
		regLog.logRegister(log, Common.getWorkstationName() , System.getProperty("user.name"), Common.getCallClassName(), EStatus.TITLE);
		System.out.println("[TITLE]:[" + log + "]:[" + Common.getCallClassName() + "]");
	}


}
