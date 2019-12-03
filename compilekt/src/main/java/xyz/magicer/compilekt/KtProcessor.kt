package xyz.magicer.compilekt

import com.google.auto.common.BasicAnnotationProcessor
import com.google.common.collect.SetMultimap
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import xyz.magicer.annotation.TestKt
import java.io.IOException
import javax.annotation.processing.Filer
import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.element.Element
import javax.lang.model.element.Modifier

class KtProcessor : BasicAnnotationProcessor() {
    override fun initSteps(): Iterable<ProcessingStep?> {
        return mutableListOf(Step(processingEnv))
    }

    class Step(private val processingEnv: ProcessingEnvironment) : ProcessingStep {
        override fun process(elementsByAnnotation: SetMultimap<Class<out Annotation>, Element>?)
                : MutableSet<out Element> {
            val log = Log(processingEnv)
            println("hello kt processor $elementsByAnnotation")
            val main = MethodSpec.methodBuilder("main")
                .addModifiers(
                    Modifier.PUBLIC,
                    Modifier.STATIC
                )
                .returns(Void.TYPE)
                .addParameter(Array<String>::class.java, "args")
                .addStatement(
                    "\$T.out.println(\$S)",
                    System::class.java,
                    "Hello, JavaPoet!"
                )
                .build()
            log.w("hello koProcessor")
            val helloWorld = TypeSpec.classBuilder("HelloKt")
                .addModifiers(
                    Modifier.PUBLIC,
                    Modifier.FINAL
                )
                .addMethod(main)
                .build()
            val javaFile = JavaFile.builder("xyz.magicer.mdroid", helloWorld)
                .build()
            try { // 最后要将内容写入到 java 文件中，这里必须使用 processingEnv 中获取的 Filer 对象
                // 它会自动处理路径问题，我们只需要定义好包名类名和文件内容即可。
                val filer: Filer = processingEnv.getFiler()
                javaFile.writeTo(filer)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return mutableSetOf()

        }

        override fun annotations(): MutableSet<out Class<out Annotation>> {
            return mutableSetOf(TestKt::class.java)
        }

    }
}