package com.sabel.resttest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {
	
	
	public static void getOneRequest(String type, int id) throws IOException {
		HttpURLConnection connection = null;
		URL url = new URL("http://localhost:8080/Erde/world/City/id/"+id);
		connection=(HttpURLConnection) url.openConnection();
		//connection.setRequestMethod("GET"); Ist Standardmäßig GET!!!
		connection.setRequestProperty("Accept", "application/"+type);
		
		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String output;
		while ((output=br.readLine()) != null) {
			System.out.println(output);
		}
		br.close();
	}
	
	public static void getAllRequest(String type) throws IOException {
		HttpURLConnection connection = null;
		URL url = new URL("http://localhost:8080/Erde/world/City");
		connection=(HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/"+type);
		
		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String output;
		while ((output=br.readLine()) != null) {
			System.out.println(output);
		}
		br.close();
	}
	
	public static void main(String[] args) {
		try {
			getOneRequest("json", 3740);
			getAllRequest("xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
