package github.haoqi123.boot.helps

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import github.haoqi123.boot.BeanPropertyUtils
import github.haoqi123.boot.annos.SelectionKeysEnum
import org.springframework.beans.BeanWrapper
import org.springframework.beans.BeanWrapperImpl

object WrapperUtils {

    fun <E, V : Any, D : Any> generateWrapper(v: V, d: D): QueryWrapper<E> {
        val wrapper: QueryWrapper<E> = QueryWrapper<E>()
        val bean: BeanWrapper = BeanWrapperImpl(v)
        BeanPropertyUtils.getNotNonPropertyNames(bean).apply {
            BeanPropertyUtils.getPropertyValue(bean, this)
        }.forEach {
            when (it.value.selectionKeysEnum) {
                SelectionKeysEnum.EQ -> {
                    wrapper.eq(it.key, it.value.fieldValue)
                }

                SelectionKeysEnum.LIKE -> {
                    wrapper.like(it.key, it.value.fieldValue)
                }

                SelectionKeysEnum.RLIKE -> {
                    wrapper.like(it.key, "%" + it.value.fieldValue + "%")
                }

                SelectionKeysEnum.IN -> {
                    wrapper.`in`(it.key, it.value.fieldValue)
                }
            }
        }
        wrapper.select(BeanPropertyUtils.getPropertyNames(BeanWrapperImpl(d)))
        return wrapper
    }

    fun <E, V : Any> generateWrapper(v: V): QueryWrapper<E> {
        val wrapper: QueryWrapper<E> = QueryWrapper<E>()
        val bean: BeanWrapper = BeanWrapperImpl(v)
        BeanPropertyUtils.getNotNonPropertyNames(bean).apply {
            BeanPropertyUtils.getPropertyValue(bean, this)
        }.forEach {
            when (it.value.selectionKeysEnum) {
                SelectionKeysEnum.EQ -> {
                    wrapper.eq(it.key, it.value.fieldValue)
                }

                SelectionKeysEnum.LIKE -> {
                    wrapper.like(it.key, it.value.fieldValue)
                }

                SelectionKeysEnum.RLIKE -> {
                    wrapper.like(it.key, "%" + it.value.fieldValue + "%")
                }

                SelectionKeysEnum.IN -> {
                    wrapper.`in`(it.key, it.value.fieldValue)
                }
            }
        }
        return wrapper
    }
}