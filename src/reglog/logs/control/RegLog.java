package reglog.logs.control;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import reglog.logs.model.dao.ClassNameDao;
import reglog.logs.model.dao.LogDao;
import reglog.logs.model.dao.StatusDao;
import reglog.logs.model.dao.UserDao;
import reglog.logs.model.dao.WorkstationDao;
import reglog.logs.model.entity.ClassName;
import reglog.logs.model.entity.Log;
import reglog.logs.model.entity.Status;
import reglog.logs.model.entity.User;
import reglog.logs.model.entity.Workstation;

public class RegLog {
	
	public enum EStatus{
		FAIL, PASS, TITLE, INFO;
	}
	
	public void logRegister(String strLog, String strWorkstation, String strUser, String strClassName, EStatus enumStatus) {
		
		String strStatus = null;
		int idUser = 0;
		int idStatus = 0;
		int idWorkstation = 0;
		int idClassName = 0;
		
		User user = new User();
		user.setNameUser(strUser);
		UserDao userDao = new UserDao();
		userDao.insert(user);
		List<User> users = new ArrayList<User>();
		users = userDao.select();
		for(User u: users)
			if(u.getNameUser().equals(strUser))
				idUser = u.getIdUser();
		
		Workstation workstation = new Workstation();
		workstation.setWorkstationName(strWorkstation);
		WorkstationDao workstationDao = new WorkstationDao();
		workstationDao.insert(workstation);
		List<Workstation> workstations = new ArrayList<Workstation>();
		workstations = workstationDao.select();
		for(Workstation w: workstations)
			if(w.getWorkstationName().equals(strWorkstation))
				idWorkstation = w.getIdWorkstation();
		
		ClassName className = new ClassName();
		className.setNameClass(strClassName);
		ClassNameDao classNameDao = new ClassNameDao();
		classNameDao.insert(className);
		List<ClassName> classNames = new ArrayList<ClassName>();
		classNames = classNameDao.select();
		for(ClassName c: classNames)
			if(c.getNameClass().equals(strClassName))
				idClassName = c.getIdClassName();
		
		StatusDao statusDao = new StatusDao();
		List<Status> statusList = new  ArrayList<Status>();
		statusList = statusDao.select();
		if(EStatus.FAIL.equals(enumStatus)) {
			strStatus = "FAILED";
		}
		else if(EStatus.PASS.equals(enumStatus)) {
			strStatus = "PASSED";
		}
		else if(EStatus.TITLE.equals(enumStatus)) {
			strStatus = "TITLE";
		}
		else if(EStatus.INFO.equals(enumStatus)) {
			strStatus = "INFORMATION";
		}
		for(Status s: statusList) 
			if(s.getNameStatus().equals(strStatus)) 
				idStatus = s.getIdStatus();
			
		
		Log log = new Log();
		LogDao logDao = new LogDao();
		log.setLogText(strLog);
		log.setDateTime(Timestamp.valueOf(LocalDateTime.now()));
		log.setIdClassName(idClassName);
		log.setIdUser(idUser);
		log.setIdWorkstation(idWorkstation);
		log.setIdStatus(idStatus);
		logDao.insert(log);
		
	}

}
