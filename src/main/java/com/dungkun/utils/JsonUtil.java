package com.dungkun.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonUtil {
	
	public static JsonUtil jsonUtil;
	public static JsonUtil instance() {
		if(jsonUtil == null) {
			jsonUtil = new JsonUtil();
		}
		
		return jsonUtil;
	}
	
	public List<Long> getIdsListFromJsonNode(JsonNode jsonNode) {
		JsonNode idsNode = jsonNode.path("ids");
		Iterator<JsonNode> elements = idsNode.elements();
		List<Long> ids = new ArrayList<Long>();
		
		while (elements.hasNext()) {
			JsonNode id = elements.next();
			ids.add(id.asLong());
		}
		
		return ids;
	}

	public JsonNode getJsonNodefromJsonString(String jsonString) {

		return null;
	}
}
