package github.haoqi123.boot.base.controller

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import github.haoqi123.boot.BeanPropertyUtils
import github.haoqi123.boot.annos.SelectionKeysEnum

/**
 * E entity
 * V vo
 * D dto
 * M mapper
 */
open class BaseController<E, V : Any, D, M : BaseMapper<E>>(protected val mapper: M) {


    protected fun selectList(v: V, d: D): D {
        val wrapper = QueryWrapper<E>()
        BeanPropertyUtils.getNotNonPropertyNames(v).apply {
            BeanPropertyUtils.getPropertyValue(v, this)
        }.forEach {
            when (it.value.selectionKeysEnum) {
                SelectionKeysEnum.EQ -> {
                    wrapper.eq(it.key, it.value.fieldValue)
                }

                SelectionKeysEnum.LIKE -> {
                    wrapper.like(it.key, "%" + it.value.fieldValue + "%")
                }

                SelectionKeysEnum.IN -> {
                    wrapper.`in`(it.key, it.value.fieldValue)
                }
            }
        }

        mapper.selectMaps(wrapper).forEach { println(it) }
        return d
    }
}