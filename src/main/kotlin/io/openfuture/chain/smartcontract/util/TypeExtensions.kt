package io.openfuture.chain.smartcontract.util

val String.asPackagePath: String get() = this.replace('/', '.')

val String.asResourcePath: String get() = this.replace('.', '/')