package github.haoqi123.boot.controller

import github.haoqi123.boot.base.controller.BaseController
import github.haoqi123.boot.dto.TableDto
import github.haoqi123.boot.dto.TableDtoV1
import github.haoqi123.boot.entity.TableMultipartColumns
import github.haoqi123.boot.model.TableMultipartColumnsMapper
import org.springframework.web.bind.annotation.RestController

@RestController
class TableController :
    BaseController<TableMultipartColumns, TableMultipartColumnsMapper>() {

    fun test() {
//            QueryWrapper<TableMultipartColumns>()
//            mapper.selectByPrimaryKey(1)
        val tableVo = TableDtoV1()
//        tableVo.name1 = "1"
        tableVo.name2 = "3"
        selectList(tableVo, TableDto()).forEach { println(it) }

    }
}