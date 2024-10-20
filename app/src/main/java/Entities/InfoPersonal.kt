package Entities

class InfoPersonal {
    private var _id: String =""
    private var _name: String =""
    private var _lastName: String=""
    private var _phone: Int = 0
    private var _email: String=""


    constructor()

    constructor(id: String, name: String, lastName: String, phone: Int, email: String){
        this._id= id
        this._name= name
        this._lastName = lastName
        this._phone=phone
        this._email=email

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



}