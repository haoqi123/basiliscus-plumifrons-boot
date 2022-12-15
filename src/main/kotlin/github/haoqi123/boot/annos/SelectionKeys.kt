package github.haoqi123.boot.annos

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.PROPERTY_GETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class SelectionKeys(val value: SelectionKeysEnum)


enum class SelectionKeysEnum {
    EQ, IN, LIKE, LEFT_LIKE, RIGHT_LIKE
}