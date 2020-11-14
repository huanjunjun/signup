package domain;

public class user {
       private  Integer id;
	   private  String usernameString;
       private  String passwordString;
       private  String nameString;
       
       
    public Integer getId() {
   		return id;
   	}
   	public void setId(Integer id) {
   		this.id = id;
   	}
   	public String getUsernameString() {
   		return usernameString;
   	}
   	public void setUsernameString(String usernameString) {
   		this.usernameString = usernameString;
   	}
   	public String getPasswordString() {
   		return passwordString;
   	}
   	public void setPasswordString(String passwordString) {
   		this.passwordString = passwordString;
   	}
   	public String getNameString() {
   		return nameString;
   	}
   	public void setNameString(String nameString) {
   		this.nameString = nameString;
   	}
       
}
