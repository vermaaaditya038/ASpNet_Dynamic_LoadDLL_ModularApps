package test;

public class ModelSportStop{
	
	String sUsername;
	String sPassword;
	String sFirstname;
	String sRegionName;
	String sStateName;
	
//	public ModelSportStop(String sUsername,String sPassword,String sFirstname){
//		this.sUsername = sUsername;
//		this.sPassword = sPassword;
//		this.sFirstname = sFirstname;
//		
//	}
//	
	public ModelSportStop(){

	}
	public String getsUsername(){
		return sUsername;
		
	}
	
	public void setRegionName(String sRegionName)
	{
		this.sRegionName = sRegionName;
	}
	
	public String getRegionName()
	{
		return sRegionName;
	}
	
	public String getStateName()
	{
		return sStateName;
	}

	public void setStateName(String sStateName)
	{
		this.sStateName = sStateName;
	}
	
	public void setsUsername(String sUsername){
		this.sUsername = sUsername;
	}
	
	
	public void setsPassword(String sPassword){
		this.sPassword = sPassword;
	
	}
	
	public void setsFirstname(String sFirstname){
		this.sFirstname = sFirstname;
	
	}
	

	public String getsFirstname(){
		return sFirstname;
		
	}
	
}