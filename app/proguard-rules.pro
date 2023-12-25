# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Keep all classes in Coil package
-keep class coil.** { *; }

# Keep annotations used by Coil
-keep @coil.annotation.* class *

# Keep the Coil's extension functions
-keepclassmembers class * {
    @coil.annotation.internal.* <methods>;
}

# Keep the Coil's extension functions for Kotlin synthetic accessors
-keepclassmembers class * {
    synthetic <methods>;
}

# Keep the Coil's generated image loaders
-keep class coil.decode.* { *; }

# Keep the Coil's BitmapPool implementation
-keep class coil.memory.* { *; }

# Keep the Coil's network and cache implementations
-keep class coil.fetch.* { *; }

# Keep the Coil's request implementation
-keep class coil.request.* { *; }

# Keep the Coil's transformation implementation
-keep class coil.transform.* { *; }

# Keep the Coil's drawable implementations
-keep class coil.drawable.* { *; }

# Keep the Coil's SVG implementation
-keep class coil.extension.* { *; }


# Keep classes and methods used for Kotlin coroutines
-keep class kotlinx.coroutines.CoroutineExceptionHandler { *; }

-keep class androidx.compose.** { *; }
-keep class androidx.ui.** { *; }

-keepclassmembers class * {
    @androidx.compose.runtime.* <methods>;
}


# With R8 full mode generic signatures are stripped for classes that are not
# kept. Suspend functions are wrapped in continuations where the type argument
# is used.
-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation

# R8 full mode strips generic signatures from return types if not kept.
-if interface * { @retrofit2.http.* public *** *(...); }
-keep,allowoptimization,allowshrinking,allowobfuscation class <3>

-keepnames @dagger.hilt.android.lifecycle.HiltViewModel class * extends androidx.lifecycle.ViewModel