import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Secure1 {

	public static void main(String[] args) throws IOException {
		String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuilder response = new StringBuilder();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		String res = response.toString();

		JsonObject jsonObject = new JsonParser().parse(res).getAsJsonObject();

		JsonElement totalPage = jsonObject.get("total_pages");
		int tp = totalPage.getAsInt();

		// System.out.println(totalPage);
		JsonArray datass = jsonObject.getAsJsonArray("data");
		List<String> list = new ArrayList<String>();
		for (JsonElement element : datass) {
			list.add(((JsonObject) element).get("Title").getAsString());
		}

		for (int i = 2; i <= tp; i++) {
			List<String> li = getData(i);
			list.addAll(li);
		}
		System.out.println(list.stream().sorted().collect(Collectors.toList()));
	}

	static List<String> getData(int pagNum) throws IOException {
		String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=" + pagNum;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuilder response = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		String res = response.toString();
		JsonObject jsonObject = new JsonParser().parse(res).getAsJsonObject();
		JsonArray datass = jsonObject.getAsJsonArray("data");
		List<String> list = new ArrayList<String>();
		for (JsonElement element : datass) {
			list.add(((JsonObject) element).get("Title").getAsString());
		}
		return list;
	}
}
