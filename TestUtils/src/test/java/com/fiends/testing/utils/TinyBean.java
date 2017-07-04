package com.fiends.testing.utils;

/**
 * A small class used for testing object parsing.
 * @author fwhaslam
 * @since 1.0.0
 */
public class TinyBean {

	String name;
	Integer count;
	Boolean useful;
	String[] tags;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Boolean isUseful() {
		return useful;
	}

	public void setUseful(Boolean useful) {
		this.useful = useful;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}
}
