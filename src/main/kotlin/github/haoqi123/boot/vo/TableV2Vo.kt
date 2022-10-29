package github.haoqi123.boot.vo

import github.haoqi123.boot.annos.SelectionKeys
import github.haoqi123.boot.annos.SelectionKeysEnum

open class TableV2Vo public constructor(
    @SelectionKeys(SelectionKeysEnum.EQ)
    var name21: String?,
    @SelectionKeys(SelectionKeysEnum.LIKE)
    var name22: String?
) {

}