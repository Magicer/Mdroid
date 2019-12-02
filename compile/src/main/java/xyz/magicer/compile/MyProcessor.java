package xyz.magicer.compile;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.auto.service.AutoService;
import com.google.common.collect.SetMultimap;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;

import xyz.magicer.common.Test;

@AutoService(MyProcessor.class)
public class MyProcessor extends BasicAnnotationProcessor {
    @Override
    protected Iterable<? extends ProcessingStep> initSteps() {
       ArrayList s = new ArrayList<ProcessingStep>();
       s.add(new MyProcessingStep());
        return s;
    }


    class MyProcessingStep implements ProcessingStep{

        @Override
        public Set<? extends Class<? extends Annotation>> annotations() {
            Set s = new HashSet<Class>();
            s.add(Test.class);
            return s;
        }

        @Override
        public Set<? extends Element> process(SetMultimap<Class<? extends Annotation>, Element> elementsByAnnotation) {
//            val rejectedElements = mutableSetOf<Element>()
            Set set = new HashSet<Element>();

            MethodSpec main = MethodSpec.methodBuilder("main")
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                    .returns(void.class)
                    .addParameter(String[].class, "args")
                    .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                    .build();
            TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                    .addMethod(main)
                    .build();
            JavaFile javaFile = JavaFile.builder("xyz.magicer.mdroid", helloWorld)
                    .build();
            try {
                // 最后要将内容写入到 java 文件中，这里必须使用 processingEnv 中获取的 Filer 对象
                // 它会自动处理路径问题，我们只需要定义好包名类名和文件内容即可。
                Filer filer = processingEnv.getFiler();
                javaFile.writeTo(filer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return set;
        }
    }
}
