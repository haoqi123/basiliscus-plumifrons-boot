package github.haoqi123.boot.base.controller

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import github.haoqi123.boot.helps.WrapperUtils
import org.springframework.beans.BeanUtils
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

    protected fun <V : Any, D : Any> selectList(v: V, d: Class<D>): List<D> {
        return mapper.selectList(WrapperUtils.generateWrapper(v, d.getConstructor().newInstance()))
            .map {
                d.getConstructor().newInstance().apply { BeanUtils.copyProperties(it as Any, this) }
            }
    }
}