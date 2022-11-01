package github.haoqi123.boot.vo

import github.haoqi123.boot.TableMultipartColumnsKt
import github.haoqi123.boot.annos.SelectionKeys
import github.haoqi123.boot.annos.SelectionKeysEnum

class TableVo : TableMultipartColumnsKt() {

    @SelectionKeys(SelectionKeysEnum.EQ)
    override var name1: String?
        get() = super.name1
        set(value) {
            super.name1 = value
        }

    @SelectionKeys(SelectionKeysEnum.LIKE)
    override var name2: String?
        get() = super.name2
        set(value) {
            super.name2 = value
        }
}