##--------------- Begin: Proguard configuration for SQLCipher  ----------

# Keep all classes and interfaces in the net.sqlcipher package
-keep, includedescriptorclasses class net.sqlcipher.** { *; }
-keep, includedescriptorclasses interface net.sqlcipher.** { *; }

##--------------- Begin: Proguard configuration for Retrofit ----------

# Retrofit does reflection on generic parameters.
# InnerClasses is required to use Signature, and EnclosingMethod is required to use InnerClasses.
-keepattributes Signature, InnerClasses, EnclosingMethod, Exceptions

# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform

# Retrofit does reflection on method and parameter annotations.
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations

# Retain service method parameters when optimizing.
-keepclassmembers, allowshrinking, allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}
-keep interface com.compose.androidexpertc1.core.data.source.remote.network.ApiService

# Ignore JSR 305 annotations for embedding nullability information.
-dontwarn javax.annotation.**

# Guarded by a NoClassDefFoundError try/catch and only used when on the classpath.
-dontwarn kotlin.Unit


# Top-level functions that can only be used by Kotlin.
-dontwarn retrofit2.KotlinExtensions
-dontwarn retrofit2.KotlinExtensions$*

# With R8 full mode, generic signatures are stripped for classes that are not kept.
-keep, allowobfuscation, allowshrinking class retrofit2.Response

# With R8 full mode, it sees no subtypes of Retrofit interfaces since they are created with a Proxy
# and replaces all potential values with null. Explicitly keeping the interfaces prevents this.
-if interface * { @retrofit2.http.* <methods>; }
-keep, allowobfuscation interface <1>

-dontwarn kotlinx.**
-dontwarn okio.**
-dontwarn javax.annotation.Nullable
-dontwarn javax.annotation.ParametersAreNonnullByDefault

# Keep classes in specific packages
-keep class com.compose.androidexpertc1.core.data.mappers.** { *; }
-keep class com.compose.androidexpertc1.core.data.source.remote.model.** { *; }
-keep class com.compose.androidexpertc1.core.domain.model.** { *; }

-keepclassmembers, allowobfuscation class com.compose.androidexpertc1.core.data.source.remote.model.** { *; }

-keepclassmembers, allowobfuscation class * {
    @com.squareup.moshi.* *;
}

-keep class com.compose.androidexpertc1.core.data.source.local.dao.** { *; }
-keep class com.compose.androidexpertc1.core.data.source.local.entity.** { *; }

-keepattributes *Annotation*
-keepclassmembers class * {
    @androidx.room.* <methods>;
}


# R8 full mode strips generic signatures from return types if not kept.
-if interface * { @retrofit2.http.* public *** *(...); }
-keep, allowoptimization, allowshrinking, allowobfuscation class <3>

-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation
