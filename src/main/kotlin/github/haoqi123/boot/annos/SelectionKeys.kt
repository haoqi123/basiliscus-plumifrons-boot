package github.haoqi123.boot.annos

annotation class SelectionKeys(val value: SelectionKeysEnum)


enum class SelectionKeysEnum {
    EQ, IN, LIKE, RLIKE
}