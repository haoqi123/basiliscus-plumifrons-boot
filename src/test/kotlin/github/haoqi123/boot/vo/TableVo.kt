package github.haoqi123.boot.vo

import github.haoqi123.boot.entity.TableMultipartColumnsKt
import github.haoqi123.boot.annos.SelectionKeys
import github.haoqi123.boot.annos.SelectionKeysEnum

open class TableVo : TableMultipartColumnsKt() {

    //@SelectionKeys(SelectionKeysEnum.EQ)
    override var name1: String?
        @SelectionKeys(SelectionKeysEnum.LEFT_LIKE)
        get() = super.name1
        set(value) {
            super.name1 = value
        }

    @SelectionKeys(SelectionKeysEnum.RIGHT_LIKE)
    override var name2: String? = null


    override fun toString(): String {
        return "TableVo(name1=$name1, name2=$name2) ${super.toString()}"
    }


}