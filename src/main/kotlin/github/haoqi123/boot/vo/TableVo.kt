package github.haoqi123.boot.vo

import github.haoqi123.boot.annos.SelectionKeys
import github.haoqi123.boot.annos.SelectionKeysEnum

data class TableVo public constructor(
    @SelectionKeys(SelectionKeysEnum.EQ)
    val name4: String,
    @SelectionKeys(SelectionKeysEnum.LIKE)
    val name5: String?
) : TableV2Vo(null, null) {

}