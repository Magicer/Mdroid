package xyz.magicer.compilekt

import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.element.Element
import javax.tools.Diagnostic

class Log(private val processingEnv: ProcessingEnvironment){

    fun w(msg: String, vararg args: Any) {
//        messager.printMessage(Diagnostic.Kind.NOTE, msg.safeFormat(args))
        printMessage(Diagnostic.Kind.WARNING,msg,null)
    }

    private fun printMessage(kind: Diagnostic.Kind, msg: String, element: Element?) {
        processingEnv.messager.printMessage(
            kind,
            msg,
            element)
    }
}