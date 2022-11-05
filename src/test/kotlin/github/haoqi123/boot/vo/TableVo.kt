package github.haoqi123.boot.vo

import github.haoqi123.boot.entity.TableMultipartColumnsKt
import github.haoqi123.boot.annos.SelectionKeys
import github.haoqi123.boot.annos.SelectionKeysEnum

class TableVo : TableMultipartColumnsKt() {

    override var name1: String?
        @SelectionKeys(SelectionKeysEnum.EQ)
        get() = super.name1
        set(value) {
            super.name1 = value
        }

    override var name2: String?
        @SelectionKeys(SelectionKeysEnum.LIKE)
        get() = super.name2
        set(value) {
            super.name2 = value
        }

    override fun toString(): String {
        return "TableVo(name1=$name1, name2=$name2) ${super.toString()}"
    }


}