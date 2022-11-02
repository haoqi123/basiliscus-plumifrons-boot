package github.haoqi123.boot.model;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import github.haoqi123.boot.entity.TableMultipartColumns;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TableMultipartColumnsMapper extends BaseMapper<TableMultipartColumns> {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(TableMultipartColumns record);

    TableMultipartColumns selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TableMultipartColumns record);

    int updateByPrimaryKey(TableMultipartColumns record);
}