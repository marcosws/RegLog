package reglog.logs.model.entity;

import java.sql.Timestamp;

public class Log {
	
	private int idLog;
	private String logText;
	private int idWorkstation;
	private int idUser;
	private int  idClassName;
	private int  idStatus;
	private Timestamp dateTime;
	
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public int getIdLog() {
		return idLog;
	}
	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}
	public String getLogText() {
		return logText;
	}
	public void setLogText(String logText) {
		this.logText = logText;
	}
	public int getIdWorkstation() {
		return idWorkstation;
	}
	public void setIdWorkstation(int idWorkstation) {
		this.idWorkstation = idWorkstation;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdClassName() {
		return idClassName;
	}
	public void setIdClassName(int idClassName) {
		this.idClassName = idClassName;
	}
	public int getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	
	
	

}
