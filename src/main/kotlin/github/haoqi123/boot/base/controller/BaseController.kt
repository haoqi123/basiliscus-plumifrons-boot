package github.haoqi123.boot.base.controller

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import github.haoqi123.boot.BeanPropertyUtils

/**
 * E entity
 * V vo
 * D dto
 * M mapper
 */
open class BaseController<E, V : Any, D, M : BaseMapper<E>>(protected val mapper: M) {


    protected fun selectList(v: V, d: D): D {
        var wrapper = QueryWrapper<E>()
//        BeanUtils.copyProperties()
//        BeanPropertyUtils.getNonPropertyNames(v).forEach { println(it) }
        BeanPropertyUtils.getNotNonPropertyNames(v).forEach { println(it) }

//        mapper.selectMaps(wrapper)
        return d
    }
}