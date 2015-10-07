package hr.neos.test.pagecode;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean (name ="loginPageCode")
@SessionScoped
public class LoginPageCode implements Serializable {
	private static final long serialVersionUID = -1611162265998907599L;

	public String getFacebookUrlAuth() {
		HttpSession session =
		(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		String sessionId = session.getId();
		String appId = "1616657588603571";
		String redirectUrl = "http://localhost:8080/WEB-INF/index.sec";
		String returnValue = "https://www.facebook.com/dialog/oauth?client_id=" 
				+ appId + "&redirect_uri=" + redirectUrl 
				+ "&scope=email,user_birthday&state=" + sessionId;
		return returnValue;
	}  
	
	public String getUserFromSession() {
		HttpSession session =
		(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		String userName = (String) session.getAttribute("FACEBOOK_USER");
		if (userName != null) {
			return "Hello " + userName;
		}
		else {
			return "";
		}
	}
        
        public String getUserName() {
		HttpSession session =
		(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		String userName = (String) session.getAttribute("FACEBOOK_USER");
		if (userName != null) {
			return userName;
		}
		else {
			return "";
		}
	}
        
         public String getUserPassword() {
		HttpSession session =
		(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		String password = (String) session.getAttribute("FACEBOOK_PASS");
		if (password != null) {
			return  password;
		}
		else {
			return "";
		}
	}
}