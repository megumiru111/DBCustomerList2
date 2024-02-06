package bean;  

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customerlist2")
public class CustomerListServlet2 extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {
  	String msg = "全ての顧客情報を表示します";
  	//入力値（ｂｔｎ）を取得
  	req.setCharacterEncoding("utf-8");
  	String btn = req.getParameter("btn");
    //DAOオブジェクトを生成
    CustomerDAO2 cdao = new CustomerDAO2();
    //押下ボタンによる分岐処理
    if (btn.equals("追加")) {
    	int no = Integer.parseInt(req.getParameter("no"));
      String puroduct_no = req.getParameter("puroduct_no");
   	  String puroduct_name = req.getParameter("puroduct_name");
   	  String delivery_date = req.getParameter("delivery_date");
   	  String company_name = req.getParameter("company_name");
   	  String person_in_charge = req.getParameter("person_in_charge");
   	  String department_in_charge = req.getParameter("department_in_charge");
   	  String post = req.getParameter("post");
   	  String addres = req.getParameter("addres");
   	  String telephone_number = req.getParameter("telephone_number");
   	  String mail_addres = req.getParameter("mail_addres");
   	  String action = req.getParameter("action");
   	  String trading_history = req.getParameter("trading_history");
   	  String notes = req.getParameter("notes");    	  	 
      cdao.insert(no, puroduct_no, puroduct_name, delivery_date, company_name,
   	     person_in_charge, department_in_charge, post, addres, telephone_number, 
   			 mail_addres, action, trading_history, notes);
      msg = "判別ID（主キー）" + no + "の顧客情報を追加しました";
    	
     } else if (btn.equals("修正")) {
    	 int no = Integer.parseInt(req.getParameter("no"));
    	 String puroduct_no = req.getParameter("puroduct_no");
    	 String puroduct_name = req.getParameter("puroduct_name");
    	 String delivery_date = req.getParameter("delivery_date");
    	 String company_name = req.getParameter("company_name");
    	 String person_in_charge = req.getParameter("person_in_charge");
    	 String department_in_charge = req.getParameter("department_in_charge");
    	 String post = req.getParameter("post");
    	 String addres = req.getParameter("addres");
    	 String telephone_number = req.getParameter("telephone_number");
    	 String mail_addres = req.getParameter("mail_addres");
    	 String action = req.getParameter("action");
    	 String trading_history = req.getParameter("trading_history");
    	 String notes = req.getParameter("notes");    	  	 
       cdao.update(no, puroduct_no, puroduct_name, delivery_date, company_name,
    	     person_in_charge, department_in_charge, post, addres, telephone_number, 
    			 mail_addres, action, trading_history, notes);
      msg = "判別ID（主キー）" + no + "の顧客情報を修正しました";
     } else if (btn.equals("削除")) {
    	 int no = Integer.parseInt(req.getParameter("no"));
    	 cdao.delete(no);
    	 msg = "判別ID（主キー）" + no + "の顧客情報を削除しました";
     }
     //全件検索
     CustomerDTO2 cdto = cdao.select();
     //リクエストスコープにDTOとmsgを格納
     req.setAttribute("cdto", cdto);
     req.setAttribute("msg", msg);
     //JSPにフォワード
     RequestDispatcher rd = req.getRequestDispatcher("/customerlist2.jsp");
     rd.forward(req, res);
  }
  
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {
    doPost(req, res);
  }
}