package ru.pocket_notes.domain.entities

import io.realm.kotlin.ext.backlinks
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

// Category -> PocketCard
class PocketCard: RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var title: String = ""
    var url: String = ""
    val tags: RealmResults<Tag> by backlinks(Tag::pocketCards)
}