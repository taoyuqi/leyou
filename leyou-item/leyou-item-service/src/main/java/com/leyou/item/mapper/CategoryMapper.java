package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: hasee
 * @Date: 2020/11/9
 * @Description: com.leyou.item
 * @version: 1.0
 */
@org.apache.ibatis.annotations.Mapper
public interface CategoryMapper extends Mapper<Category>, SelectByIdListMapper<Category,Long> {
    @Select("SELECT id,name FROM tb_category WHERE id IN (SELECT category_id FROM tb_category_brand WHERE brand_id=#{bid})")
    List<Category> queryByBrandId(Long bid);


}
