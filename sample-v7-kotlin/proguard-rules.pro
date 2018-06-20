#CellAdapter
-dontwarn io.erva.celladapter.**
-keep public class kotlin.reflect.jvm.internal.impl.builtins.* { public *; }
-keepclassmembers class * extends io.erva.celladapter.** {
    <init>(android.view.View);
}