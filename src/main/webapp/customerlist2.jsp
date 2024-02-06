<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.*" %>
<jsp:useBean id ="cdto" scope="request" class="bean.CustomerDTO2" />
<jsp:useBean id ="msg" scope="request" class="java.lang.String" />
<html>
  <head>
    <title>〇〇株式会社顧客データベース</title>
  </head>
<body>
<h2><%= msg %></h2>
<table border="1">
  <tr>
    <th width="80">判別ID（主キー）</th>
    <th width="80">製品番号</th>
    <th width="80">製品名</th>
    <th width="80">納品日</th>
    <th width="80">企業名</th>
    <th width="80">担当者名</th>
    <th width="80">担当部署</th>
    <th width="80">役職</th>
    <th width="130">住所</th> 
  　<th width="80">電話番号</th>  
    <th width="80">メールアドレス</th> 
    <th width="80">対応状況</th> 
    <th width="80">取引履歴</th>
    <th width="80">特記事項</th>
  </tr>
<%
  for(int i = 0; i < cdto.size(); i++){
    CustomerBean2 cb = cdto.get(i);
%>
  <tr>
    <td align="center"><%= cb.getNo() %></td>
    <td align="center"><%= cb.getProduct_no() %></td>
    <td align="center"><%= cb.getProduct_name() %></td>
    <td align="center"><%= cb.getDelivery_date() %></td>
    <td align="center"><%= cb.getCompany_name() %></td>
    <td align="center"><%= cb.getPerson_in_charge() %></td>
    <td align="center"><%= cb.getDepartment_in_charge() %></td>
    <td align="center"><%= cb.getPost() %></td>
    <td align="center"><%= cb.getAddres() %></td>
    <td align="center"><%= cb.getTelephone_number() %></td>
    <td align="center"><%= cb.getMail_addres() %></td>
    <td align="center"><%= cb.getAction() %></td>
    <td align="center"><%= cb.getTrading_history() %></td>
    <td align="center"><%= cb.getNotes() %></td>
  </tr>
<% } %>
</table><br />
<a href="/DBCustomerList2/customerlist2.html">戻る</a>
</body>
</html>
    