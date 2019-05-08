package org.itstep.mariupol.adce440datafilesgraph.model;

import java.util.ArrayList;

public class Channel {
	
	//private String mFilePathString;
	@SuppressWarnings("unused")
	private final int mChannelNumber;
	@SuppressWarnings("unused")
	private final int mChannelAmp;
	private ArrayList<Double> mChannelDataArrayList;
	
	public Channel (int channeNlumber, int channelAmp) {
		mChannelNumber = channeNlumber;
		mChannelAmp = channelAmp;
		mChannelDataArrayList = new ArrayList<>();
	}
	
	public int getChannelNumber() {
		return mChannelNumber;
	}

	public int getChannelAmp() {
		return mChannelAmp;
	}



	public void addDataItem (Double dataItemDouble) {
		mChannelDataArrayList.add(dataItemDouble);
	}

	public Double getDataItem (int dataItemPos) {
		return mChannelDataArrayList.get(dataItemPos);
	}
        
        public void setDataItem (int dataItemPos, int k) {
            Double value = mChannelDataArrayList.get(dataItemPos) * k;
            this.mChannelDataArrayList.set(dataItemPos, value);
	}

	public ArrayList<Double> getChannelDataArrayList() {
		return mChannelDataArrayList;
	}

	public int size() {
		return mChannelDataArrayList.size();
	}

    public void setmChannelDataArrayList(ArrayList<Double> mChannelDataArrayList) {
        this.mChannelDataArrayList = mChannelDataArrayList;
    }
}
