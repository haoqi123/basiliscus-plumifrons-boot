package github.haoqi123.boot.annos

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class SelectionKeys(val value: SelectionKeysEnum)


enum class SelectionKeysEnum {
    EQ, IN, LIKE, RLIKE
}