package com.elead.spring.mvc;

import java.util.HashMap;
import java.util.Map;

public class ModelView {

	public ModelView() {

	}

	public ModelView(String url) {
		this.url = url;
	}

	public void addData(String key, Object value) {
		if (dataMap == null) {
			dataMap = new HashMap<String, Object>();
		}
		dataMap.put(key, value);
	}

	private String url;
	private Map<String, Object> dataMap;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

}
