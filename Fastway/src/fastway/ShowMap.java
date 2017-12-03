package fastway;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ShowMap {
	public static void showload(String[][] Coord) {
		
		try {
	        
	        BufferedWriter out = new BufferedWriter(new FileWriter("map2.html"));	//write html file
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
	        
	        //String[][] Coord = {{"'�끉�쁽�뿭'","37.511063", "127.021354"},	//寃쎌쑀吏� 醫뚰몴
	        	//	{"'媛뺣궓�뿭'","37.497937", "127.027619"}};
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
	        //
	      } catch (IOException e) {
	          System.err.println(e);  //print error
	          System.exit(1);
	      }
		
		
		File htmlFile = new File("map2.html");
		try {
		Desktop.getDesktop().browse(htmlFile.toURI());	//open html
	
		}catch(IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}
}
