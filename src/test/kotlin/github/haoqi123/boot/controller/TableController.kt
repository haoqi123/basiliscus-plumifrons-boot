package github.haoqi123.boot.controller

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import github.haoqi123.boot.base.controller.BaseController
import github.haoqi123.boot.dto.TableDto
import github.haoqi123.boot.entity.TableMultipartColumns
import github.haoqi123.boot.model.TableMultipartColumnsMapper
import github.haoqi123.boot.vo.TableVo
import org.springframework.stereotype.Component

@Component
class TableController :
    BaseController<TableMultipartColumns, TableMultipartColumnsMapper>() {

    fun selectListVDTest(v: TableVo): List<TableDto> {
        return selectList(v, TableDto::class.java)
    }

    fun selectListVTest(v: TableVo): List<TableMultipartColumns> {
        return selectList(v)
    }

    fun selectPageTest(v: TableVo, page: Page<TableMultipartColumns>): Page<TableMultipartColumns> {
        return selectPage(v, page)
    }
}