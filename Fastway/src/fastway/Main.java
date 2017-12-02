package fastway;

import java.awt.Desktop;
import java.io.File;

public class Main {


	public static void main(String[] args) throws Exception{
		
/*
		 ScriptEngineManager manager = new ScriptEngineManager();
         ScriptEngine engine = manager.getEngineByName("JavaScript");
         engine.eval(Files.newBufferedReader(Paths.get("src/fastway/mymap.js"), StandardCharsets.UTF_8));
         Invocable invvoc = (Invocable)engine;
         invvoc.invokeFunction("initMap", "");
  */       
         
         
         
         
        File htmlFile = new File("src/fastway/map2.html");
		Desktop.getDesktop().browse(htmlFile.toURI());
		
		Graph g = new Graph();
		//g.shortestway(Graph.MODE.SPEED, "양재역", "코엑스");
		
		
	}
	
	
}
