package github.haoqi123.boot

import github.haoqi123.boot.annos.SelectionKeys
import github.haoqi123.boot.base.dto.FieldAndAnno
import org.springframework.beans.BeanWrapperImpl
import java.beans.PropertyDescriptor
import java.util.*
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

object BeanPropertyUtils {

    fun getNonPropertyNames(any: Any): Array<String> {
        val bean = BeanWrapperImpl(any)
        val propertyDescriptors: Array<PropertyDescriptor> = bean.propertyDescriptors
        val hashSet = HashSet<String>()

        propertyDescriptors.forEach {
            if (Objects.isNull(bean.getPropertyValue(it.name))) {
                hashSet.add(it.name)
            }
        }

        return hashSet.toArray(arrayOfNulls<String>(hashSet.size))
    }

    fun getNotNonPropertyNames(any: Any): Array<String> {
        val bean = BeanWrapperImpl(any)
        val propertyDescriptors: Array<PropertyDescriptor> = bean.propertyDescriptors

        val hashSet = HashSet<String>()
        propertyDescriptors
            .filter { !it.name.equals("class") }
            .forEach {
                if (Objects.nonNull(bean.getPropertyValue(it.name))) {
                    hashSet.add(it.name)
                }
            }

        return hashSet.toArray(arrayOfNulls<String>(hashSet.size))
    }

    fun getPropertyValue(any: Any, array: Array<String>): Array<FieldAndAnno>? {
        val kProperty1Map = any.javaClass.kotlin.memberProperties.associateBy { it.name }
        array.forEach {
            val kProperty1 = kProperty1Map[it]!!
            val annotations: SelectionKeys? = kProperty1.findAnnotation<SelectionKeys>()
            println(annotations)
        }
        return null
    }
}