/**
 * 
 */
package com.playarea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.net.ssl.HttpsURLConnection;

/**
 * @author chandrashekharv
 *
 */
public class MovieTitles {

	private static final String BASE_URL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String queryString = "spiderman";
		int times = 1;
		int page = 1;
		try {
			List<String> titles = new ArrayList<>();
			while (page <= times) {
				URL url = new URL(BASE_URL + queryString + "&page=" + page);
				HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

				try (InputStream inputStream = connection.getInputStream();
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
					String input;

					while ((input = bufferedReader.readLine()) != null) {
						Response response = Response.getInstance();
						titles.addAll(response.parse(input));
						if (times == 1)
							times = response.totalPages;
					}
					page = page + 1;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			Collections.sort(titles); 
			titles.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static class Response {

		private int totalPages = -1;

		private static Response INSTANCE = new Response();

		public int getTotalPages() {
			return totalPages;
		}

		private Response() {
		}

		public static Response getInstance() {
			return INSTANCE;
		}

		public List<String> parse(String jsonString) {
			if (totalPages == -1) {
				System.out.println(jsonString.indexOf("total_pages"));

				totalPages = Integer.parseInt(String
						.valueOf(jsonString.charAt(jsonString.indexOf("total_pages") + "total_pages".length() + 2)));

			}
			List<String> titles = new ArrayList<>();
			while (jsonString.indexOf("Title") > 0) {
				titles.add(jsonString.substring(jsonString.indexOf("Title") + 8, jsonString.indexOf("Type") - 3));
				jsonString = jsonString.substring(jsonString.indexOf("Type") + 6);
			}
			return titles;
		}
	}

}
