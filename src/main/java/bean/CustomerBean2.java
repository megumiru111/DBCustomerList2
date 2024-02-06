package bean;

import java.io.Serializable;

public class CustomerBean2 implements Serializable {
  private int no;
  private String product_no;
  private String product_name;
  private String delivery_date; 
  private String company_name;
  private String person_in_charge;
  private String department_in_charge;
  private String post;
  private String addres;
  private String telephone_number;
  private String mail_addres;
  private String action;
  private String trading_history;
  private String notes;
    
  public void setNo(int no) {
    this.no = no;
  }
  public void setProduct_no(String product_no) {
    this.product_no = product_no;
  }
  public void setProduct_name(String product_name) {
	  this.product_name = product_name;
  }
  public void setDelivery_date(String delivery_date) {
    this.delivery_date = delivery_date;
  }
  public void setCompany_name(String company_name) {
	  this.company_name = company_name;
  }
  public void setPerson_in_charge(String person_in_charge) {
	  this.person_in_charge = person_in_charge;
  }  
  public void setDepartment_in_charge(String department_in_charge) {
	  this.department_in_charge = department_in_charge;
  } 
  public void setPost (String post) {
	  this.post = post ;
  } 
  public void setAddres(String addres) {
	  this.addres = addres;
  } 
  public void setTelephone_number(String  telephone_number) {
	  this. telephone_number =  telephone_number;
  } 
  public void setMail_addres(String mail_addres) {
	  this.mail_addres = mail_addres;
  } 
  public void setAction(String action) {
	  this.action = action;
  } 
  public void setTrading_history(String trading_history) {
	  this.trading_history =  trading_history ;
  } 
  public void setNotes(String notes) {
	  this.notes = notes;
  }   
  
  public int getNo() {
    return no; 
  }
  public String getProduct_no() {
    return product_no; 
  }
  public String getProduct_name() {
    return product_name;
  }
  public String getDelivery_date() {
  	return delivery_date;
  }
  public String getCompany_name() {
  	return company_name;
  }
  public String getPerson_in_charge() {
  	return person_in_charge;
  }
  public String getDepartment_in_charge() {
  	return department_in_charge;
  }
  public String getPost() {
  	return post;
  }
  public String getAddres() {
  	return addres;
  }
  public String getTelephone_number() {
  	return telephone_number;
  }
  public String getMail_addres() {
  	return mail_addres;
  }
  public String getAction() {
  	return action;
  }
  public String getTrading_history() {
  	return trading_history;
  }
  public String getNotes() {
  	return notes;
  }
}