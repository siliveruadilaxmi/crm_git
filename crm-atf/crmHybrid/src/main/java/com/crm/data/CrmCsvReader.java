package com.crm.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrmCsvReader {
	
	public static List<String> getCsvData() throws IOException  {
		List<String> csvdata = new ArrayList<String>();
		FileReader fr = new FileReader("C:\\Users\\ADI\\Desktop\\contleads.csv");
		BufferedReader br = new BufferedReader(fr);
		StringBuilder sb = new StringBuilder();
		String s = null;
		while((s = br.readLine() ) !=null) {
			sb.append(s);
			
			
		}
		
		String sc = sb.toString();
		String[] arr = sc.split(",");
		csvdata = Arrays.asList(arr);
		System.out.println(csvdata);
		
		return csvdata;
	}
	
	public static List<String> getLeadCsvData() throws IOException {
		List<String> leadcsvdata = new ArrayList<String>();
		FileReader file = new FileReader("C:\\Users\\vkovida\\Desktop\\leads.csv");
		BufferedReader br = new BufferedReader(file);
		StringBuilder sb = new StringBuilder();
		String s= null;
		while((s = br.readLine())!=null){
			sb.append(s);
		}
		String sc = sb.toString();
		String[] arr = sc.split(",");
		leadcsvdata = Arrays.asList(arr);
		System.out.println(leadcsvdata);
		
		return leadcsvdata;
		
	}
	
	public static List<String> getTaskCsvData() throws IOException {
		List<String> taskcsvdata = new ArrayList<String>();
		FileReader file = new FileReader("C:\\Users\\vkovida\\Desktop\\tasks.csv");
		BufferedReader br = new BufferedReader(file);
		StringBuilder sb = new StringBuilder();
		String s= null;
		while((s = br.readLine())!=null){
			sb.append(s);
		}
		String sc = sb.toString();
		String[] arr = sc.split(",");
		taskcsvdata = Arrays.asList(arr);
		System.out.println(taskcsvdata);
		
		return taskcsvdata;
		
	}		

}



