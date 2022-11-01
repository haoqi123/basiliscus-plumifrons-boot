package github.haoqi123.boot

import github.haoqi123.boot.annos.SelectionKeys
import github.haoqi123.boot.annos.SelectionKeysEnum
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

    fun getNotNonPropertyNames(any: Any): HashMap<String, FieldAndAnno> {
        val bean = BeanWrapperImpl(any)
        val propertyDescriptors: Array<PropertyDescriptor> = bean.propertyDescriptors

        val hashSet = HashMap<String, FieldAndAnno>()
        propertyDescriptors
            .filter { !it.name.equals("class") }
            .forEach {
                val propertyValue = bean.getPropertyValue(it.name)
                if (it.propertyType == java.lang.String::class.java) {
                    if (Objects.nonNull(propertyValue) && "" != propertyValue) {
                        hashSet[it.name] = FieldAndAnno(propertyValue!!, SelectionKeysEnum.EQ)
                    }
                } else if (Objects.nonNull(propertyValue)) {
                    hashSet[it.name] = FieldAndAnno(propertyValue!!, SelectionKeysEnum.EQ)
                }
            }

        return hashSet
    }

    fun getPropertyValue(any: Any, map: HashMap<String, FieldAndAnno>) {

        val kProperty1Map = any.javaClass.kotlin.memberProperties.associateBy { it.name }
        map.forEach {
            val kProperty1 = kProperty1Map[it.key]!!
            val annotations: SelectionKeys? = kProperty1.findAnnotation<SelectionKeys>()
            if (annotations != null) it.value.selectionKeysEnum = annotations.selectionKeys
        }
    }
}