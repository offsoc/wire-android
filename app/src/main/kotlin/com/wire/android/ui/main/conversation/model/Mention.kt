package com.wire.android.ui.main.conversation.model

data class Mention(
    val mentionInfo: MentionInfo,
    val conversation: Conversation
)

data class MentionInfo(val mentionMessage: MentionMessage)

data class MentionMessage(val message: String) {
    fun toQuote(): String = "\"$message\""
}
