package com.sayantan.ratingservice.pojo;




public class Rating {
	
	private String ratingId;
	private String uid;
	private String hotelid;
	private String ratingValue;
	private String remark;
	public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getHotelid() {
		return hotelid;
	}
	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}
	public String getRatingValue() {
		return ratingValue;
	}
	public void setRatingValue(String ratingValue) {
		this.ratingValue = ratingValue;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Rating(String ratingId, String uid, String hotelid, String ratingValue, String remark) {
		super();
		this.ratingId = ratingId;
		this.uid = uid;
		this.hotelid = hotelid;
		this.ratingValue = ratingValue;
		this.remark = remark;
	}
	public Rating() {
	
	}
	
	

}
