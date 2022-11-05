package github.haoqi123.boot

import github.haoqi123.boot.annos.SelectionKeys
import github.haoqi123.boot.annos.SelectionKeysEnum
import github.haoqi123.boot.base.dto.FieldAndAnno
import org.springframework.beans.BeanWrapper
import org.springframework.beans.BeanWrapperImpl
import java.beans.PropertyDescriptor
import java.util.*

object BeanPropertyUtils {

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
        val propertyDescriptors: Array<PropertyDescriptor> = bean.propertyDescriptors
        propertyDescriptors
            .filter { map.containsKey(it.name) }
            .forEach {
                it.readMethod.annotations
                    .filter { it1 ->
                        it1.annotationClass == SelectionKeys::class
                    }
                    .forEach { _ ->
                        val annotation = bean.wrappedClass.getDeclaredMethod(it.readMethod.name)
                            .getAnnotation(SelectionKeys::class.java)
                        map[it.name]!!.selectionKeysEnum = annotation.value
                    }
            }

        /*any.javaClass.kotlin.memberProperties.associateBy { it.name }*/
        /*map.forEach {
            val kProperty1 = kProperty1Map[it.key]!!
            if (kProperty1 is KMutableProperty1<*, *>) {
                val annotations: SelectionKeys? = kProperty1.findAnnotation<SelectionKeys>()
                if (annotations != null) it.value.selectionKeysEnum = annotations.value
            }
        }*/
    }
}