package com.example.misamigos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView?=null
    private var recyclerViewAdapter: adap?=null
    private var listfriend = mutableListOf<classdatos>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // se crea una arrae y se asignan variables para su futuro uso
        listfriend = ArrayList()
        recyclerView = findViewById(R.id.reciclebb)as RecyclerView
        recyclerViewAdapter = adap(listfriend)
        //Se crea variable par vista par los cuadros de amigos y se le asigna con los objetos ya creados
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager=layoutManager
        recyclerViewAdapter!!.setOnItemClickListener(object: ClickListener<classdatos> {
            override fun onItemClick(data: classdatos) {
                Toast.makeText(this@MainActivity, data.name, Toast.LENGTH_SHORT).show()
            }
        })
        recyclerView!!.adapter=recyclerViewAdapter
        infoamiko()
    }
    //se crea un metodo para llenar la lista con la informacion
    private fun infoamiko(){
        // se crea una variable para ir agregandole la informacion.y asi susecibamente para los demas
        var amik = classdatos("Melvito",R.drawable.melvito,"Chico listo, con buena autoestima y muy carismatico un poco timido")
        listfriend.add(amik)
        amik = classdatos("Chamba",R.drawable.chamba,"Chico guapo con buena autoestima carismatico amable y con carro")
        listfriend.add(amik)
        amik = classdatos("Gabo",R.drawable.gabo,"Chico inteligente carismatico y muy sociable habla con todas")
        listfriend.add(amik)
        amik = classdatos("Manco",R.drawable.manco,"Alias mango, Chico alto con buen carisma sociable amable y muy estudioso")
        listfriend.add(amik)
        amik = classdatos("jaime",R.drawable.jaima,"Chico con nuevo luck y que es sociable igual que gabo buen cariasma, solo pasa jugando videojuegos se cree gamer,")
        listfriend.add(amik)
        amik = classdatos("Diego",R.drawable.diego,"Chico de cuarto año, Admirador #1 de Emely carismatico y buena onda")
        listfriend.add(amik)
        amik = classdatos("Emely",R.drawable.emely,"Chica guapa,inteligente, chuca porque jaime lo dice y admirada por Diego ")
        listfriend.add(amik)
       // el recicle notifica que la informacion ha sido cambiada
        recyclerViewAdapter?.notifyDataSetChanged()
    }
}