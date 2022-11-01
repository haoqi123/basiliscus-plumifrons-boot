package github.haoqi123.boot.annos

//@Retention(AnnotationRetention.RUNTIME)
annotation class SelectionKeys(val value: SelectionKeysEnum)


enum class SelectionKeysEnum {
    EQ, IN, LIKE,RLIKE
}