package com.sage.scrm.vanke.module.pay.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapConvertor {
	@XmlElement(name="entry")
	private List<MapEntry> entries = new ArrayList<MapEntry>();

	public void addEntry(MapEntry entry) {
		entries.add(entry);
	}

	public static class MapEntry {

		private String key;
		private Object value;

		public MapEntry() {
			super();
		}

		public MapEntry(Map.Entry<String, Object> entry) {
			super();
			this.key = entry.getKey();
			this.value = entry.getValue();
		}

		public MapEntry(String key, Object value) {
			super();
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}
	}
	
	public List<MapEntry> getEntries() {
		return entries;
	}
	
	public static MapConvertor mapToConvertor(Map<String, Object> map){
		MapConvertor convertor = new MapConvertor();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			MapConvertor.MapEntry e = new MapConvertor.MapEntry(entry);
			convertor.addEntry(e);
		}
		return convertor;
	}
	
	public static Map<String, Object> convertorToMap(MapConvertor convertor){
		Map<String, Object> result = new HashMap<String, Object>();
		for (MapConvertor.MapEntry e : convertor.getEntries()) {
			result.put(e.getKey(), e.getValue());
		}
		return result;
	}
}
