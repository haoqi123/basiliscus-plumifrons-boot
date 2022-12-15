package github.haoqi123.boot

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.fasterxml.jackson.databind.ObjectMapper
import github.haoqi123.boot.controller.TableController
import github.haoqi123.boot.vo.TableVo
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan

@SpringBootTest
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
class BasiliscusPlumifronsBootApplicationTests {

    @Autowired
    lateinit var tableController: TableController

    val objectMapper:ObjectMapper= ObjectMapper()

    @Test
    fun selectListVDTest() {
        assert(tableController.selectListVDTest(TableVo().apply { this.name1 = "1" })
            .apply { println(objectMapper.writeValueAsString(this)) }
            .isNotEmpty())
    }

    @Test
    fun selectListVTest() {
        assert(tableController.selectListVTest(TableVo().apply { this.name2 = "4" })
            .apply { println(objectMapper.writeValueAsString(this)) }
            .isNotEmpty())
    }

    @Test
    fun selectPageTest() {
        assert(
            tableController.selectPageTest(TableVo().apply { this.name2 = "5" }, Page.of(0, 1))
                .apply { println(objectMapper.writeValueAsString(this)) }
                .records.isNotEmpty()
        )
    }

}
