package github.haoqi123.boot

import org.springframework.beans.BeanWrapperImpl
import java.beans.PropertyDescriptor
import java.lang.reflect.Field
import java.util.*

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

        val fields: Array<Field> = any.javaClass.fields
        propertyDescriptors.forEach {
            if (Objects.nonNull(bean.getPropertyValue(it.name))) {
                hashSet.add(it.name)
            }
        }

        return hashSet.toArray(arrayOfNulls<String>(hashSet.size))
    }
}