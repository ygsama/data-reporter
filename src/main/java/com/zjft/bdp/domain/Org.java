package com.zjft.bdp.domain;


/**
 * 机构
 */
public class Org 
{

/**
    * 机构编号
    */
   private String no;
   /**
    * 机构名称
    */
   private String name;
   
   /**
    * 机构等级
    */
   private OrgGrade orgGrade;
   
   /**
    * 地址
    */
   private String address;
   
   /**
    * 上级机构名
    */
   private String superOrgName;
   
   /**
    * 上级机构编号
    */
   private String superOrgNo;
   
   /**
    * x坐标
    */
   private String x;
   
   /**
    * y坐标
    */
   private String y;
   
   /**
    * 备注
    */
   private String note;

   /**
    * 省
    */
   private String region;
   /**
    *市
    */
   private String city;

public String getRegion() {
	return region;
}

public void setRegion(String region) {
	this.region = region;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getSuperOrgName() {
	return superOrgName;
}

public void setSuperOrgName(String superOrgName) {
	this.superOrgName = superOrgName;
}

public String getSuperOrgNo() {
	return superOrgNo;
}

public void setSuperOrgNo(String superOrgNo) {
	this.superOrgNo = superOrgNo;
}

public String getX() {
	return x;
}

public void setX(String x) {
	this.x = x;
}

public String getY() {
	return y;
}

public void setY(String y) {
	this.y = y;
}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}

/**
    * Access method for the no property.
    * 
    * @return   the current value of the no property
    */
   public String getNo() 
   {
      return no;    
   }
   
   /**
    * Sets the value of the no property.
    * 
    * @param aNo the new value of the no property
    */
   public void setNo(String aNo) 
   {
      no = aNo;    
   }
   
   /**
    * Access method for the name property.
    * 
    * @return   the current value of the name property
    */
   public String getName() 
   {
      return name;    
   }
   
   /**
    * Sets the value of the name property.
    * 
    * @param aName the new value of the name property
    */
   public void setName(String aName) 
   {
      name = aName;    
   }
   
   /**
    * Access method for the orgGrade property.
    * 
    * @return   the current value of the orgGrade property
    */
   public OrgGrade getOrgGrade() 
   {
      return orgGrade;    
   }
   
   /**
    * Sets the value of the orgGrade property.
    * 
    * @param aOrgGrade the new value of the orgGrade property
    */
   public void setOrgGrade(OrgGrade aOrgGrade) 
   {
      orgGrade = aOrgGrade;    
   }
   
   public String getAddress() 
   {
      return address;    
   }

   public void setAddress(String aAddress) 
   {
	   address = aAddress;    
   }

   
}
