package reglog.logs.execution;


import reglog.logs.control.Utils;
import reglog.logs.control.RegLog;

public class Log extends RegLog{
	

	public static void fail(String log){
		RegLog regLog = new RegLog();
		regLog.logRegister(log, Utils.getWorkstationName() , System.getProperty("user.name"), Utils.getCallClassName(), EStatus.FAILED);
		System.err.println("[FAILED]:[" + log + "]:[" + Utils.getCallClassName() + "]");
	}
	public static void pass(String log) {
		RegLog regLog = new RegLog();
		regLog.logRegister(log, Utils.getWorkstationName() , System.getProperty("user.name"), Utils.getCallClassName(), EStatus.PASSED);
		System.out.println("[PASSED]:[" + log + "]:[" + Utils.getCallClassName() + "]");
	}
	public static void info(String log) {
		RegLog regLog = new RegLog();
		regLog.logRegister(log, Utils.getWorkstationName() , System.getProperty("user.name"), Utils.getCallClassName(), EStatus.INFORMATION);
		System.out.println("[INFORMATION]:[" + log + "]:[" + Utils.getCallClassName() + "]");
	}
	public static void title(String log) {
		RegLog regLog = new RegLog();
		regLog.logRegister(log, Utils.getWorkstationName() , System.getProperty("user.name"), Utils.getCallClassName(), EStatus.TITLE);
		System.out.println("[TITLE]:[" + log + "]:[" + Utils.getCallClassName() + "]");
	}
	public static void comment(String log) {
		RegLog regLog = new RegLog();
		regLog.logRegister(log, Utils.getWorkstationName() , System.getProperty("user.name"), Utils.getCallClassName(), EStatus.COMMENT);
		System.out.println("[COMMENT]:[" + log + "]:[" + Utils.getCallClassName() + "]");
	}


}
