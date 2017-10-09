package cn.syl.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Category2 {

    @JSONField(name="id")
    private Long categoryId;

    @JSONField(name="pId")
    private Long parentId;

   // private String parentCategoryName;
   @JSONField(name="name")
    private String name;

    private Byte isParent;

    private String createBy;

    private Date createTime;

    private String updateBy;

    @JSONField(serialize = false)
    private Date updateTime;

    private Byte status;

    private Integer sortOrder;

    private Category2 parentCategory;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Category2 getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category2 parentCategory) {
        this.parentCategory = parentCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getIsParent() {
        return isParent;
    }

    public void setIsParent(Byte isParent) {
        this.isParent = isParent;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
}
