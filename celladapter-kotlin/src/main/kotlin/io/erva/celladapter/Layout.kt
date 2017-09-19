package io.erva.celladapter

import android.support.annotation.LayoutRes

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Layout(@LayoutRes val layout: Int)