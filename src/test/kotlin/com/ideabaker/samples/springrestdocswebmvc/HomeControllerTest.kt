package com.ideabaker.samples.springrestdocswebmvc

import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * @author Arthur Kazemi<bidadh></bidadh>@gmail.com>
 * @since 18/3/20 23:35
 */
@WebMvcTest(HomeController::class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
internal class HomeControllerTest {
  @Autowired
  lateinit var mockMvc: MockMvc

  @Test
  internal fun shouldReturnDefaultMessage() {
    mockMvc.perform(get("/"))
        .andDo(print())
        .andExpect(status().isOk)
        .andExpect(content().string(containsString("Hello, World")))
        .andDo(document("home", responseFields(
            fieldWithPath("message").description("The welcome message for the user.")
        )))
  }

  @Test
  internal fun shouldReturn401() {
    mockMvc.perform(get("/n"))
        .andDo(print())
        .andExpect(status().isNotFound)
        .andDo(document("nf"))
  }
}