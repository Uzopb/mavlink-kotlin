package com.divpundir.mavlink.generator

import com.divpundir.mavlink.generator.plugin.MavlinkDefinitionParser
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class MavlinkDefinitionParserTest {

    @Test
    fun parse() {
        assertDoesNotThrow {
            MavlinkDefinitionParser.parse(File("src/test/resources/common.xml"))
        }

        assertDoesNotThrow {
            MavlinkDefinitionParser.parse(File("src/test/resources/ardupilotmega.xml"))
        }
    }
}
