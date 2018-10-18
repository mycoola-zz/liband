package com.libandexample.courses.udemy.Kotlin.zooapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.libandexample.R
import kotlinx.android.synthetic.main.activity_zoo_app.*
import kotlinx.android.synthetic.main.animal_ticket.view.*


class ZooAppMainActivity : AppCompatActivity() {

    private var listOfAnimals = ArrayList<Animal>()
    private var adapter: AnimalsAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoo_app)
        //load  animals
        listOfAnimals.add(
                Animal("Baboon","Baboon live in  big place with tree", R.drawable.baboon,false))
        listOfAnimals.add(
                Animal("Bulldog","Bulldog live in  big place with tree",R.drawable.bulldog,false))
        listOfAnimals.add(
                Animal("Panda","Panda live in  big place with tree",R.drawable.panda,true))
        listOfAnimals.add(
                Animal("Swallow","Swallow live in  big place with tree",R.drawable.swallow_bird,false))
        listOfAnimals.add(
                Animal("Tiger","Tiger live in  big place with tree",R.drawable.white_tiger,true))
        listOfAnimals.add(
                Animal("Zebra","Zebra live in  big place with tree",R.drawable.zebra,false))

        adapter = AnimalsAdapter(this,listOfAnimals)
        tvListAnimal.adapter =  adapter


    }

    fun delete(index:Int){
        listOfAnimals.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }

    fun  add(index:Int){
        listOfAnimals.add(index,listOfAnimals[index])
        adapter!!.notifyDataSetChanged()
    }

   inner class  AnimalsAdapter(context: Context, private var listOfAnimals: ArrayList<Animal>) : BaseAdapter() {
       var context:Context?= context
       override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal =  listOfAnimals[p0]
            if( animal.isKiller ==true) {
                val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val myView = inflator.inflate(R.layout.animal_killer_ticket, null)
                myView.tvDes.text = animal.name!!
                myView.tvName.text = animal.des!!
                myView.ivAnimalImage.setImageResource(animal.image!!)
                myView.ivAnimalImage.setOnClickListener {

                    val intent = Intent(context, AnimalInfo::class.java)
                    intent.putExtra("name",animal.name!!)
                    intent.putExtra("des",animal.des!!)
                    intent.putExtra("image",animal.image!!)
                    context!!.startActivity(intent)


                }
                return myView

            }else {
                val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val myView = inflator.inflate(R.layout.animal_ticket, null)
                myView.tvDes.text = animal.name!!
                myView.tvDes.text = animal.des!!
                myView.ivAnimalImage.setImageResource(animal.image!!)
                myView.ivAnimalImage.setOnClickListener {
                    add(p0)

                    val intent = Intent(context, AnimalInfo::class.java)
                    intent.putExtra("name",animal.name!!)
                    intent.putExtra("des",animal.des!!)
                    intent.putExtra("image",animal.image!!)
                    context!!.startActivity(intent)


                }
                return myView
            }
        }

        override fun getItem(p0: Int): Any {
            return listOfAnimals[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {

            return  listOfAnimals.size
        }

    }
}
