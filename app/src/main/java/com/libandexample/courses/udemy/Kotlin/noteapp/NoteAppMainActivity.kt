package com.libandexample.courses.udemy.Kotlin.noteapp

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import com.libandexample.R
import kotlinx.android.synthetic.main.activity_main_note_app.*
import kotlinx.android.synthetic.main.ticcket.view.*


class MainActivity : AppCompatActivity() {

    private var listNotes=ArrayList<Note>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_note_app)

        // Add dummy data
        //listNotes.add(Note(1," meet professor","Create any pattern of your own - tiles, texture, skin, wallpaper, comic effect, website background and more.  Change any artwork of pattern you found into different flavors and call them your own."))
        //listNotes.add(Note(2," meet doctor","Create any pattern of your own - tiles, texture, skin, wallpaper, comic effect, website background and more.  Change any artwork of pattern you found into different flavors and call them your own."))
       // listNotes.add(Note(3," meet friend","Create any pattern of your own - tiles, texture, skin, wallpaper, comic effect, website background and more.  Change any artwork of pattern you found into different flavors and call them your own."))


Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show()

        //Load from DB


        LoadQuery("%")


    }

    override  fun onResume() {
        super.onResume()
        LoadQuery("%")
        Toast.makeText(this,"onResume",Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"onStart",Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()

        Toast.makeText(this,"onPause",Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()

        Toast.makeText(this,"onStop",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"onRestart",Toast.LENGTH_LONG).show()
    }


    fun LoadQuery(title:String){



        val dbManager= DbManager(this)
        val projections= arrayOf("ID","Title","Description")
        val selectionArgs= arrayOf(title)
        val cursor=dbManager.Query(projections,"Title like ?",selectionArgs,"Title")
        listNotes.clear()
        if(cursor.moveToFirst()){

            do{
                val ID=cursor.getInt(cursor.getColumnIndex("ID"))
                val Title=cursor.getString(cursor.getColumnIndex("Title"))
                val Description=cursor.getString(cursor.getColumnIndex("Description"))

                listNotes.add(Note(ID,Title,Description))

            }while (cursor.moveToNext())
        }

        val myNotesAdapter= MyNotesAdpater(this, listNotes)
        lvNotes.adapter=myNotesAdapter


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {

          menuInflater.inflate(R.menu.main_menu, menu)

          val sv: SearchView = menu.findItem(R.id.app_bar_search).actionView as SearchView

          val sm= getSystemService(Context.SEARCH_SERVICE) as SearchManager
          sv.setSearchableInfo(sm.getSearchableInfo(componentName))
          sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
              override fun onQueryTextSubmit(query: String): Boolean {
                  Toast.makeText(applicationContext, query, Toast.LENGTH_LONG).show()
                  LoadQuery("%"+ query +"%")
                  return false
              }

              override fun onQueryTextChange(newText: String): Boolean {
                  return false
              }
          })


        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item != null) {
            when(item.itemId){
                R.id.addNote->{
                    //Got to add paage
                    val intent= Intent(this, AddNotes::class.java)
                    startActivity(intent)
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }


    inner class  MyNotesAdpater(context: Context, private var listNotesAdpater: ArrayList<Note>) : BaseAdapter() {
        var context:Context?= context

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            val myView=layoutInflater.inflate(R.layout.ticcket,null)
            val myNote=listNotesAdpater[p0]
            myView.tvTitle.text=myNote.nodeName
            myView.tvDes.text=myNote.nodeDes
            myView.ivDelete.setOnClickListener({
                val dbManager= DbManager(this.context!!)
                val selectionArgs= arrayOf(myNote.nodeID.toString())
                dbManager.Delete("ID=?",selectionArgs)
                LoadQuery("%")
            })
            myView.ivEdit.setOnClickListener( View.OnClickListener{

                GoToUpdate(myNote)

            })
            return myView
        }

        override fun getItem(p0: Int): Any {
        return listNotesAdpater[p0]
         }

        override fun getItemId(p0: Int): Long {
           return p0.toLong()
         }

        override fun getCount(): Int {

            return listNotesAdpater.size

        }



    }


   fun GoToUpdate(note: Note){
       val intent=  Intent(this, AddNotes::class.java)
       intent.putExtra("ID",note.nodeID)
       intent.putExtra("name",note.nodeName)
       intent.putExtra("des",note.nodeDes)
       startActivity(intent)
   }


}
