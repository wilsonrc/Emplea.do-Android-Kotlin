package com.wilsonrc.empleado

interface BasePresenter<in T> {
    fun attach(view: T)
    fun detach()
}