package github.haoqi123.boot.annos

//@Retention(AnnotationRetention.RUNTIME)
annotation class SelectionKeys(val selectionKeys: SelectionKeysEnum)


enum class SelectionKeysEnum {
    EQ, IN, LIKE, RLIKE
}