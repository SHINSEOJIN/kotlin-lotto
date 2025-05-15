package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.charset.StandardCharsets

internal class ApplicationTest {
    private val originalIn = System.`in`
    private val originalOut = System.out
    private lateinit var outputStream: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream, true, StandardCharsets.UTF_8.name()))
    }

    @AfterEach
    fun tearDown() {
        System.setIn(originalIn)
        System.setOut(originalOut)
    }

    @Test
    fun `정상적인 로또 시뮬레이션 실행 테스트`() {
        val input = "8000\n1,2,3,4,5,6\n7\n"
        System.setIn(ByteArrayInputStream(input.toByteArray(StandardCharsets.UTF_8)))

        main()

        val output = outputStream.toString(StandardCharsets.UTF_8.name())
        assertThat(output).contains("구입금액을 입력해 주세요.")
        assertThat(output).contains("8개를 구매했습니다.")
        assertThat(output).contains("[")
        assertThat(output).contains("당첨 번호를 입력해 주세요.")
        assertThat(output).contains("보너스 번호를 입력해 주세요.")
        assertThat(output).contains("당첨 통계")
        assertThat(output).contains("3개 일치 (5,000원)")
        assertThat(output).contains("4개 일치 (50,000원)")
        assertThat(output).contains("5개 일치 (1,500,000원)")
        assertThat(output).contains("5개 일치, 보너스 볼 일치 (30,000,000원)")
        assertThat(output).contains("6개 일치 (2,000,000,000원)")
        assertThat(output).contains("총 수익률은")
        assertThat(output).contains("%")
    }


    @ParameterizedTest
    @CsvSource("8500", "1000j")
    fun `구입금액이 1000원 단위가 아니면 예외 발생 테스트`(input: String) {
        System.setIn(ByteArrayInputStream(input.toByteArray(StandardCharsets.UTF_8)))

        main()

        val output = outputStream.toString(StandardCharsets.UTF_8.name())
        assertThat(output).contains("[ERROR]")
    }
}