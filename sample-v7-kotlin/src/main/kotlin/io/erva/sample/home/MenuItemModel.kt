package io.erva.sample.home

import android.support.annotation.StringRes

data class MenuItemModel(@StringRes val titleId: Int, val clazz: Class<*>)