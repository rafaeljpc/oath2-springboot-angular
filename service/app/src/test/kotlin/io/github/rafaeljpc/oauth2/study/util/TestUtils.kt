package io.github.rafaeljpc.oauth2.study.util

private val GENERATED_IDS_SET = mutableSetOf<Int>()

fun generateId(range: IntRange): Int {
    var rnd: Int
    do {
        rnd = range.random()
    } while (GENERATED_IDS_SET.contains(rnd))
    GENERATED_IDS_SET.add(rnd)
    return rnd
}