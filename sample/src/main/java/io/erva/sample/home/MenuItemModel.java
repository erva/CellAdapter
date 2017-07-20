package io.erva.sample.home;

import android.support.annotation.StringRes;

public class MenuItemModel {

    @StringRes final int titleId;
    final Class clazz;

    public MenuItemModel(@StringRes int titleId, Class clazz) {
        this.titleId = titleId;
        this.clazz = clazz;
    }
}