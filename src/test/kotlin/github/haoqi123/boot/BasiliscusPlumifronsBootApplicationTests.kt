package github.haoqi123.boot

import github.haoqi123.boot.controller.TableController
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.context.TypeExcludeFilter
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType

@SpringBootTest
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
class BasiliscusPlumifronsBootApplicationTests {

    @Autowired
    lateinit var tableController: TableController

    @Test
    fun contextLoads() {
        tableController.test()
    }

}
