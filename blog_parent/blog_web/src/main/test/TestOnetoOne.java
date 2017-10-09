import cn.syl.mapper.CategoryMapper2;
import cn.syl.pojo.Category2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class TestOnetoOne {
    @Autowired
    private CategoryMapper2 mapper2;

    @Test
    public void testOnetoOne() {
        List<Category2> list = mapper2.findAll();
        for (Category2 category2 : list) {
                if (category2!=null)
            if (category2.getParentCategory() != null) {
                System.out.print(category2.getName());
                System.out.print("---->父亲菜单" + category2.getParentCategory().getName());
                System.out.println();
            } else {
                System.out.println(category2.getName());

            }
        }

    }
}
