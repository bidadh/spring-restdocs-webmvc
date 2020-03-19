package com.ideabaker.samples.springrestdocswebmvc

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 * @author Arthur Kazemi<bidadh@gmail.com>
 * @since 18/3/20 23:30
 */
@RestController
class HomeController {
  @GetMapping("/")
  fun greeting(): Map<String, Any> {
    return mapOf("message" to "Hello, World")
  }
}