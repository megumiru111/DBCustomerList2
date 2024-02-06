package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerDAO2 {
  private final String URL = "jdbc:mysql://localhost/sampledb";
  private final String USER = "root";
  private final String PASS = "pass";
  private Connection con = null;

  public void connect(){
    try{
      //①DBに接続
      con = DriverManager.getConnection(URL, USER, PASS);
    } catch(Exception e){
      e.printStackTrace();
    }
  }
  
  public CustomerDTO2 select() {
    Statement stmt = null;
    ResultSet rs = null;
    CustomerDTO2 cdto = new CustomerDTO2();
    String sql = "SELECT * FROM customerlist";
    try{
      connect();
      //②ステートメントを生成
      stmt = con.createStatement();
      //③SQLを実行
      rs = stmt.executeQuery(sql);
      //④検索結果の処理
      while(rs.next()){
    	  CustomerBean2 cb = new CustomerBean2();
        cb.setNo(rs.getInt("no"));
        cb.setProduct_no(rs.getString("product_no"));
        cb.setProduct_name(rs.getString("product_name"));
        cb.setDelivery_date(rs.getString("delivery_date"));
        cb.setCompany_name(rs.getString("company_name"));
        cb.setPerson_in_charge(rs.getString("person_in_charge"));
        cb.setDepartment_in_charge(rs.getString("department_in_charge"));
        cb.setPost(rs.getString("post"));
        cb.setAddres(rs.getString("addres"));
        cb.setTelephone_number(rs.getString("telephone_number"));
        cb.setMail_addres(rs.getString("mail_addres"));
        cb.setAction(rs.getString("action"));
        cb.setTrading_history(rs.getString("trading_history"));
        cb.setNotes(rs.getString("notes"));        
        cdto.add(cb);
      }
    } catch(Exception e){
      e.printStackTrace();
    } finally {
      try{
        if(rs != null) rs.close();
        if(stmt != null) stmt.close();
      } catch(Exception e){
        e.printStackTrace();
      }
    }
    disconnect();
    return cdto;
  }
  
  public int insert(int no, String product_no, String product_name, String delivery_date,
      String company_name, String person_in_charge, String department_in_charge, String post,
      String addres, String teleophone_number, String mail_addres, String acton, String trading_history,
      String notes) {
    String sql = "INSERT INTO customerlist VALUES ("
    		           + no + ", '" + product_no + "', '" + product_name + "', '" + delivery_date + "', '" + company_name
    		           + "', '" + person_in_charge +  "', '" + department_in_charge + "', '" + post + "', '" + addres + "', '"
    		           + teleophone_number + "', '" + mail_addres + "', '" + acton + trading_history + "', '" + notes + ")";
    return executeSql(sql);
  }
  
  public int update(int no, String product_no, String product_name, String delivery_date,
      String company_name, String person_in_charge, String department_in_charge, String post,
      String addres, String teleophone_number, String mail_addres, String acton, String trading_history,
      String notes) {
  	String sql = "UPDATE customerlist SET no = " + no + ", product_no = '" + product_no + "', product_name = '" + product_name
  			         + "', delivery_date = '" + delivery_date + "', company_name = '" + company_name + "', person_in_charge = '" + person_in_charge
  			         + "', department_in_charge = '" + department_in_charge + "', post = '" + post + "', addres = '" + addres + "', teleophone_number = '" + teleophone_number
  			         + "', mail_addres = '" + mail_addres + "', acton = '" + acton + "', trading_history = '" + trading_history + "', notes = '" + notes
  			         + "'  WHERE no = " + no; 
  	return executeSql(sql);
  }
  
  public int delete(int no) {
  	String sql = "DELETE FROM customerlist WHERE no = " + no;
    return executeSql(sql);  	
  }
  
  public int executeSql(String sql) {
    Statement stmt = null;
    ResultSet rs = null;
    int result = 0;
    try{
      connect();
      //②ステートメントを生成
      stmt = con.createStatement();
      //③SQLを実行
      result = stmt.executeUpdate(sql);
    } catch(Exception e){
      e.printStackTrace();
    } finally {
      try{
        if(rs != null) rs.close();
        if(stmt != null) stmt.close();
      } catch(Exception e){
        e.printStackTrace();
      }
    }
    disconnect();
    return result;
  }
    
  public void disconnect(){
    try{
      //⑤DBを切断
      if(con != null) con.close();
    } catch(Exception e){
      e.printStackTrace();
    }
  }
}
