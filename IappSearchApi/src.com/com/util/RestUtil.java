package com.util;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import com.pojo.MyPojo;

public class RestUtil {
	
	HttpResponse response;
	private MyPojo pojo;

	public MyPojo getMyPojo() {
		return pojo;
	}

	public void setMyPojo(MyPojo pojo) {
		this.pojo = pojo;
	}

	public void getRequest(String URI) {
		try {
			HttpGet get = new HttpGet(URI);
			get.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
			response = HttpClientBuilder.create().build().execute(get);
			if (response != null) {
				setMyPojo(ResourceUtil.retrieveResource(response, MyPojo.class));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int validateStatusCode() {
		return response.getStatusLine().getStatusCode();
	}

	public String validateResultCount() {
		pojo = getMyPojo();
		return pojo.getResultCount();
	}

	public String validateArtistId() {
		return getMyPojo().getResults()[0].getArtistId();
	}

	public String validateArtistName() {
		return getMyPojo().getResults()[0].getArtistName();
	}

}
