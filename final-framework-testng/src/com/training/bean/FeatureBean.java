package com.training.bean;

public class FeatureBean {
	private String Name;
	private String Slug;
	private String ParentF;
	private String Description;
	
	public FeatureBean() {
	}

	public FeatureBean(String Name, String Slug, String ParentF, String Description) {
		super();
		this.Name = Name;
		this.Slug = Slug;
		this.ParentF=ParentF;
		this.Description=Description;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getSlug() {
		return Slug;
	}

	public void setSlug(String Slug) {
		this.Slug = Slug;
	}

	
	public String getParentF() {
		return ParentF;
	}

	public void setParentF(String ParentF) {
		this.ParentF = ParentF;
	}
	
	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
	
	
	
	@Override
	public String toString() {
		return "LoginBean2 [Name=" + Name + ", Slug=" + Slug + ", ParentF=" + ParentF + ", Description=" + Description + "]";
	}

}
