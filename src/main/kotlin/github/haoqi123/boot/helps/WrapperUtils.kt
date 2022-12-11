package github.haoqi123.boot.helps

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import github.haoqi123.boot.BeanPropertyUtils
import github.haoqi123.boot.annos.SelectionKeysEnum
import github.haoqi123.boot.base.dto.FieldAndAnno
import org.springframework.beans.BeanWrapper
import org.springframework.beans.BeanWrapperImpl

object WrapperUtils {

    fun <E, V : Any, D : Any> generateWrapper(v: V, d: D): QueryWrapper<E> {
        val wrapper: QueryWrapper<E> = generateWrapper(v)
        wrapper.select(BeanPropertyUtils.getPropertyNames(BeanWrapperImpl(d)))
        return wrapper
    }

    fun <E, V : Any> generateWrapper(v: V): QueryWrapper<E> {
        val bean: BeanWrapper = BeanWrapperImpl(v)
        val map: Map<String, FieldAndAnno> =
            BeanPropertyUtils.getNotNonPropertyNames(bean).apply {
                BeanPropertyUtils.getPropertyValue(bean, this)
            }
        return wrapper(map)
    }

    private fun <E> wrapper(map: Map<String, FieldAndAnno>): QueryWrapper<E> {
        val wrapper: QueryWrapper<E> = QueryWrapper<E>()
        map.forEach {
            val name = com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToUnderline(it.key)
            when (it.value.selectionKeysEnum) {
                SelectionKeysEnum.EQ -> {
                    wrapper.eq(name, it.value.fieldValue)
                }

                SelectionKeysEnum.LIKE -> {
                    wrapper.like(name, it.value.fieldValue)
                }

                SelectionKeysEnum.RLIKE -> {
                    wrapper.like(name, "%" + it.value.fieldValue + "%")
                }

                SelectionKeysEnum.IN -> {
                    wrapper.`in`(name, it.value.fieldValue)
                }
            }
        }
        return wrapper
    }
}