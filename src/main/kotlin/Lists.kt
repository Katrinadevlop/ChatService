package ru.netology.chat

fun List<Message>.takeLastAlive(n: Int): List<Message> =
    asReversed().asSequence().filter { !it.isDeleted }.take(n).toList().asReversed()

fun List<Message>.lastAlive(): Message? =
    asReversed().firstOrNull { !it.isDeleted }

fun List<Message>.hasUnreadFor(userId: Int): Boolean =
    any { !it.isDeleted && !it.isRead && it.toId == userId }
