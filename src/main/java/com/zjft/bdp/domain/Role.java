package com.zjft.bdp.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色
 */
public class Role 
{
   
   /**
    * 角色编号
    */
   private Integer no;
   
   /**
    * 角色名称
    */
   private String name;
   
   /**
    * 角色类型(页面控制角度)
    */
   private Integer catalog;
   
   /**
    * 所属机构类型
    */
   private Integer orgGrade;
   /**
    * 角色描述
    */
   private String note;
   
   /**
    * 修改前的角色名
    */
   private String beforeRoelName;
   
   
   private List<Menu> menus = new ArrayList<Menu>();
   
   /**
    * Access method for the no property.
    * 
    * @return   the current value of the no property
    */
   public Integer getNo() 
   {
      return no;
   }
   
   /**
    * Sets the value of the no property.
    * 
    * @param aNo the new value of the no property
    */
   public void setNo(Integer aNo) 
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
    * Access method for the catalog property.
    * 
    * @return   the current value of the catalog property
    */
   public Integer getCatalog() 
   {
      return catalog;
   }
   
   /**
    * Sets the value of the catalog property.
    * 
    * @param aCatalog the new value of the catalog property
    */
   public void setCatalog(Integer aCatalog) 
   {
      catalog = aCatalog;
   }
   
   /**
    * Access method for the note property.
    * 
    * @return   the current value of the note property
    */
   public String getNote() 
   {
      return note;
   }
   
   /**
    * Sets the value of the note property.
    * 
    * @param aNote the new value of the note property
    */
   public void setNote(String aNote) 
   {
      note = aNote;
   }
   
   /**
    * Access method for the menus property.
    * 
    * @return   the current value of the menus property
    */
   public List<Menu> getMenus() 
   {
      return menus;
   }
   
   /**
    * Sets the value of the menus property.
    * 
    * @param aMenus the new value of the menus property
    */
   public void setMenus(List<Menu> aMenus) 
   {
      menus = aMenus;
   }
   
	public Integer getorgGrade() {
		return orgGrade;
	}
	
	public void setOrgGrade(Integer orgGrade) {
		this.orgGrade = orgGrade;
	}
	
	public String getBeforeRoelName() {
		return beforeRoelName;
	}
	
	public void setBeforeRoelName(String beforeRoelName) {
		this.beforeRoelName = beforeRoelName;
	}
	
}
