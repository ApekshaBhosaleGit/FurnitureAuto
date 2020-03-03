package com.project.services;

public class UserDetails {

	 String emailID;
	 String password;
	 
	 public UserDetails(String emailID, String password) {
		this.emailID = emailID;
		this.password = password;
	}
	 
	 public String getEmailID() {
		 return emailID;
		 }
		 
		 public void setEmailID(String emailID) {
		 this.emailID = emailID;
		 }
		 
		 public String getPassword() {
		 return password;
		 }
		 
		 public void setPassword(String password) {
		 this.password = password;
		 }
		 
		        public String toString(){
		                return "The User Details are emailID : " + this.emailID + " and Password " + this.password; 
		        }
		 
}
