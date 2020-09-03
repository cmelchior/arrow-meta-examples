package io.arrowkt.example

import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.Plugin
import arrow.meta.invoke
import arrow.meta.quotes.Transform
import arrow.meta.quotes.namedFunction

val Meta.helloWorld: CliPlugin
  get() =
    "Hello World" {
      meta(
        namedFunction(this, { name == "helloFromArrowMeta" }) { c ->
          Transform.replace(
            replacing = c,
            newDeclaration =
            """|fun helloFromArrowMeta(): String =
               |  "Hello from ΛRROW Meta!"
               |""".function.syntheticScope
          )
        }
      )
    }
