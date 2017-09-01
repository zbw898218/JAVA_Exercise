package charles.userproject.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputData {
	private BufferedReader buf=null;
	public InputData(){
		this.buf=new BufferedReader(new InputStreamReader(System.in));
	}
	public String getString(String info){
		String str=null;
		System.out.print(info);
		try {
			str=this.buf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public int getInt(String info,String err) {
		int i=0;
		String str=null;
		boolean flg=true;
		while(flg){
			str=this.getString(info);
			if(str.matches("\\d+")){
				i =Integer.parseInt(str);
				flg=false;
			}else{
				System.out.print(err);
			}
		}	
		return i;
	}
	
	
	
	public Date getDate(String info,String err){
		Date date=null;
		String str=null;
		boolean flg=true;
		while(flg){
			str=this.getString(info);
			if(str.matches("\\d{4}-\\d{2}-\\d{2}")){
				try {
					date =new SimpleDateFormat("yyyy-MM-dd").parse(str);
					flg=false;
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else{
				System.out.print(err);
			}
		}	
		return date;
	}
}
