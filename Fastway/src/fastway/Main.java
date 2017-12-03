package fastway;

import java.awt.Desktop;
import java.io.*;
import java.util.Arrays;



public class Main {


	public static void main(String[] args) throws Exception{
		
/*
		 ScriptEngineManager manager = new ScriptEngineManager();
         ScriptEngine engine = manager.getEngineByName("JavaScript");
         engine.eval(Files.newBufferedReader(Paths.get("src/fastway/mymap.js"), StandardCharsets.UTF_8));
         Invocable invvoc = (Invocable)engine;
         invvoc.invokeFunction("initMap", "");
  */       
         
        
		
		//Graph g = new Graph();
		//g.shortestway(Graph.MODE.SPEED, "도곡역", "강남역");
		
		try {
	        ////////////////////////////////////////////////////////////////
	        BufferedWriter out = new BufferedWriter(new FileWriter("map2.html"));	//map2.html 파일 생성
	        String s = "<html>\r\n" + 
	        		"<head>\r\n" + 
	        		"  \r\n" + 
	        		"  <title>Google Maps Multiple Markers</title>\r\n" + 
	        		"  <script src=\"http://maps.google.com/maps/api/js?sensor=false\" type=\"text/javascript\"></script>\r\n" + 
	        		"</head>\r\n" + 
	        		"<body>\r\n" + 
	        		"  <div id=\"map\" style=\"height: 800px; width: 800px;\">\r\n" + 
	        		"</div>\r\n" + 
	        		"<script type=\"text/javascript\">\r\n" + 
	        		"	var locations = ";
	        ;
	        out.write(s); out.newLine();
	        
	        String[][] Coord = {{"'논현역'","37.511063", "127.021354"},	//경유지 좌표
	        		{"'강남역'","37.497937", "127.027619"}};
	    	out.write(Arrays.deepToString(Coord));
	       
	        
	        	
	        	
	        	
	        String t = ";\n" +
	        		"function initMap(arg){\r\n" + 
	        		"	\r\n" + 
	        		"	var map = new google.maps.Map(document.getElementById('map'), {\r\n" + 
	        		"      zoom: 14,\r\n" + 
	        		"      center: new google.maps.LatLng(arg[1][1], arg[1][2]),\r\n" + 
	        		"      mapTypeId: google.maps.MapTypeId.ROADMAP\r\n" + 
	        		"    });\r\n" + 
	        		"    var infowindow = new google.maps.InfoWindow();\r\n" + 
	        		"    var marker, i;\r\n" + 
	        		"    for (i = 0; i < arg.length; i++) { \r\n" + 
	        		"      marker = new google.maps.Marker({\r\n" + 
	        		"        position: new google.maps.LatLng(arg[i][1], arg[i][2]),\r\n" + 
	        		"        map: map\r\n" + 
	        		"      });\r\n" + 
	        		"      google.maps.event.addListener(marker, 'click', (function(marker, i) {\r\n" + 
	        		"        return function() {\r\n" + 
	        		"          infowindow.setContent(locations[i][0]);\r\n" + 
	        		"          infowindow.open(map, marker);\r\n" + 
	        		"        }\r\n" + 
	        		"      })(marker, i));\r\n" + 
	        		"    }\r\n" + 
	        		"}\r\n" + 
	        		"	initMap(locations);\r\n" + 
	        		"  </script>\r\n" + 
	        		"</body>\r\n" + 
	        		"</html>\r\n" + 
	        		"\r\n";

	        
	        out.write(t);
	        out.close();
	        ////////////////////////////////////////////////////////////////
	      } catch (IOException e) {
	          System.err.println(e); // 에러가 있다면 메시지 출력
	          System.exit(1);
	      }
		
		
		File htmlFile = new File("map2.html");
		Desktop.getDesktop().browse(htmlFile.toURI());	//생성된 html 파일 열기
	}
	
	
}
