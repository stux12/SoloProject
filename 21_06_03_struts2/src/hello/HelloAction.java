package hello;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action{

	
	private String msg;
	
	public String getMsg() {
		return msg;
	}

	
	@Override
	public String execute() throws Exception {
		
		this.msg="Hello Struct2 World";
		
		return SUCCESS;
	}
	
}
 