package github.haoqi123.boot

import github.haoqi123.boot.annos.SelectionKeys
import github.haoqi123.boot.annos.SelectionKeysEnum
import github.haoqi123.boot.base.dto.FieldAndAnno
import org.springframework.beans.BeanWrapper
import org.springframework.beans.BeanWrapperImpl
import java.lang.reflect.Field
import java.util.*
import kotlin.collections.HashMap
import kotlin.reflect.KProperty1
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible
import kotlin.reflect.jvm.javaField

object BeanPropertyUtils {


    /**
     * 字段中没有找到匹配的注解
     */
    private val fieldNotMatchAnnotation: MutableMap<String, KProperty1<out Any, *>> = HashMap()

    @JvmStatic
    fun main(args: Array<String>) {

    }

    fun getPropertyNames(bean: BeanWrapper): String {
        return bean.propertyDescriptors
            .filter { !it.name.equals("class") }
            .joinToString(",") { it.name }
    }

    fun getNonPropertyNames(any: Any): List<String> {
        val bean = BeanWrapperImpl(any)
        return bean.propertyDescriptors.filter { Objects.isNull(bean.getPropertyValue(it.name)) }.map { it.name }
    }

    fun getNotNonPropertyNames(bean: BeanWrapper): Map<String, FieldAndAnno> {
        return bean.propertyDescriptors
            .filter { !it.name.equals("class") }
            .filter {
                val propertyValue = bean.getPropertyValue(it.name)
                if (it.propertyType == java.lang.String::class.java) {
                    if (Objects.nonNull(propertyValue) && "" != propertyValue) {
                        return@filter true
                    }
                } else if (Objects.nonNull(propertyValue)) {
                    return@filter true
                }
                return@filter false
            }.associateBy({ it.name }, { FieldAndAnno(bean.getPropertyValue(it.name)!!, SelectionKeysEnum.EQ) })
    }

    fun getPropertyValue(bean: BeanWrapper, map: Map<String, FieldAndAnno>) {
        // 获取字段上的注解值
        obtainFiledMetaAnnotationValue(bean, map)
        // 获取Getter 方法上的注解值
        obtainGetterMetaAnnotationValue(bean, map)

    }


    /**
     * 获取字段的元数据注解值
     */
    private fun obtainFiledMetaAnnotationValue(
        bean: BeanWrapper,
        map: Map<String, FieldAndAnno>
    ): Map<String, FieldAndAnno> {
        for (field in bean.wrappedClass.kotlin.declaredMemberProperties) {
            if (map.containsKey(field.name)) {
                field.annotations.forEach {
                    if (it is SelectionKeys) {
                        map[field.name]?.selectionKeysEnum = it.value;
                    }
                }
            }
        }
        return map;
    }

    /**
     * 获取 readMethod 上的 SelectKeys 注解
     */
    private fun obtainGetterMetaAnnotationValue(
        bean: BeanWrapper,
        map: Map<String, FieldAndAnno>
    ): Map<String, FieldAndAnno> {
        //if (fieldNotMatchAnnotation.isNotEmpty()){
            val propertyDescriptors = bean.propertyDescriptors
            propertyDescriptors.filter { map.containsKey(it.name) }
                //.filter { fieldNotMatchAnnotation.contains(it.name) }
                .forEach {
                    map[it.name]?.selectionKeysEnum= it.readMethod.getAnnotation(SelectionKeys::class.java).value
                }
        //}
        return map;
    }

}