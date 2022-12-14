package github.haoqi123.boot.vo

import github.haoqi123.boot.annos.SelectionKeys
import github.haoqi123.boot.annos.SelectionKeysEnum

open class TableV2Vo {
    @SelectionKeys(SelectionKeysEnum.EQ)
    var name21: String? = null

    @SelectionKeys(SelectionKeysEnum.LIKE)
    var name22: String? = null
    override fun toString(): String {
        return "TableV2Vo(name21=$name21, name22=$name22)"
    }


}