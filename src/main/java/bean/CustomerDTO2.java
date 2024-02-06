package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerDTO2 implements Serializable {
  private ArrayList<CustomerBean2> list;

  public CustomerDTO2() {
    list = new ArrayList<CustomerBean2> ();
  }
  public void add(CustomerBean2 cb) {
    list.add(cb);
  }
  public CustomerBean2 get(int i) {
    return list.get(i);
  }
  public int size() {
    return list.size();
  }
}