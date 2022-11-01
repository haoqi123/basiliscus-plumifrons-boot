package github.haoqi123.boot.controller

import github.haoqi123.boot.base.controller.BaseController
import github.haoqi123.boot.dto.TableDto
import github.haoqi123.boot.entity.TableMultipartColumns
import github.haoqi123.boot.model.TableMultipartColumnsMapper
import github.haoqi123.boot.vo.TableVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import kotlin.reflect.full.memberProperties

@RestController
class TableController(
    @Autowired
    mapper: TableMultipartColumnsMapper
) :
    BaseController<TableMultipartColumns, TableVo, TableDto, TableMultipartColumnsMapper>(mapper) {

    fun test() {
//            QueryWrapper<TableMultipartColumns>()
//            mapper.selectByPrimaryKey(1)
        val tableVo = TableVo(name4 = "123", name5 = null)
        tableVo.name21 = "123"
        tableVo.name22 = "123"

        tableVo.javaClass.kotlin.memberProperties
            .forEach { println(it.annotations) }
//            .associateBy { it.name }
//            .forEach { (t, u) -> println(u.annotations) }

//        selectList(tableVo, TableDto(""))
    }
}