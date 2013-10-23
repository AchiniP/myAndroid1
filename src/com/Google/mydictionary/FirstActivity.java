package com.Google.mydictionary;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.content.res.AssetManager;
import android.view.Menu;
import android.view.View;
import java.util.*;
import java.io.*;

public class FirstActivity extends Activity {
	 EditText text;
	 Button find;
	 TextView display;
	EditText result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        text = (EditText) findViewById(R.id.editText1);
        find= (Button)findViewById(R.id.button1);
        result=(EditText) findViewById(R.id.txtresult);
        
       
        find.setOnClickListener(new View.OnClickListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void onClick(View v){
				// TODO Auto-generated method stub
				// Scanner scanner;
				
				AssetManager am =getResources().getAssets();
				InputStream fstream;
				
				try {
					fstream = am.open("A.txt");
				
			

		     DataInputStream in = new DataInputStream(fstream);
		     BufferedReader br = new BufferedReader(new InputStreamReader(in));
		       

				
			      String strLine;
				
			      List<String[]> rows = new ArrayList<String[]>();
			      

		        HashMap<String, String> map = new HashMap<String,String>();

		        while ((strLine = br.readLine()) != null) {
		        	//List columns=new ArrayList();
		        	//columns.add(strLine.split(","));
		            String[] columns = strLine.split("-");
		            rows.add(columns);
		            map.put(columns[0], columns[1]);
		        }
			      String answer= (String) map.get(text.getText().toString());
			      result.setText(answer);
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_first, menu);
        return true;
    }
    
    
    
    
    
}
