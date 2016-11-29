package com.util;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ResourceUtil {
	public static <X> X retrieveResource(HttpResponse resp, Class<X> cl) {
		String json;
		X list = null;
		try {
			json = EntityUtils.toString(resp.getEntity());
			ObjectMapper mapper = new ObjectMapper();
			list = mapper.readValue(json, cl);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

}
