package com.example.virtualfilesystem.domains.vfolders.models.entities

import com.example.coreweb.domains.base.entities.BaseTreeEntity
import javax.persistence.*

@Entity
@Table(name = "vfs_folders", schema = "vfs")
class VFolder : BaseTreeEntity<VFolder>() {

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "description", columnDefinition = "TEXT")
    var description: String? = null

    var thumbnail: String? = null

    @Column(name = "accent_color")
    var accentColor: String? = null


    fun getThumbnailElseParent(): String? {
        if (this.thumbnail != null && this.thumbnail?.isNotBlank()!!)
            return this.thumbnail
        return this.parent.orElse(null)?.getThumbnailElseParent()
    }

    override fun getImpl(): VFolder {
        return this
    }

}
