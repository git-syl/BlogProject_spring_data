package cn.syl.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable //内嵌实体
public class BaseEntity implements Serializable {

//    @Id
//    @TableGenerator(name="ID_GENERATOR",  //生成器名称
//            table="ID_GENERATOR", //生成器使用的表
//            pkColumnName="PK_NAME", //表中对应的字段名
//            pkColumnValue="ORDER_ID", //上述字段的值
//            valueColumnName="PK_VALUE", //值
//            //根据上述三个属性，就可以定位到表中的PK_VALUE的值，如：1，10，100
//            allocationSize=1)//表示主键一次增加10
//    @GeneratedValue(strategy=GenerationType.TABLE,
//            generator="ID_GENERATOR")//这里的生成器和上面的生成器名称对应
//    private Long baseId;

    private int sort = 0; //decimal	10	0	0	0	0	0	0		0	排序（升序）				0	0
    private String create_by;  //varchar	64	0	0	0	0	0	0		0	创建者	utf8	utf8_bin		0	0
    private Date create_date ;         //datetime	0	0	0	0	0	0	0		0	创建时间				0	0
    private String update_by;    //varchar	64	0	0	0	0	0	0		0	更新者	utf8	utf8_bin		0	0
    private Date update_date = new Date();      //datetime	0	0	0	0	0	0	0		0	更新时间				0	0
    private String remarks;      //varchar	255	0	-1	0	0	0	0		0	备注信息	utf8	utf8_bin		0	0
    private Boolean del_flag =false;    //char	1	0	0	0	0	0	0	'0'	0	删除标记	utf8	utf8_bin		0	0

    public BaseEntity() {
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Boolean getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Boolean del_flag) {
        this.del_flag = del_flag;
    }
}
