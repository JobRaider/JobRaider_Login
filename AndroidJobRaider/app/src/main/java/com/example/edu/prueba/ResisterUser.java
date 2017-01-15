package com.example.edu.prueba;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ResisterUser extends Activity {
	 EditText userName,passwprd, apellido, dni;
	   Button resister,login;
	   ProgressBar progressBar;
	String ip = "192.168.1.101:8080";
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_resister_user);
	        userName=(EditText) findViewById(R.id.editText1);;
	        passwprd=(EditText) findViewById(R.id.editText2);
			apellido=(EditText) findViewById(R.id.editText3);
			dni=(EditText) findViewById(R.id.editText4);
	        resister=(Button) findViewById(R.id.button1);
	        
	        progressBar=(ProgressBar) findViewById(R.id.progressBar1);
	        progressBar.setVisibility(View.GONE);
	        
	        resister.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					progressBar.setVisibility(View.VISIBLE);
					
					String s1=userName.getText().toString();
					String s2=passwprd.getText().toString();
					String s3=apellido.getText().toString();
					String s4=dni.getText().toString();
					new ExecuteTask().execute(s1,s2,s3, s4);
				}
			});
	        
	       
	        
	        
	    }
	    
	    class ExecuteTask extends AsyncTask<String, Integer, String>
	    {

			@Override
			protected String doInBackground(String... params) {
				
				PostData(params);
				return null;
			}
			
			@Override
			protected void onPostExecute(String result) {
			progressBar.setVisibility(View.GONE);
			}
	    	
	    }
	    
	   
	    
	    public void PostData(String[] valuse) {
	    	try
	    	{
	    	HttpClient httpClient=new DefaultHttpClient();
	    	HttpPost httpPost=new HttpPost("http://" + ip + "/JobRaide-Servlet/httpPostServlet");
	    	List<NameValuePair> list=new ArrayList<NameValuePair>();
	    	list.add(new BasicNameValuePair("name", valuse[0]));
	    	list.add(new BasicNameValuePair("pass",valuse[1]));
				list.add(new BasicNameValuePair("ape",valuse[3]));
				list.add(new BasicNameValuePair("dni",valuse[4]));
	    	httpPost.setEntity(new UrlEncodedFormEntity(list));
	    	httpClient.execute(httpPost);
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println(e);
	    	}
			
		}
	public String readResponse(HttpResponse res) {
		InputStream is=null;
		String return_text="";
		try {
			is=res.getEntity().getContent();
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is));
			String line="";
			StringBuffer sb=new StringBuffer();
			while ((line=bufferedReader.readLine())!=null)
			{
				sb.append(line);
			}
			return_text=sb.toString();
		} catch (Exception e)
		{

		}

		return return_text;

	}
	   
	    }