package com.cube.googleplay.examples.di

class DependenciesNotInitializedException : Exception(
    "dependencies are not initialized, \n" +
            "you should invoke init(context) method before using any dependencies, " +
            "which DependenciesManger provides"
)