package github.haoqi123.boot.entity

import github.haoqi123.boot.annos.SelectionKeys
import github.haoqi123.boot.annos.SelectionKeysEnum

open class TableMultipartColumnsKt {
    val id: Int? = null

    open var name1: String? = null

    @SelectionKeys(SelectionKeysEnum.LIKE)
    open var name2: String? = null

    open var name3: String? = null
    override fun toString(): String {
        return "TableMultipartColumnsKt(id=$id, name1=$name1, name2=$name2, name3=$name3)"
    }


}