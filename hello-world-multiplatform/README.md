# Arrow Meta Multiplatform Example

This project demonstrates how you can setup Arrow Meta to work in a Kotlin Multiplatform project.

The current project targets have all been tested on a mac. Windows and Linux targets are untested.

## Running tests

### JS

1. Run `./gradlew jsNodeTest` or `./gradlewe jsBrowserTest` and observe it fails with:

```
> project ':create-plugin' is not configured for JS usage
```

It is unclear how to resolve this.

### macOS/iOS

1. Run `./gradlew macosTest`, and observe it fails with:

```
> Task :use-plugin-multiplatform:compileKotlinIos FAILED
e: java.lang.IllegalStateException: The provided plugin io.arrowkt.example.MetaPlugin is not compatible with this version of compiler
        at org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment$Companion.registerExtensionsFromPlugins$cli(KotlinCoreEnvironment.kt:602)
        at org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment$ProjectEnvironment.registerExtensionsFromPlugins(KotlinCoreEnvironment.kt:133)
        at org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment.<init>(KotlinCoreEnvironment.kt:173)
        at org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment.<init>(KotlinCoreEnvironment.kt:113)
        at org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment$Companion.createForProduction(KotlinCoreEnvironment.kt:420)
        at org.jetbrains.kotlin.cli.bc.K2Native.doExecute(K2Native.kt:55)
        at org.jetbrains.kotlin.cli.bc.K2Native.doExecute(K2Native.kt:34)
        at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:84)
        at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:42)
        at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:104)
        at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:82)
        at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:50)
        at org.jetbrains.kotlin.cli.common.CLITool$Companion.doMainNoExit(CLITool.kt:215)
        at org.jetbrains.kotlin.cli.common.CLITool$Companion.doMain(CLITool.kt:207)
        at org.jetbrains.kotlin.cli.bc.K2Native$Companion$main$1.invoke(K2Native.kt:225)
        at org.jetbrains.kotlin.cli.bc.K2Native$Companion$main$1.invoke(K2Native.kt:222)
        at org.jetbrains.kotlin.util.UtilKt.profileIf(Util.kt:27)
        at org.jetbrains.kotlin.util.UtilKt.profile(Util.kt:21)
        at org.jetbrains.kotlin.cli.bc.K2Native$Companion.main(K2Native.kt:224)
        at org.jetbrains.kotlin.cli.bc.K2NativeKt.main(K2Native.kt:304)
        at org.jetbrains.kotlin.cli.utilities.MainKt.main(main.kt:16)
Caused by: java.lang.AbstractMethodError: io.arrowkt.example.MetaPlugin.registerProjectComponents(Lcom/intellij/mock/MockProject;Lorg/jetbrains/kotlin/config/CompilerConfiguration;)V
        at org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment$Companion.registerExtensionsFromPlugins$cli(KotlinCoreEnvironment.kt:594)
        ... 20 more
```

2. Goto `:create-plugin/build.gradle` and enable the `relocate` statements
3. Rebuild and run again `./gradlew clean macosTest`. Observe that the tests now run but the compiler
  plugin did not work correctly so the tests fail:
  
```
// macosTest output
sample.SampleTestsNative.testHelloFromArrowMeta FAILED
    kotlin.NotImplementedError at /Users/cm/Realm/arrow-meta-examples/hello-world-multiplatform/use-plugin-multiplatform/src/macosTest/kotlin/sample/SampleTestsNative.kt:15
```

The same behavior can be observed when running `./gradlewe iosTest` (remember to start simulator first).

```
// iosTest output
[----------] 2 tests from sample.SampleTestsNative
[ RUN      ] sample.SampleTestsNative.testHelloFromPlatform
[       OK ] sample.SampleTestsNative.testHelloFromPlatform (0 ms)
[ RUN      ] sample.SampleTestsNative.testHelloFromArrowMeta
kotlin.NotImplementedError: An operation is not implemented.
```


### Android

1. Run `./gradlew connectedAndroidTests`. Remember to have an emulator active or an device attached.
2. Observe it runs correctly.

This only works if `build.gradle` is modified in an unintuitive way. I.e. Android will fail the 
build if Arrow Meta is added as a normal dependency due to the fact that it apparently contains an
annotation processor.


### JVM

1. Run `./gradlew jvmTests`.
2. Observe it runs correctly.


## Gotchas

* Running Android Instrumentation tests in IntelliJ will run them on Robolectric as the default.
  This will cause the following exception: `java.lang.RuntimeException: Method e in android.util.Log not mocked.` 
  You must manually create a Instrumentation Test configuration to run on an actual device or 
  use `./gradlew connectedAndroidTest` from the commandline.


