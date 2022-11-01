package github.haoqi123.boot.vo

import github.haoqi123.boot.annos.SelectionKeys
import github.haoqi123.boot.annos.SelectionKeysEnum

class TableVo : TableV2Vo() {

    @SelectionKeys(SelectionKeysEnum.EQ)
    var name4: String = ""

    @SelectionKeys(SelectionKeysEnum.LIKE)
    var name5: String? = null
}