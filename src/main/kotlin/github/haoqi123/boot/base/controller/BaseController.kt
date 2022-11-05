package github.haoqi123.boot.base.controller

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import github.haoqi123.boot.helps.WrapperUtils
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired

/**
 * E entity
 * V vo
 * D dto
 * M mapper
 */
open class BaseController<E : Any, M : BaseMapper<E>>(
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

    protected fun <V : Any> selectList(v: V): List<E> {
        return mapper.selectList(WrapperUtils.generateWrapper(v))
    }

    protected fun <V : Any> selectPage(v: V, page: Page<E>): Page<E> {
        return mapper.selectPage(page, WrapperUtils.generateWrapper(v))
    }
}