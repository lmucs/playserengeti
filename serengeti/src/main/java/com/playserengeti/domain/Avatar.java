package com.playserengeti.domain;

public class Avatar {

	private String mimeType;
	private byte[] bytes;
	
	public Avatar() {
	}
	
	public Avatar(String mimeType, byte[] bytes) {
		this.mimeType = mimeType;
		this.bytes = bytes;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	
}
