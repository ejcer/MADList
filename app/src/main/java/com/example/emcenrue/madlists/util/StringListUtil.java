package com.example.emcenrue.madlists.util;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by emcenrue on 4/7/2015.
 */
public class StringListUtil {

    final static String FILENAME = "filename_goes_here.json";


    public static boolean writeWordsToFile(ArrayList<String> words, Context context){

        JSONArray jsonArray = new JSONArray();
        for(int i = 0; i < words.size(); i++){
            jsonArray.put(words.get(i));
        }
        JSONObject jsonObj = new JSONObject();

        try {
            jsonObj.put("wordsList", jsonArray); //TODO change in read
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }

        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            try {
                String serialText = jsonObj.toString();
                fos.write(serialText.getBytes());
                fos.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static ArrayList<String> readWords(Context context){
        FileInputStream fis = null;
        StringBuilder sb = new StringBuilder();

        try {
            fis = context.openFileInput(FILENAME);
            BufferedInputStream bis = new BufferedInputStream(fis);
            try {
                while(bis.available() != 0){
                    char c = (char) bis.read();
                    sb.append(c);
                }
                bis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        ArrayList<String> wordsList = new ArrayList<String>();

        //If nothing has been written then the sb.toString == ""
        if(sb.toString() == "" || sb.toString() == null){
            return wordsList;
        }

        try {
            JSONObject json = new JSONObject(sb.toString());
            JSONArray jsonArray = (JSONArray)json.get("wordsList");
            for(int i = 0; i < jsonArray.length(); i++){
                wordsList.add(jsonArray.get(i).toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return wordsList;





    }


}
