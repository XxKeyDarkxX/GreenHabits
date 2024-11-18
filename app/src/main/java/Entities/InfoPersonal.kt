package Entities

import android.net.Uri

class InfoPersonal {
    private var _id: String =""
    private var _name: String =""
    private var _lastName: String=""
    private var _phone: Int = 0
    private var _email: String=""
    private var _imageUri: Uri? = null
    private var _imageUriPhoto: Uri? = null


    constructor()

    constructor(id: String, name: String, lastName: String, phone: Int, email: String,imageUri: Uri,imageUriPhoto: Uri){
        this._id= id
        this._name= name
        this._lastName = lastName
        this._phone=phone
        this._email=email
        this._imageUri = imageUri
        this._imageUriPhoto = imageUriPhoto
    }

    var id: String
        get() = this._id
        set(value) {this._id = value}

    var name: String
        get() = this._name
        set(value) {this._name = value}

    var lastName: String
        get() = this._lastName
        set(value) {this._lastName = value}

    val fullName get() = this._name + " " + this._lastName

    var phone: Int
        get() = this._phone
        set(value) {this._phone = value}

    var email: String
        get() = this._email
        set(value) {this._email = value}

    var imageUri: Uri?
        get() = this._imageUri
        set(value) { this._imageUri = value }

    var imageUriPhoto: Uri?
        get() = this._imageUriPhoto
        set(value) { this._imageUriPhoto = value }


}