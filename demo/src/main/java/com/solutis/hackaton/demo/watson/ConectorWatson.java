package com.solutis.hackaton.demo.watson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ElementTone;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneCategory;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneScore;

@Component
public class ConectorWatson {

	public String analisar(String texto) {
		System.out.println("Texto: " + texto);
		
		Map<String, Object> map = new HashMap();
		map.put("textToAnalyze", texto);
		map.put("username", "1f312b13-bf67-4b9a-a2e3-1a3c81656861");
		map.put("password", "u0Y6cQUqfPwZ");
		map.put("endpoint", "https://gateway.watsonplatform.net/tone-analyzer/api");
		map.put("skip_authentication", true);
		
		JsonParser parser = new JsonParser();
		JsonObject jsonArgs = parser.parse(new Gson().toJson(map)).getAsJsonObject();
		
		return main(jsonArgs);
		
	}

	 public static String main(JsonObject args) {
		    JsonParser parser = new JsonParser();
		    StringBuilder builder = new StringBuilder();

		    ToneAnalyzer service = new ToneAnalyzer("2016-05-19");
		    service.setUsernameAndPassword(args.get("username").getAsString(),
		                                   args.get("password").getAsString());

		    if (args.get("endpoint")!=null)
		      service.setEndPoint(args.get("endpoint").getAsString());

		    if (args.get("skip_authentication") != null)
		      service.setSkipAuthentication((args.get("skip_authentication")
		      .getAsString() == "true") ? true : false);

		    ToneAnalysis result =
		        service.getTone(args.get("textToAnalyze").getAsString(), null).
		        execute();

		    ElementTone elementTone = result.getDocumentTone();
		    List<ToneCategory> toneCategories = elementTone.getTones();
		    for (ToneCategory nextCategory : toneCategories) {
		      System.out.println("Analysis for " + nextCategory.getName());
		      builder.append("Analysis for " + nextCategory.getName());
		      builder.append("\n");

		      List<ToneScore> toneScores = nextCategory.getTones();
		      
		      for (ToneScore nextScore : toneScores) {
		        System.out.println("    " + nextScore.getName() + " = " +
		                           (int)(nextScore.getScore() * 100) + "%");
		        builder.append("    " + nextScore.getName() + " = ");
		        builder.append((int)(nextScore.getScore() * 100) + "%");
		        builder.append("\n");
		      }
		      System.out.println();
		      builder.append("\n");
		    }

		    JsonObject returnObject = parser.parse(result.toString()).getAsJsonObject();
		    return builder.toString();
		  }
}
