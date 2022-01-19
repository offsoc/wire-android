package com.wire.android.ui.conversation

import com.wire.android.ui.conversation.model.AvailabilityStatus
import com.wire.android.ui.conversation.model.Conversation
import com.wire.android.ui.conversation.model.ConversationFolder
import com.wire.android.ui.conversation.model.ConversationInfo
import com.wire.android.ui.conversation.model.EventType
import com.wire.android.ui.conversation.model.Membership
import com.wire.android.ui.conversation.model.NewActivity
import com.wire.android.ui.conversation.model.UserInfo

val mockConversations = listOf(
    Conversation(
        userInfo = UserInfo(),
        conversationInfo = ConversationInfo(
            name = "some test value",
            memberShip = Membership.Guest,
            isLegalHold = true
        )
    ),
    Conversation(
        userInfo = UserInfo(
            availabilityStatus = AvailabilityStatus.Available
        ),
        conversationInfo = ConversationInfo(
            name = "some other test value",
            isLegalHold = true
        )
    ),
    Conversation(
        userInfo = UserInfo(
            availabilityStatus = AvailabilityStatus.Busy
        ),
        conversationInfo = ConversationInfo(
            name = "and once more 1",
            memberShip = Membership.External
        )
    ),
    Conversation(
        userInfo = UserInfo(
            availabilityStatus = AvailabilityStatus.Away
        ),
        conversationInfo = ConversationInfo(
            name = "and once more 2",
            isLegalHold = true
        )
    ),
    Conversation(
        userInfo = UserInfo(),
        conversationInfo = ConversationInfo(
            name = "and once more 3",
            memberShip = Membership.External
        )
    ),
    Conversation(
        userInfo = UserInfo(),
        conversationInfo = ConversationInfo(
            name = "and once more 4",
            memberShip = Membership.External
        )
    ),
)

val mockConversation = Conversation(
    userInfo = UserInfo(),
    conversationInfo = ConversationInfo(
        name = "and once more 4",
        memberShip = Membership.External
    )
)

val mockData = mapOf(
    ConversationFolder("NEW ACTIVITY") to mockConversations,
    ConversationFolder("FOLDER NAME1") to mockConversations,
    ConversationFolder("SOME OTHER FOLDER") to mockConversations,
    ConversationFolder("SOME OTHER Folder1") to mockConversations,
    ConversationFolder("THIS IS A TEST FOLDER") to mockConversations,
    ConversationFolder(
        "THIS IS A TEST FOLDER WITH A VERY VERY VERY VERY" +
                " VERY VERY VERY VERY VERY VERY VERY " +
                "VERY VERY VERY VERY VERY LONG NAME"
    ) to mockConversations
)


@Suppress("MagicNumber")
val newActivitiesMockData = listOf(
    NewActivity(EventType.MissedCall, mockConversation),
    NewActivity(EventType.UnreadMention, mockConversation),
    NewActivity(EventType.UnreadReply, mockConversation),
    NewActivity(EventType.UnreadMessage(2), mockConversation),
    NewActivity(EventType.UnreadMessage(1000000), mockConversation),
    NewActivity(EventType.UnreadMessage(0), mockConversation),
    NewActivity(EventType.UnreadMessage(50), mockConversation),
    NewActivity(EventType.UnreadMessage(99), mockConversation),
    NewActivity(EventType.UnreadMention, mockConversation),
    NewActivity(EventType.UnreadReply, mockConversation)
)
