package github.haoqi123.boot.controller

import github.haoqi123.boot.base.controller.BaseController
import github.haoqi123.boot.dto.TableDto
import github.haoqi123.boot.entity.TableMultipartColumns
import github.haoqi123.boot.model.TableMultipartColumnsMapper
import github.haoqi123.boot.vo.TableVo
import org.springframework.stereotype.Component

@Component
class TableController :
    BaseController<TableMultipartColumns, TableMultipartColumnsMapper>() {

    fun test() {
//            QueryWrapper<TableMultipartColumns>()
//            mapper.selectByPrimaryKey(1)
        val tableVo = TableVo()
//        tableVo.name1 = "1"
        tableVo.name2 = "3"
        selectList(tableVo, TableDto()).forEach { println("${it.name01}") }

    }
}