package cn.syl.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
//一个分类下有多个博客
public class BlogCategory {

    @Id
    @GeneratedValue
    private Long categoryId;

    private String categoryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid")
    private BlogCategory parentCategory;

    @OneToMany(targetEntity = BlogCategory.class, cascade = { CascadeType.ALL }, mappedBy = "parentCategory")
    @Fetch(FetchMode.SUBSELECT)
    private Set<BlogCategory> childCategories = new HashSet<BlogCategory>(0);

    //外键由 Blog blogCategory 维护
    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            //org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: com.syl.domain.Order.items, could not initialize proxy - no Session
            fetch = FetchType.EAGER,mappedBy = "blogCategory")
    private Set<Blog> blogs = new HashSet<Blog>(0);


    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "del_flag",column = @Column(nullable = false)),
//            @AttributeOverride(name = "sort",column = @Column(nullable = true))
//    })
  //  @Column(nullable = true)
    private BaseEntity baseEntity;


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BlogCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(BlogCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Set<BlogCategory> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(Set<BlogCategory> childCategories) {
        this.childCategories = childCategories;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }

    public BaseEntity getBaseEntity() {
        return baseEntity;
    }

    public void setBaseEntity(BaseEntity baseEntity) {
        this.baseEntity = baseEntity;
    }
}
