
package com.libandexample.courses.udemy.kotlin.pockemon

import android.location.Location

class  Pockemon(image: Int, name: String, des: String, power: Double, lat: Double, log: Double) {
    var name:String?= name
    var des:String?= des
    var image:Int?= image
    var power:Double?= power
    var location:Location?=null
    var IsCatch:Boolean?=false

    init {
        this.location= Location(name)
        this.location!!.latitude=lat
        this.location!!.longitude=log
        this.IsCatch=false
    }

}
