import cn.syl.domain.BaseEntity;
import cn.syl.domain.Blog;
import cn.syl.domain.BlogCategory;
import cn.syl.repository.BlogCategoryRepository;
import cn.syl.repository.BlogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class TestJPA {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogCategoryRepository blogCategoryRepository;

    //添加一个博客  以及它的分类
    @Test
    public void add() {
        Blog blog = new Blog();
        blog.setContent("博客内容");
        blog.setTitle("博客标题");
        blog.setBaseEntity(new BaseEntity());

        BlogCategory blogCategory = new BlogCategory();
        blogCategory.setCategoryName("java分类");
        blogCategory.setBaseEntity(new BaseEntity());

        blog.setBlogCategory(blogCategory); //设置关联

        blogRepository.save(blog); //级联保存

    }

    @Test
    public void addBlogCategory() {
        BlogCategory blogCategory = new BlogCategory();
        blogCategory.setCategoryName("一级分类");
        blogCategory.setBaseEntity(new BaseEntity());

        BlogCategory blogCategory2 = new BlogCategory();
        blogCategory2.setCategoryName("二级分类");
        blogCategory2.setBaseEntity(new BaseEntity());

        BlogCategory blogCategory3= new BlogCategory();
        blogCategory3.setCategoryName("三级分类");
        blogCategory3.setBaseEntity(new BaseEntity());


        blogCategory2.setParentCategory(blogCategory);
        blogCategory3.setParentCategory(blogCategory2);

        blogCategoryRepository.save(blogCategory);
        blogCategoryRepository.save(blogCategory2);
        blogCategoryRepository.save(blogCategory3);
    }


}
