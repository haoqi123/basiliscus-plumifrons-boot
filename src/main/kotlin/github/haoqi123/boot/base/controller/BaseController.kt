package github.haoqi123.boot.base.controller

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import github.haoqi123.boot.helps.WrapperUtils
import org.springframework.beans.factory.annotation.Autowired

/**
 * E entity
 * V vo
 * D dto
 * M mapper
 */
open class BaseController<E, M : BaseMapper<E>>(
) {

    @Suppress("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected open lateinit var mapper: M

    protected fun <V : Any, D> selectList(v: V, d: D): MutableList<D> {
        val listOf = mutableListOf(d)
        mapper.selectMaps(WrapperUtils.generateWrapper(v))
        //TODO 将查询出来的值转换给 D
        return listOf
    }
}