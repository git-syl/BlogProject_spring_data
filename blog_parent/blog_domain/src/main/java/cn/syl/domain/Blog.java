package cn.syl.domain;

import javax.persistence.*;

@Entity
@Table(name = "blog")
//负责维护外键
public class Blog {
    @Id
    @GeneratedValue
    private Long blogId;

    private String title;

    @Lob
    private String content;

    //optional =false外键字段是否可选, false必须存在
    @ManyToOne( cascade = {CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST},optional =false)
    @JoinColumn(name = "category_id")
    private BlogCategory blogCategory;

    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "del_flag",column = @Column(nullable = false)),
//            @AttributeOverride(name = "sort",column = @Column(nullable = true))
//    })
   // @Column(nullable = true)
    private BaseEntity baseEntity;


    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BlogCategory getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(BlogCategory blogCategory) {
        this.blogCategory = blogCategory;
    }

    public BaseEntity getBaseEntity() {
        return baseEntity;
    }

    public void setBaseEntity(BaseEntity baseEntity) {
        this.baseEntity = baseEntity;
    }
}
