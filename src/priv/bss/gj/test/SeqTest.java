package priv.bss.gj.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author miansen.wang
 * @date 2018年12月17日 下午4:57:05
 */
public class SeqTest {
	
	public static void main(String[] args) {
		try {
			URL url = new URL("https://134.225.249.108:9999/udal/config/schemas/sequences?pageNow=1&pageSize=10&schemaId=%2Fdbproxy_cluster%2Fdbproxy_cluster_0000000275%2Fschemas%2Fschema_0000013945&sequenceName=");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setDoInput(true);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.connect();
			InputStream inputStream = httpURLConnection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			httpURLConnection.disconnect();
			System.out.println(buffer.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
