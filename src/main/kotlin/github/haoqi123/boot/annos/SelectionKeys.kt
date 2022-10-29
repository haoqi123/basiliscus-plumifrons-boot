package github.haoqi123.boot.annos

annotation class SelectionKeys(val selectionKeys: SelectionKeysEnum)


enum class SelectionKeysEnum {
    EQ, IN, LIKE, RLIKE
}