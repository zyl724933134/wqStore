package com.wqstore.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AdminResource implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -3504375283052564823L;

	private Long id;

    private String code;

    private String name;

    private String url;

    private String creator;

    private Date createTime;

    private String modifier;

    private Date modifiedTime;

    private String hasAnyRoles;

    private Integer weight;

    private String icons;

    private Boolean isMenu;

    private String parentCode;
    
    private List<AdminResource> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getHasAnyRoles() {
        return hasAnyRoles;
    }

    public void setHasAnyRoles(String hasAnyRoles) {
        this.hasAnyRoles = hasAnyRoles == null ? null : hasAnyRoles.trim();
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getIcons() {
        return icons;
    }

    public void setIcons(String icons) {
        this.icons = icons == null ? null : icons.trim();
    }

    public Boolean getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Boolean isMenu) {
        this.isMenu = isMenu;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

	public List<AdminResource> getChildren() {
		return children;
	}

	public void setChildren(List<AdminResource> children) {
		this.children = children;
	}
    
}