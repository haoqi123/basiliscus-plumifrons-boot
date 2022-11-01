package github.haoqi123.boot.controller

import github.haoqi123.boot.base.controller.BaseController
import github.haoqi123.boot.dto.TableDto
import github.haoqi123.boot.entity.TableMultipartColumns
import github.haoqi123.boot.model.TableMultipartColumnsMapper
import github.haoqi123.boot.vo.TableVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
class TableController(
    @Autowired
    mapper: TableMultipartColumnsMapper
) :
    BaseController<TableMultipartColumns, TableVo, TableDto, TableMultipartColumnsMapper>(mapper) {

    fun test() {
//            QueryWrapper<TableMultipartColumns>()
//            mapper.selectByPrimaryKey(1)
        val tableVo = TableVo()
        tableVo.name4 = "4"
        tableVo.name5 = "5"
        tableVo.name21 = "21"
        tableVo.name22 = "22"
        selectList(tableVo, TableDto())
    }
}