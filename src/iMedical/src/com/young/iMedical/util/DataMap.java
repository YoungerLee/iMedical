package com.young.iMedical.util;

import java.util.HashMap;
import java.util.Map;

public class DataMap {
	private static Map<String, Integer> medFreq = new HashMap<String, Integer>();
	private static Map<String, Integer> freqNum = new HashMap<String, Integer>();
	static {
		medFreq.put("每日3次", 3);
		medFreq.put("每日2次", 2);
		medFreq.put("每日1次", 1);
		freqNum.put("一次1粒", 1);
		freqNum.put("一次1袋", 1);
		freqNum.put("一次2粒", 2);
		freqNum.put("一次2袋", 2);
		freqNum.put("一次3粒", 3);
		freqNum.put("一次3袋", 3);
	}

	public static Map<String, Integer> getMedFreq() {
		return medFreq;
	}

	public static void setMedFreq(Map<String, Integer> medFreq) {
		DataMap.medFreq = medFreq;
	}

	public static Map<String, Integer> getFreqNum() {
		return freqNum;
	}

	public static void setFreqNum(Map<String, Integer> freqNum) {
		DataMap.freqNum = freqNum;
	}
}
