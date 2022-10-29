package github.haoqi123.boot

import github.haoqi123.boot.controller.TableController
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BasiliscusPlumifronsBootApplicationTests {

    @Autowired
    lateinit var tableController: TableController

    @Test
    fun contextLoads() {
        tableController.test()
    }

}
