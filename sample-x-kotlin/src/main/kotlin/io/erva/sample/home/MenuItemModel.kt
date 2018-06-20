package io.erva.sample.home

import androidx.annotation.StringRes

data class MenuItemModel(@StringRes val titleId: Int, val clazz: Class<*>)