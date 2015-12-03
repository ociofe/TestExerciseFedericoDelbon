package com.federico.resources.utils;

import com.federico.resources.data.LineData;

public class MineUtils {
	
	public static LineData splitLine(String line){
		LineData lineData = new LineData();
		int lastSplit =0;
		int splitCount=0;
		for (int i = 1; i <= line.length() -2 ; i++){ 
			if((Character.isDigit(line.charAt(i-1)) &&  Character.isLetter(line.charAt(i+1))) ||
					(Character.isDigit(line.charAt(i+1)) &&  Character.isLetter(line.charAt(i-1))) ||
					(line.length() -2 == i)){
				if(splitCount ==0){
					lineData.setQta(Integer.valueOf(line.substring(lastSplit, i).trim()));
					splitCount = splitCount + 1;
					lastSplit = i;
					continue;
				}
				if(splitCount ==1){
					lineData.setDescription(line.substring(lastSplit, i+1).replace(" at ", ": "));
					splitCount = splitCount + 1;
					lastSplit = i;
					continue;
				}
				if(splitCount == 2){
					lineData.setPrice(Double.valueOf(line.substring(lastSplit, i+2).trim()));
					splitCount = splitCount + 1;
					lastSplit = i;
					continue;
				}
			}
		   
		}
		
		return lineData;
	}

}
